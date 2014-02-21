slogo
=====
TODO:
1. Describe the goals of your project's design (i.e., what you want to make flexible and what assumptions you may need to make) by breaking it into modules.
2. Describe the program's core architecture, core structure, and snap shot of UML
3. Example code
4. Alternative design

Team member Responsibility breakdown:
Lee Weisberger and Shenghan Chen: Back-end
Anthony Olawo and Siyang Wang: Front-end:
	1: Graphic Layout (Olawo and Wang will peer program this part)
	2: Data I/O (Olawo and Wang will peer program this part)
	3: Drawing functionalities (Olawo)
	4: Buttons(Wang)

Design Goals:
The team is designing and implementing a flexible GUI program-- SLogo-- whose functionality can be used and/or extended via an API. Like most standard GUI programs SLogo will have a view and model. The view will consist of four modules: a graphic layout module, a 'draw' module, an action listener module and a command history module. The model on the other hand will consist of a parsing module, and a command module. The program will also have a turtle module distinct from both the view and model. 

View Modules
The graphic layout module will be a canvas responsible for laying out the windows and buttons that the user will interract with. These include command, turtle graphics, command, and command history windows, as well as run, stop, clear, slow, and undo button. This module will be designed to allow future developers to add windows and buttons to it. 

The draw module's will draw the turtle and trace its movements on the turtle graphics window. Here  the team assumed that the module would only ever have to draw a single turtle at a time because all other implementations of logo had a single turtle. That said, it will be designed to allow future developers extend the manner in which the turtle is drawn and its movements traced eg. the type of turtle drawn, the thickness, color and style of the trace etc.


The action listener module's primary goal will be to communicate user input from the graphic layout module to the model and then query the turtle module in order to update the graphic layout module. A developer should only need to extend this after they have already extended either the graphical layout module-- which it takes input from to pass to the model-- or the turtle-- which it takes input from to update the view's draw module and command history module.

The command history module will be responsible for keeping track of and displaying the commmands entered in the command window of the graphical layout module. 

Model: 
The parsing module's primary goal will be to take raw input from the action listener module and parse it into commands. The module should be capable of parsing a line at a time or more. 

The command module will then instantiate the respective commands. This module will need to be flexible since it lexicographs a huge part of the turtle's behaviour and other developers may want to extend this behaviour.

The turtle module will take the instantiated commands from the command module and interpret them into a form that the action listener module can understand. This module will need to be flexible as well because it will need to mirror any extension to the command module.sica adimora 


Primary Classes: 
View:
		GraphicalLayout.java
		
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

The program is generally divided into the Model, the View Interface(GUI), and the Turtle component. The model part is responsible for parsing (by Lexer/Abstract Syntax Tree), storing the user-typed commands, and then calling the command classes in the Model package, which are the sub-classes of a command super class. Each of the command classes individually corresponds to simple syntax with constants used to draw forward, squares, and triangles; simple syntax with variables; loops, loops with variables; procedures, including the ones with variables, and those with recursion. 

Another important component is the Turtle class. It is an independent class that lives between the Model and the Interface. Model calls Turtle once it finishes parsing, and then TurtleGraphics, that extends some GUI tools in the View Interface, calls Turtle. 

The View Interface is the third important component, and its responsibility is to call Turtle and then perform the basic methods like draw(), rotate(), changeColor(). The turtle is passed into the turtleGraphics where all the drawings are implemented. Moreover, the View Interface also has some additional functionalities: get History, move fast, move slow, clear -- these correspond to buttons, and onClick. The View Interface will call TurtleGraphics to make adjustments and implement any additions in the drawing process. 



