package gui;

import game.Province;
import game.RiskGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.GameData;
import data.NLmap;
import data.NedData;




public class RiskMap extends JPanel {

	private static final long serialVersionUID = 4646851898036548618L;
	private Image img;
	
	
	
	public RiskMap(Image img) {

		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		loadData();
		drawProvinces();
	}
	
	public void loadData() {
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g.drawImage(img, 0, 0, null);

		for (Province province : GameData.provinces) {

			if (province.SELECTED == true) {

				g2d.setColor(Color.BLACK);
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

			g2d.fill(province.getCapitalLocation());

			g2d.setColor(Color.WHITE);
			g2d.draw(province.getCapitalLocation());


			if (province.getArmy() < 10) {
				g2d.drawString("" + province.getArmy(), (int) province
						.getCapitalLocation().getX() + 6, (int) province
						.getCapitalLocation().getY() + 15);
			} else {
				g2d.drawString("" + province.getArmy(), (int) province
						.getCapitalLocation().getX() + 3, (int) province
						.getCapitalLocation().getY() + 15);
			}

		}

	}

	public void drawProvinces() {

		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				
				Color color = new NLmap().getPointColor(e.getPoint());

				for (Province province : GameData.provinces) {

					province.SELECTED = false;

					if (province.getColor().equals(color)) {

						RiskBoard.getAttackButton().setEnabled(false);
						RiskBoard.getDestinationBox().setEnabled(false);
						RiskBoard.getAddArmyButton().setEnabled(false);
						RiskBoard.getRemoveArmyButton().setEnabled(false);
						
						province.SELECTED = true;
						GameData.SELECTED_PROVINCE = province;
						
						RiskBoard.showDestinations();
						
						if (province.getPlayer() == GameData.CURRENT_PLAYER) {

							RiskBoard.getAttackButton().setEnabled(true);
							RiskBoard.getDestinationBox().setEnabled(true);
							RiskBoard.getAddArmyButton().setEnabled(true);
							RiskBoard.getRemoveArmyButton().setEnabled(true);
							
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
													.getId()
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
