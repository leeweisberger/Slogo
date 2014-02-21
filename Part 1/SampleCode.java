package slogo_team02;

public class SampleCode {
	//user types fd 50
	public SampleCode(CommandWindow commandWindow, TurtleGraphic turtleGraphic) {
		File file = commandWindow.saveFile();
		Parser parser = new Parser(file);
		aST = new AbstractSyntaxTree(parser.lexer());
		Turtle turtle = new Turtle();
		traverse aST...
			Command command = new typeOfCommand(infoFromAbstractSyntaxTree);
			command.sendInfoToTurtle();
			turtle.setNewPosition();
			turtle.paintLocation();
			turtleGraphic.drawTurtle();	
	}
}
