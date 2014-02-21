/**I was looking at some sample projects from CS 201. 
 * I just saw an example of how the model and the view are separated and interacting.**/

public class RandomThoughts {
	
	/**Say, we have a main class, which just creates a new object of Model class and View class, 
	 * respectively; and this is likely all it has to do. **/
	
	public class SLogo {
	    public static void main(String[] args){
	        SLogoModel model = new SLogoModel();
	        SLogoViewer viewer = new SLogoViewer();
	    }
	}
	
	/**The View class has the model as one of its fields, while the Model class has the view 
	 * as one of its fields. In their constructors certain major methods are called. Within some of 
	 * the model's methods we could call the view's methods on the field myView; this is to tell 
	 * the View what to do (paint, draw lines, etc) according to the moves the turtle takes. **/
	
	public class SLogoModel {
	    private SLogoViewer myView; 
	    //among other fields
	    
	    public SLogoModel() {
	        //initialize the turtle
	    }

	    public void addView(SLogoViewer view) {
	        myView = view;
	    }

	    public void some_kinda_move(){
	    	//take some actions to update the turtle (eg. fd 50)
	        myView.some_kinda_repsond();//keep the turtle graphic undated as well
	    }
	    
	    
	    /**you might have to take a look at the View class below before you can understand this method**/
	    public void executeCommands(AbstractSyntaxTree aST){
	    	//for each command in the whole set, we call a corresponding method
	    	traverse aST...{
		    	some_kinda_move();
		    	//among other moves
	    	}
	    }
	    
	    //among other methods
	}
	
	/**For the communication in the other direction, we have some alternatives. 
	 * If we just name the turtle as our model (which might possibly work?), 
	 * in the View class we will have a method like processInput() that takes 
	 * as arguments whatever text a user types, calls a parser to interpret that text 
	 * into a set of commands that's somewhat readable, (could be in the format of an ast, 
	 * or whatever structure that we figure out later) and passes the entire set 
	 * to the model to be understood and executed. See the last method in the View class below, 
	 * and the last method in the Model class above**/
	
	public class SLogoViewer {
	    private SLogoModel myModel; 
	    //among other fields
	    
	    public SLogoViewer() {
	        //initialize the view and maybe a listener for user input (also call some methods that 
	    	//monitor the buttons?)
	    }
	    
	    public void setModel(SLogoModel model) {
	        myModel = model;
	        model.addView(this);
	    }
	    
	    public void some_kinda_respond(){
	    	//update the turtle graphic every time a command is executed in the Model, 
	    	//usually called within the model's methods
	    }
	    
	    
	    /** this method might be where the difference is **/
	    public void processInput(){
	    	//as Lee coded in SampleCode
	    	Parser parser = new Parser(file);
			aST = new AbstractSyntaxTree(parser.lexer());
			
			//Here I'm supposing we pass the entire program to the model to be executed, 
			//(and as I noted above the view responds each time the turtle takes a move)
			myModel.executeCommands(aST);
	    }
	    
	}
	
	
	/**Stated above is how I brutely split the view and the model. Another solution is to add 
	 * a true Model class that's separated from the turtle class, which includes the parsing and ast
	 * making process, and creates a new turtle object and execute commands from the ast one by one 
	 * on this turtle object. So basically, view calls model, model calls turtle, and turtle calls view 
	 * (seems like not much difference?) **/
	
}
