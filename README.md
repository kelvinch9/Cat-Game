# final-project-team68_platformer
final-project-team68_platformer created by GitHub Classroom

**Members:** Danielle Coates, Matthew Ordway, Kelvin Cheung
**Overview:** We are creating a scrolling platformer game. The game theme is a cat who jumps over or ducks under obstacles.
The cat can also collect mice for points. The gameplay gets faster as the game continues.

**Initial breakdown of work:**

Danielle: Score, Collision Checker, Random Generation 

Matt: Game State

Kelvin: Char input, Objects

****

**Initial classes and methods:**

Object Class (xPos, yPos, widt, height)

	(Method) - Update Position
	
	Cat
		(Method) - Jump
		(Method) - Duck
		//(Method) - Update image
		
	Jump Objects
	
	Duck Objects
	
	Coin Objects

Main

Graphics Context

Animation Timer

	(Method) - Collision Checker
	
	(Method) - Move objects
	
	(Method) - Event Handler (input)
	
	(Method) - Score [distance]
	
	(Method) - Random Stage Generator
	
	
Player Score (int score)

	(Method) - Calculatied distance score (distance score)
	
	(Method) - Mice collected score (mice only)
	
	(Method) - Printing total/each score on screen (total)
	
	
Game State

	End Game (Method)
	
		(Method) - High Score array / Max Score
		
		(Method) - Stops Game
		
		(Method) - Replay?
		
	
	Start Game
	
		(Method?) - Sets the stage/scene to start game
		

	Intro
	
		(Method?) - Starts the intro/tutorial for game
		
		(Method) - Press "Start" to start the game. Press "Credit" to see the game authors
		

Unit Test: Collision Checker
	


