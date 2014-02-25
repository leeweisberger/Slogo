package command;

public class BooleanOperations {

	public int lessp(double expr1, double expr2){
		if (expr1 < expr2) return 1;
		return 0;
	}
	
	public int greaterp(double expr1, double expr2){
		if (expr1 > expr2) return 1;
		return 0;
	}
	
	public int equalp(double expr1, double expr2){
		if (expr1 == expr2) return 1;
		return 0;
	}
	
	public int notequalp(double expr1, double expr2){
		if (expr1 != expr2) return 1;
		return 0;
	}
	
	public int and(double test1, double test2){
		if (test1 != 0 && test2 != 0) return 1;
		return 0;
	}
	
	public int or(double test1, double test2){
		if (test1 != 0 || test2 != 0) return 1;
		return 0;
	}
	
	public int not(double test){
		if (test == 0) return 1;
		return 0;
	}
}
