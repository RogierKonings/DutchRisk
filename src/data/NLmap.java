package data;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NLmap {

	public File netherlands = new File(
			"../DutchRisk/src/img/maps/NL-coordinates.png");
	public BufferedImage buffimg;

	public NLmap() {
		try {
			buffimg = ImageIO.read(netherlands);

		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}

	}

	public Color getPointColor(Point point) {

		int x = point.x;
		int y = point.y;

		return new Color(buffimg.getRGB(x, y));

	}

}
