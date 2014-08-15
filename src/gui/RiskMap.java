package gui;

import game.Province;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import data.GameData;
import data.NLmap;

/**
 * Class responsible for loading the map and painting the different graphics on
 * the screen. Also responsible for loadding the invisible map so that provinces
 * can easily be selected.
 * 
 * @author rogier_konings
 * 
 */
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
		drawProvinces();
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g.drawImage(img, 0, 0, null);

		for (Province province : GameData.provinces) {

			float thickness = 3;
			
			Stroke oldstroke = g2d.getStroke();
			
			Font unselected = new Font("TimesRoman", Font.PLAIN, 12);
			Font selected = new Font("TimesRoman", Font.PLAIN, 30);
			
			
			if (province.SELECTED == true) {
				
				
				//double circlesize = province.getCapitalLocation().getHeight();
				//province.getCapitalLocation().setFrame(province.getCapitalLocation().getY(), province.getCapitalLocation().getCenterY(), 40, 40);
				

				g2d.setFont(selected);
				
				g2d.setColor(province.getPlayer().getPlayerColor());
				
				Ellipse2D selectedprovince = new Ellipse2D.Double(province.getCapitalLocation().getX() - 15, province.getCapitalLocation().getY() - 15, 50, 50);
				g2d.fill(selectedprovince);
				g2d.setColor(Color.WHITE);
				g2d.setStroke(new BasicStroke(thickness));
				g2d.draw(selectedprovince);
				
				g2d.setStroke(oldstroke);
				
				if (province.getArmy() < 10) {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 8, (int) province
							.getCapitalLocation().getCenterY() + 10);
				} else {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 15, (int) province
							.getCapitalLocation().getCenterY() + 10);
				}
				
			} else if (province.SELECTED == false
					&& province.getPlayer() == GameData.PLAYER_ONE) {

				
				g2d.setFont(unselected);
				g2d.setColor(GameData.PLAYER_ONE.getPlayerColor());
				g2d.fill(province.getCapitalLocation());

				g2d.setColor(Color.WHITE);
				g2d.draw(province.getCapitalLocation());
				
				if (province.getArmy() < 10) {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 2, (int) province
							.getCapitalLocation().getCenterY() + 5);
				} else {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 5, (int) province
							.getCapitalLocation().getCenterY() + 5);
				}
			} else if (province.SELECTED == false
					&& province.getPlayer() == GameData.PLAYER_TWO) {

				g2d.setFont(unselected);
				g2d.setColor(GameData.PLAYER_TWO.getPlayerColor());
				g2d.fill(province.getCapitalLocation());

				g2d.setColor(Color.WHITE);
				g2d.draw(province.getCapitalLocation());
				
				if (province.getArmy() < 10) {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 2, (int) province
							.getCapitalLocation().getCenterY() + 5);
				} else {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 5, (int) province
							.getCapitalLocation().getCenterY() + 5);
				}
			} else if (province.SELECTED == false
					&& province.getPlayer() == GameData.PLAYER_THREE) {

				g2d.setFont(unselected);
				
				g2d.setColor(GameData.PLAYER_THREE.getPlayerColor());
				g2d.fill(province.getCapitalLocation());

				g2d.setColor(Color.WHITE);
				g2d.draw(province.getCapitalLocation());
				
				
				
				if (province.getArmy() < 10) {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 2, (int) province
							.getCapitalLocation().getCenterY() + 5);
				} else {
					g2d.drawString("" + province.getArmy(), (int) province
							.getCapitalLocation().getCenterX() - 5, (int) province
							.getCapitalLocation().getCenterY() + 5);
				}
			}

//			g2d.fill(province.getCapitalLocation());
//
//			g2d.setColor(Color.WHITE);
//			g2d.draw(province.getCapitalLocation());

			//g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

			
			
	

		}

	}

	/**
	 * Gives the coordinates of the mouse click, and calculates which province
	 * will be selected
	 */
	public void drawProvinces() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				Color provincecolor = new NLmap().getPointColor(e.getPoint());

				if (provincecolor.equals(new Color(0xdcf0f5))) {
					RiskBoard.getGameLabel().setText(
							"Aaargh, you cannot select the Ocean..");
				} else if (provincecolor.equals(new Color(0x0e88ce))) {
					RiskBoard.getGameLabel().setText(
							"You cannot play with those vile French!");
				} else if (provincecolor.equals(new Color(0x74548e))) {
					RiskBoard.getGameLabel().setText(
							"You cannot play with those brutal Prussians!");
				} else if (provincecolor.equals(new Color(0xe6e475))) {
					RiskBoard
							.getGameLabel()
							.setText(
									"You cannot play with those barbarian people of Hannover!");
				} else {

					for (Province province : GameData.provinces) {

						province.SELECTED = false;

						if (province.getColor().equals(provincecolor)) {

							
							
							RiskBoard.getAttackButton().setEnabled(false);
							RiskBoard.getDestinationBox().setEnabled(false);
							RiskBoard.getAddArmyButton().setEnabled(false);
							RiskBoard.getRemoveArmyButton().setEnabled(false);
							RiskBoard.getMoveButton().setEnabled(false);
							RiskBoard.getCollectButton().setEnabled(false);

							province.SELECTED = true;
							GameData.SELECTED_PROVINCE = province;

							RiskBoard.showDestinations();

							if (province.getPlayer() == GameData.CURRENT_PLAYER) {

								if (GameData.PLACE_ROUND == false) {

									RiskBoard.getAttackButton()
											.setEnabled(true);
									RiskBoard.getDestinationBox().setEnabled(
											true);
									RiskBoard.getMoveButton().setEnabled(true);
									RiskBoard.getCollectButton().setEnabled(
											true);
								}

								RiskBoard.getRemoveArmyButton().setEnabled(
										false);

								if (GameData.PLACE_ROUND == true) {
									RiskBoard.getRemoveArmyButton().setEnabled(
											true);
								}

								if (GameData.CURRENT_PLAYER.getUnplacedArmies() > 0) {

									RiskBoard.getAddArmyButton().setEnabled(
											true);
								}

								RiskBoard.getGameLabel().setText(
										"<html><br><br><br><br><br>You have selected: <br><br> Province: <b>"
												+ province.getName()
												+ "</b><br>" + "Capital: <b>"
												+ province.getCapital()
												+ "</b><br>" + "Army Size: <b>"
												+ province.getArmy()
												+ "</b><br>Player: <b>"
												+ province.getPlayer().getId()
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
			}
		});

	}
}
