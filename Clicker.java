import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;

public class Clicker {

	private static final int DELAY = 100;	
	
	public static void main(String[] args) {
		
		int nargs = args.length;

		if(nargs % 3 != 0) {
			throw new Error("Invalid number of arguments");
		}
		
		for(int i = 0; i < nargs; i += 3) {
			int x = Integer.parseInt(args[i]);
			int y = Integer.parseInt(args[i+1]);
			int n = Integer.parseInt(args[i+2]);

			clickNTimes(x, y, n);
		}
	}



	private static void clickNTimes(int x, int y, int n) {
			
		Robot robby = null;
		try {
			robby = new Robot();
		} catch(AWTException e) {
			// Fail immediately
			e.printStackTrace();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			robby.mouseMove(x, y);
			robby.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robby.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robby.delay(DELAY);
		}
	}
}
