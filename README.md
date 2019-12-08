# final-project-team68_platformer
final-project-team68_platformer created by GitHub Classroom

**Members:** \
Danielle Coates, Matthew Ordway, Kelvin Cheung

**Overview:** \
We created a scrolling platformer game. The game theme is a cat that jumps over obstacles. The cat can also collect coins for points. The gameplay gets faster as the game continues.

<p align="center">
<img src="https://raw.githubusercontent.com/UPenn-CIT599/final-project-team68_platformer/master/sample_images/game1%20basic.gif?token=ANWOM6NFYUZZVEBF22IXSBC56V4G6">
</p>

**User Needs:** \
We used Swing as our GUI, which is automatically built into Java.  We used the lastest version of Eclipse and Java (JDK 13), so this version may be required to run the program. If you switch your JDK, make sure to update the JRE for the file. Note that one user noted a black screen on the GUI, which we believe is due to outdated versions.

**Game Start:** \
To run the game, use the runner.java file. This will open a new window on your screen to interact with the game.

**Opening Screen:** 
<p align="center">
<img src="https://raw.githubusercontent.com/UPenn-CIT599/final-project-team68_platformer/master/sample_images/Opening_Screen.PNG?token=ANWOM6O22UGMKBUIM2EZKV256V4JQ">
</p>

There are three options on the opening screen of the game: Play, Guide, and Credits  \
You may click on any of these options. \
The Play button starts the game (see below). \
The Guide button explains the rules of the game. \
The Credit buttons shows the authors of the game. 

**After Clicking Play Button:** 
<p align="center">
<img src="https://raw.githubusercontent.com/UPenn-CIT599/final-project-team68_platformer/master/sample_images/Enter.PNG?token=ANWOM6OI63WGLHHFKOGOKY256V4L2">
</p>

To begin a game, press the "Enter" button. 

<p align="center">
<img src="https://raw.githubusercontent.com/UPenn-CIT599/final-project-team68_platformer/master/sample_images/Game_Start.PNG?token=ANWOM6LBQLCHRHZDDZFOOCC56V4M4">
          </p>

When playing the game, your goal is to get the high score by traveling the farthest distance (distance = points) and collecting the most coins (each coin = 100 points). \
Press "Space" to jump over boxes, collect coins, or collect a ghost (see Ghost Mode below). \
If you hit a box, you will get a game over. \

Every 1000 distance, the game will speed up. There is a warning 50 distance before the speed up occurs. You will not have to jump over a box in the first 200 distance after the speed up (to give you a little time to figure out the speed), although you may already be above a box when speed up occurs (since your previous jump was still at the old speed). 

**Score:** \
You can see your distance traveled, coins collected, and ghosts collected in the top left corner of the game screen. \
The final score will be displayed at the end of the game. Score = Distance + coins * 100. \
The game will also remember your high score (if you replay the game) and display this at the end of the game.

**Ghost Mode:** 

<p align="center">
<img src="https://raw.githubusercontent.com/UPenn-CIT599/final-project-team68_platformer/master/sample_images/ghost.gif?token=ANWOM6LI5E7ZY7Q3DEARRAC56V4OM">
  </p>

You may collect ghosts throughout the game (although they are much rarer when compared to coins). \
The number of ghosts you have is displayed at the top left of the screen. \
If you have a ghost, you may enter ghost mode (which will remove this ghost from your inventory).
Press the "G" key to enter ghost mode for 5 seconds. \
While in ghost mode, you can travel through boxes without being harmed. \
You will be warned when the ghost mode will expire (1.5 seconds left). 

**Game End:** \
If the cat hits a box, the game ends. 

<p align="center">
<img src="https://raw.githubusercontent.com/UPenn-CIT599/final-project-team68_platformer/master/sample_images/Game_Over.PNG?token=ANWOM6NQVMTIWKD7YXRXHDS56V4PW">
  </p>

You will see a game over screen that displays your score and the high score. \
If you would like to replay the game, you may do so by pressing "Enter". \
High scores will only be saved if you choose to replay the game, if you exit the window, the memory is erased.


