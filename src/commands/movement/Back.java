package commands.movement;



public class Back extends Movement{


	@Override
	public double move(double pixels) {
		return -pixels;
	}



}
