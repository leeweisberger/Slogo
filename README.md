slogo
=====
TODO:
1. Describe the goals of your project's design (i.e., what you want to make flexible and what assumptions you may need to make) by breaking it into modules.
2. Describe the program's core architecture, core structure, and snap shot of UML
3. Example code
4. Alternative design


Team member Responsibility breakdown:
Lee Weisberger and Shenghan Chen: Back-end
Anthony Olawo and Siyang Wang: Front-end

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



