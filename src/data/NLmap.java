package data;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class responsible for loading the invisible image that has each province in
 * just one colour. This class is used to make the provinces clickable in-game.
 * 
 * @author rogier_konings
 * 
 */
public class NLmap {

	// Loads simpler, one colour per-province, image file of the map
	public String netherlands = "/img/maps/NL-coordinates.png";
	public BufferedImage buffimg;

	public NLmap() {
		try {
			buffimg = ImageIO.read(getClass().getResource(netherlands));

		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}

	}

	/**
	 * Used to retrieve the color at a certain point
	 * 
	 * @param point
	 *            location of the check for colour
	 * @return the Color at the specific point
	 */
	public Color getPointColor(Point point) {

		int x = point.x;
		int y = point.y;

		return new Color(buffimg.getRGB(x, y));

	}

}
