package application;

import java.awt.Image;

public class AnimatedImage {

	public Image[] frames;
	public double duration;
	
	public Image getFrame(double time) {
		int index = (int)((time % (frames.length * duration)) / duration);
        return frames[index];
	}
}
