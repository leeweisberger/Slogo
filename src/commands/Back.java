package commands;

public class Back extends Movement{


	@Override
	public double move(double pixels) {
		return -pixels;
	}

	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}

}
