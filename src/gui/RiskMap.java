package gui;

import game.RiskGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import data.GameData;
import data.NedData;
import data.Province;

public class RiskMap extends JPanel {
	
	private static final long serialVersionUID = 4646851898036548618L;

	private GameData gamedata;
	private ArrayList<Province> countrydata;
	private Province province;

	private Image img;

	public RiskMap(String img) {
		this(new ImageIcon(img).getImage());
		drawProvinces();
	}

	public RiskMap(Image img) {

		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		drawProvinces();
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g.drawImage(img, 0, 0, null);

		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());

		for (Province province : countrydata) {

			if (province.SELECTED == true) {

				g2d.setColor(Color.MAGENTA);
			} else {

				g2d.setColor(Color.WHITE);
			}

			g2d.fill(province.getShapeProvince());
			g2d.draw(province.getShapeProvince());

		}

	}

	public void drawProvinces() {

		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				
				for (Province province : countrydata) {
					
					province.SELECTED = false;
					
					if (province.getShapeProvince().contains(e.getPoint())) {

						province.SELECTED = true;
						RiskGame.getSelectedProvince();
						
						RiskBoard.getGameLabel().setText(
								"<html><br><br><br><br><br>You have selected: <br><br> Province: <b>"
										+ province.getName() + "</b><br>"
										+ "Capital: <b>" + province.getCapital()
										+ "</b><br>" + "Army Size: <b>"
										+ province.getArmy() + "</b><br>Player: <b>" + province.getPlayer().getPlayerId() +  "</b></html>");

						repaint();

					}
				}
			}
		});

	}


}
