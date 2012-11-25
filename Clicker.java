import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Clicker {
	private static final int DELAY = 100;	
	
	public static void main(String[] args) {
		// Make an input reader and read the first line
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			// Fail immediately
			e.printStackTrace();
			return;
		}
		
		// Make the Robot to do the clicking
		Robot robby = null;
		try {
			robby = new Robot();
		} catch(AWTException e) {
			// Fail immediately
			e.printStackTrace();
			return;
		}
		
		// Loop over each line of input
		while(line != null) {
			
			// Split it into the three components
			String[] pieces = line.split(" ");
			int x = Integer.parseInt(pieces[0]);
			int y = Integer.parseInt(pieces[1]);
			int n = Integer.parseInt(pieces[2]);
			
			// Do the clicking
			clickNTimes(x, y, n, robby);
			
			// Get the next line
			try {
				line = in.readLine();
			} catch (IOException e) {
				// Fail immediately
				e.printStackTrace();
				return;
			}
		}
	}
	
	public static void clickNTimes(int x, int y, int n, Robot robby) {
		// n times
		for(int i = 0; i < n; i++) {

			// Move to the desired location (in case someone is moving the mouse)
			robby.mouseMove(x, y);

			// Press and release
			robby.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robby.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			// Probably unneccessary, but I didn't want to cause any issues by 
			// going as fast as possible
			robby.delay(DELAY);
		}
	}
}
