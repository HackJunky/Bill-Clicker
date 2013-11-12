import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class CoreUtils{
	
	public static BufferedImage getBackgroundImage() {
		try {
			return ImageIO.read(new File("res/img/bgImage.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getHorSep() {
		try {
			return ImageIO.read(new File("res/img/panelHorizontal.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getVertSep() {
		try {
			return ImageIO.read(new File("res/img/panelVertical.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getGradientUp() {
		try {
			return ImageIO.read(new File("res/img/blackGradientUp.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getGradientDown() {
		try {
			return ImageIO.read(new File("res/img/blackGradientDown.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getBill() {
		try {
			return ImageIO.read(new File("res/img/scroll.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getTextGradient() {
		try {
			return ImageIO.read(new File("res/img/textGradient.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getStoreTile() {
		try {
			return ImageIO.read(new File("res/img/storeTile.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
