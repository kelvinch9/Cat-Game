# final-project-team68_platformer
final-project-team68_platformer created by GitHub Classroom

**Members:** Danielle Coates, Matthew Ordway, Kelvin Cheung

**Overview:** We are creating a scrolling platformer game. The game theme is a cat who jumps over obstacles. The cat can also collect coins for points. The gameplay gets faster as the game continues.

**User Needs:** We used Swing as our GUI, which is automatically built into Java, so no additional downloads are needed for that.  We used JDK 11, so this version may be required to run the program. If switching to JDK 11, make sure to update the JRE for the file.

**Game Start** To run the game, use the runner.java file.  This will open a new window on your screen.

**Opening Screen**
//include screenshot of game here
There are three options on the opening screen of the game: Start, Guide, and Credits //make sure these are the actual titles
You may click on any of these options.
The Start button starts the game (see below).
The Guide button explains the rules of the game.
The Credits buttons shows the authors of the game.

**After Clicking Start Button**
//screenshot of press enter to begin
To begin a game, press the enter button. The enter button will also restart the game //(check that this is true).
//screenshot of game start
When playing the game, your goal is to get the high score by traveling the farthest distance (distance = points) and collecting the most coins (each coin = 100 points).
You must avoid boxes or you will get a game over. 
You may also collect a ghost for ghost mode (see below).
Press space to jump over boxes, collect coins, or collect a ghost. 
Every 1000 distance, the game will speed up. There is a warning 100 //(might be 50) distance before the speed up occurs. You will not have to jump over a box in the first //check distance  after the speed up (to give you a little time to figure out the speed), although you may already be above a box when speed up occurs (since your previous jump was still at the old speed)

**Score**
You can see your distance traveled, coins collected, and ghosts collected in the top left corner of the game screen.
Final score will be displayed at the end of the game. Score = Distance + coins * 100.
The game will also remember your high score and display this at the end of the game as well.

**Ghost Mode**
//screen shot of ghost mode, ideally with cat through a box
You may collect ghosts throughout the game (although they are much rarer when compared to coins).
The number of ghosts you have is displayed at the top left of the screen.
If you have a ghost, you may enter ghost mode (which will remove this ghost from your inventory).
Press the L key to enter ghost mode.
While in ghost mode, you can travel through boxes without being harmed.
You remain a ghost for 6 seconds.

**Game End**
When you collide with a box when you are not in game mode, the game ends.
//screen shot of game over screen
You will see a game over screen that displays your score and the high score.
If you would like to replay the game, you may do so by pressing enter.
High scores will only be saved if you choose to replay the game, if you exit the window, the memory is erased.


