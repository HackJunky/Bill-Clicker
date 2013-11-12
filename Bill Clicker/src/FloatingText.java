import java.awt.Point;
import java.util.Random;


public class FloatingText {
	private String text;
	private Point location;
	private boolean done;
	
	public FloatingText(String text, Point startLocation) {
		this.text = text;
		this.location = startLocation;
	}
	
	public void flutter() {
		boolean direction = new Random().nextBoolean();
		if (direction) {
			location = new Point (location.x + 1, location.y - 1);
		}else {
			location = new Point (location.x - 1, location.y - 1);
		}
		if (location.y < 0) {
			done = true;
		}
	}
}
