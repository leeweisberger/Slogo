package command;

public class MathOperations {
	
	public double sum(double expr1, double expr2){
		return expr1 + expr2;
	}
	
	public double difference(double expr1, double expr2){
		return expr1 - expr2;
	}
	
	public double product(double expr1, double expr2){
		return expr1 * expr2;
	}
	
	public int quotient(int expr1, int expr2){
		return expr1 / expr2;
	}
	
	public int remainder(int expr1, int expr2){
		return expr1 % expr2;
	}
	
	public double minus(double expr){
		return - expr;
	}
	
	public double random(double max){
		return Math.random() * max;
	}
	
	private double D2R(double degrees){
		return Math.toRadians(degrees);
	}
	
	public double sin(double degrees){
		return Math.sin(D2R(degrees));
	}
	
	public double cos(double degrees){
		return Math.cos(D2R(degrees));
	}
	
	public double tan(double degrees){
		return Math.tan(D2R(degrees));
	}
	
	public double atan(double degrees){
		return Math.toDegrees(Math.atan(degrees));
	}
	
	public double log(double expr){
		return Math.log(expr);
	}
	
	public double pow(double base, double exponent){
		return Math.pow(base, exponent);
	}
}