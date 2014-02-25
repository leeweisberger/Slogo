package command;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import slogo_team02.TurtleState;

public class Program {
	
	private TurtleState myTurtle;
	private TurtleCommands myTurtleCommands;
	private TurtleQueries myTurtleQueries;
	private MathOperations myMathOperations;
	private BooleanOperations myBooleanOperations;
	private ControlStructures myControlStructures;
	
	private Map<String, Method> myCmdMap;
	
	public Program(TurtleState turtleState){
		myTurtle = turtleState;
		myTurtleCommands = new TurtleCommands(myTurtle);
		myTurtleQueries = new TurtleQueries(myTurtle);
		myMathOperations = new MathOperations();
		myBooleanOperations = new BooleanOperations();
		myControlStructures = new ControlStructures(this);
	}
	
	public void makeMenu(){
		myCmdMap = new HashMap<String, Method>();
		Method[] methods = Object.class.getMethods();
		List<Method> common = Arrays.asList(methods);
		
		Class[] classes = {TurtleCommands.class, TurtleQueries.class, 
				MathOperations.class, BooleanOperations.class, ControlStructures.class};
		for (Class cl : classes){
			for (Method method : cl.getMethods()){
				if (!common.contains(method))
					myCmdMap.put(method.getName(), method);
			}
		}
	}
	
	public double execute(List<String> tokenList){
		
		int inList = 0;
		List<String> inBracket = new ArrayList<String>();
		
		Stack<Double> cstStack = new Stack<Double>();
		Stack<String> cmdStack = new Stack<String>();
		Stack<List<String>> lstStack = new Stack<List<String>>();
		Stack<Integer> argStack = new Stack<Integer>();
		int curArg = -1;
		Stack<Integer> numStack = new Stack<Integer>();
		int curNum = 0;
		
		for (String token: tokenList){
			
			if (inList > 0){
				if (token.equals("["))
					inList += 1;
				if (token.equals("]"))
					inList -= 1;
				if (inList > 0){
					inBracket.add(token);
					continue;
				}
				else {
					lstStack.push(inBracket);
					curNum += 1;
				}
			}
			
			if (token.equals("[")){
				inList += 1;
				inBracket.clear();
				continue;
			}
			
			
			
			
			
			if (cmdType(token).equals("Command")){
				cmdStack.push(token);
				if (curArg != -1){
					argStack.push(curArg);
					numStack.push(curNum);
				}
				curArg = cmdArg(token);
				curNum = 0;
			}
			
			if (cmdType(token).equals("Constant")){
				cstStack.push(cmd2dbl(token));
				curNum += 1;
			}
			
			
			
			while (curNum == curArg){
				String cmd = cmdStack.pop();
				Object[] params = new Object[curArg];
				while (!lstStack.empty()){
					curArg --;
					params[curArg] = lstStack.pop();
				}
				while (curArg > 0){
					curArg --;
					params[curArg] = cstStack.pop();
				}
				
				cstStack.push(cmdCall(cmd, params));
				if (cmdStack.empty()){
					curArg = -1;
					curNum = 0;
				}
				else {
					curArg = argStack.pop();
					curNum = numStack.pop() + 1;
				}
			}
		}
		
		if (!cmdStack.empty()){
			//report error; where to put that method? has something to do with the view
		}
		
		return cstStack.pop();
	}
	
	public String cmdType(String cmd){
		if (cmd.equals("]"))
			return cmd;
		String constant = "-?[0-9]+\\.?[0-9]*";
		if (cmd.matches(constant)){
			return "Constant";
		}
		if (cmd.matches("[a-zA-z_]+(\\?)?")){
			return "Command";
		}
		return cmd;
	}
	
	public double cmd2dbl(String cmd){
		if (!cmdType(cmd).equals("Constant"))
			return -1;
		return Double.parseDouble(cmd);
	}
	
	public int cmdArg(String cmd){
		return myCmdMap.get(cmd).getParameterTypes().length;
	}
	
	public double cmdCall(String cmd, Object[] params){
		if (!myCmdMap.containsKey(cmd)){
			return -1;
		}
		Method method = myCmdMap.get(cmd);
		Field[] fields = this.getClass().getDeclaredFields();
		List<Field> list = Arrays.asList(fields);
		Object obj = new Object();
		for (Field field: list){
			if (field.getType() == method.getDeclaringClass())
				try {
					obj = field.get(this);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		//System.out.println(obj);
		try {
//			if (params[0] == null)
//				System.out.println(method);
			return (Double) method.invoke(obj, params);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<String> tempSplit(String input){
		return Arrays.asList(input.split(" "));
	}
	
	public static void main(String[] args) {
		TurtleState turtle = new TurtleState(0,0,0);
		Program prog = new Program(turtle);
		prog.makeMenu();
		List<String> list = prog.tempSplit("REPEAT 5 [ forward sum 5 sum 6 6 ]");
		double result = prog.execute(list);
		System.out.format("%f %f %f", turtle.getX(), turtle.getY(), turtle.getAngle());
	}
}
