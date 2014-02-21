slogo
=====
TODO:
1. Describe the goals of your project's design (i.e., what you want to make flexible and what assumptions you may need to make) by breaking it into modules.
2. Describe the program's core architecture, core structure, and snap shot of UML
3. Example code
4. Alternative design

faTeam member Responsibility breakdown:
Lee Weisberger and Shenghan Chen: Back-end
Anthony Olawo and Siyang Wang: Front-end:
	1: Graphic Layout (Olawo and Wang will peer program this part)
	2: Data I/O (Olawo and Wang will peer program this part)
	3: Drawing functionalities (Olawo)
	4: Buttons(Wang)

API:

Interface:
	Potential classes:
		Panel:
		Window (abstract)
			Sample Commands
			Turtle Graphics 
Command Window 
Command History
		Buttons (abstract)
			Run buttons: Speed selection
			Change color:
			Clear
			Undo
			Terminate when infinite loop

	
			
Model:
Parsing(module):
Abstract Syntax Tree:
	Command classes(module): 
		e.g. for loop, repeat, if statement, forward, etc…
			e.g. rt, fd, 
	Turtle Graphics and pen (module)

	Potential Classes:
		Parser
		General Command
		Variable, Constant, Repeat 

Turtle:
	

Potentially: 
	Mediator design pattern 
		Transform the user inputs to commands -- > place we can detect errors 

Assumptions:
	Passing the command tree once at a time V.S. passing the command trees together once 


Primary Classes and Methods
Describe the program's core architecture (focus on behavior not state), including pictures of a UML diagram to describe the Model and "screen shots" of your intended View interface

The program is generally devided into the Model, the View Interface(GUI), and the Turtle component. The model part is responsible for parsing (by Lexer/Abstract Syntax Tree), storing the user-typed commands, and then calling the command classes in the Model package, which are the sub-classes of a command super class. Each of the command classes individually corresponds to simple syntax with constants used to draw forward, squares, and triangles; simple syntax with variables; loops, loops with variables; procedures, including the ones with variables, and those with recursion. 

Another important component is the Turtle class. It is an independent class that lives between the Model and the Interface. Model calls Turtle once it finishes parsing, and then turtle calls the TurtleGraphics that extends some GUI tools in the View Interface. 

The View Interface is the third important component, and its responsibility is to be called by Turtle and then perform the basic methods like draw(), rotate(), changeColor(). The turtle is passed into the turtleGraphics where all the drawings are implemented. Moreover, the View Interface also has some additional functionalities: get History, move fast, move slow, clear -- these correspond to buttons, and onClick. The View Interface will call TurtleGraphics to make adjustments and implement any additions in the drawing process. 



