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
import data.NLmap;
import data.NedData;
import data.Province;

/**
 * 
 * @author rogier_konings
 * 
 */
public class RiskMap extends JPanel {

	private static final long serialVersionUID = 4646851898036548618L;

	private GameData gamedata;
	private ArrayList<Province> countrydata;

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

	/**
	 * Overrides the painComponent function in order to draw clickable circles
	 * on the capital of each province
	 */
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g.drawImage(img, 0, 0, null);

		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());

		for (Province province : countrydata) {

			if (province.SELECTED == true) {

				g2d.setColor(Color.MAGENTA);
			} else if (province.SELECTED == false
					&& province.getPlayer() == GameData.PLAYER_ONE) {

				g2d.setColor(GameData.PLAYER_ONE.getPlayerColor());
			} else if (province.SELECTED == false
					&& province.getPlayer() == GameData.PLAYER_TWO) {

				g2d.setColor(GameData.PLAYER_TWO.getPlayerColor());
			} else if (province.SELECTED == false
					&& province.getPlayer() == GameData.PLAYER_THREE) {

				g2d.setColor(GameData.PLAYER_THREE.getPlayerColor());
			}

			g2d.fill(province.getCapitalShape());

			g2d.setColor(Color.WHITE);
			g2d.draw(province.getCapitalShape());


			if (province.getArmy() < 10) {
				g2d.drawString("" + province.getArmy(), (int) province
						.getCapitalShape().getX() + 6, (int) province
						.getCapitalShape().getY() + 15);
			} else {
				g2d.drawString("" + province.getArmy(), (int) province
						.getCapitalShape().getX() + 3, (int) province
						.getCapitalShape().getY() + 15);
			}

		}

	}

	public void drawProvinces() {

		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				NLmap nlmap = new NLmap();
				Color color = nlmap.getPointColor(e.getPoint());

				for (Province province : countrydata) {

					province.SELECTED = false;

					if (province.getColor().equals(color)) {

						RiskBoard.getAttackButton().setEnabled(false);
						province.SELECTED = true;
						RiskGame.getSelectedProvince();
						RiskGame.showDestinations();

						if (province.getPlayer() == RiskGame.getCurrentPlayer()) {

							RiskBoard.getAttackButton().setEnabled(true);

							RiskBoard.getGameLabel().setText(
									"<html><br><br><br><br><br>You have selected: <br><br> Province: <b>"
											+ province.getName()
											+ "</b><br>"
											+ "Capital: <b>"
											+ province.getCapital()
											+ "</b><br>"
											+ "Army Size: <b>"
											+ province.getArmy()
											+ "</b><br>Player: <b>"
											+ province.getPlayer()
													.getPlayerId()
											+ "</b></html>");

							repaint();
						} else {

							RiskBoard.getGameLabel().setText(
									"Please select your own province!");
							repaint();

						}

					}
				}

			}
		});

	}

}
