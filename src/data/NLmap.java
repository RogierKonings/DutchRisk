package data;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class NLmap extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public File netherlands = new File("../img/NL-coordinates.png");
	public BufferedImage buffimg;

	private int xcor;
	private int ycor;
	
	private GameData gamedata;
	private ArrayList<Province> countrydata;
	private Province THIS_PROVINCE;

	Color Groningen = new Color(0x40a837);
	Color Friesland = new Color(0xfc0d0a);
	Color Drenthe = new Color(0xccfe07);
	Color Overijssel = new Color(0xc8ab36);
	Color Gelderland = new Color(0xa368f0);
	Color Utrecht = new Color(0xff6b2f);
	Color Holland = new Color(0xfefc5a);
	Color NoordBrabant = new Color(0xa96744);
	Color Zeeland = new Color(0x00f954);
	Color Antwerpen = new Color(0xc0d671);
	Color Limburg = new Color(0x6f9070);
	Color WestVlaanderen = new Color(0x9a7b92);
	Color OostVlaanderen = new Color(0xfd3d86);
	Color ZuidBrabant = new Color(0xfdcb49);
	Color Luik = new Color(0xfd5555);
	Color Henegouwen = new Color(0x89a02b);
	Color Namen = new Color(0xaa0187);
	Color Luxemburg = new Color(0xa9fed2);

	public NLmap() {
		try {
			buffimg = ImageIO.read(netherlands);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public Color getColor(Point point) {

		int x = point.x;
		int y = point.y;

		return new Color(buffimg.getRGB(x, y));

	}
	
	
	public Province returnProvince() {
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				xcor = e.getX();
				ycor = e.getY();

			}
		});

		Color clickedcolor = getColor(new Point(xcor, ycor));
		
		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());
		

		for (Province province : countrydata) {
			
			if(province.getColor() == clickedcolor) {
				THIS_PROVINCE = province;
			}
			
		}
		System.out.println(THIS_PROVINCE.getName());
		return THIS_PROVINCE;
	}

	public static void main(String[] args) {

		

	}

}
