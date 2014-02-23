package commands;

/*
 * Abstract super class that defines a general Command
 */
public abstract class Command {
	int myNumInputs;
	
	public int getNumInputs(){
		return myNumInputs;
	}
	
	public abstract void doCommand();
}
