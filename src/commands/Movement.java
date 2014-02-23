package commands;


/*
 * Abstract super class for all turtle movements
 */
public abstract class Movement extends CommandOneInput{
	//get current angle from the state
	
	//get pixels from the tree
	double pixels=5;
	double pixelsMoved = move(pixels);
	//calculate the new position that is to be moved to
	//to do
	public  abstract double move(double pixels);
		
}
