package commands.movement;



/**
 * The Class Back.
 */
public class Back extends Movement{


	@Override
	public double move(double pixels) {
		return -pixels;
	}



}
