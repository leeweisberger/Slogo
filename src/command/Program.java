package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import parse.Lexer.Token;
import slogo_team02.Controller;
import slogo_team02.TurtleState;

public class Program {
	
	private TurtleState myTurtle;
	private TurtleCommands myTurtleCommands;
	private TurtleQueries myTurtleQueries;
	private MathOperations myMathOperations;
	private BooleanOperations myBooleanOperations;
	private ControlStructures myControlStructures;
	
	public Program(TurtleState turtleState){
		myTurtle = turtleState;
		myTurtleCommands = new TurtleCommands(myTurtle);
		myTurtleQueries = new TurtleQueries(myTurtle);
		myMathOperations = new MathOperations();
		myBooleanOperations = new BooleanOperations();
		myControlStructures = new ControlStructures(this);
	}
	
	public double execute(List<String> tokenList){
		
		double result = -1;
		
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
				if (isCS(cmd)){
					while (!lstStack.empty()){
						lstStack.pop();
						curArg --;
					}
					double cst = cstStack.pop();
//					for (int i=0; i<curArg; i++)
//						cstStack.pop();
					result = cmdCall(cmd, cst);
				}
				else {	
					double cst = cstStack.pop();
//					for (int i=0; i<curArg; i++)
//						cstStack.pop();
					result = cmdCall(cmd,cst);
				}
				cstStack.push(result);
				System.out.println("reached");
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
		
		return result;
	}
	
	public String cmdType(String cmd){
		String constant = "-?[0-9]+.?[0-9]*";
		if (cmd.matches(constant)){
			return "Constant";
		}
		if (cmd.matches("[a-zA-z_]+(/?)?")){
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
		if (cmd.equals("SetHeading")){
			return 1;
		}
		if (cmd.equals("Forward")){
			return 1;
		}
		if (cmd.equals("Sum")){
			return 2;
		}
		return 0;
	}
	
	public double cmdCall(String cmd, Double cst){
		if (cmd.equals("SetHeading")){
			return myTurtleCommands.setheading(cst);
		}
		if (cmd.equals("Forward")){
			return myTurtleCommands.forward(cst);
		}
		if (cmd.equals("Sum")){
			return myMathOperations.sum(cst,cst);
		}
		return 0;
	}
	
	public boolean isCS(String cmd){
		String[] array = {"repeat", "if", "ifelse"};
		List<String> cs = Arrays.asList(array);
		return cs.contains(cmd);
	}
	
	public List<String> tempSplit(String input){
		return Arrays.asList(input.split(" "));
	}
	
	public static void main(String[] args) {
		TurtleState turtle = new TurtleState(0,0,0);
		Program prog = new Program(turtle);
		List<String> list = prog.tempSplit("Repeat 4 [ Forward 5 ]");
		double result = prog.execute(list);
		System.out.println(turtle.getAngle());
	}
}
