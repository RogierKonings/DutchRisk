package data;

import game.Province;

import java.util.Collections;

/**
 * Class that loads the different possible scenario's for the game
 * 
 * @author rogier_konings
 * 
 */
public class Scenario {

	private String scenario;
	
	public Scenario(String scenario) {

		this.scenario = scenario;
		
		if (scenario.equals("random")) {
			divideProvincesRandomly();
		} else if (scenario.equals("historical")) {
			divideProvincesHistorically();
		} else if (scenario.equals("germaninvasion")) {
			divideProvincesGermanInvasion();
		}

	}
	
	public String getScenario() {
		
		return scenario;
		
	}

	/**
	 * Divides the provinces randomly among the players
	 */
	public void divideProvincesRandomly() {

		GameData.CURRENT_SCENARIO = "random";

		for (int i = 0; i < 100; i++) {

			Collections.shuffle(GameData.provinces);
		}

		int count = 0;

		if (GameData.PLAYER_AMOUNT == 2) {
			for (Province province : GameData.provinces) {

				if (count % 2 == 0) {
					province.setPlayer(GameData.PLAYER_ONE);
				} else if (count % 2 == 1) {
					province.setPlayer(GameData.PLAYER_TWO);
				}
				count++;
			}
		}

		if (GameData.PLAYER_AMOUNT == 3) {
			for (Province province : GameData.provinces) {

				if (count % 3 == 0) {
					province.setPlayer(GameData.PLAYER_ONE);
				} else if (count % 3 == 1) {
					province.setPlayer(GameData.PLAYER_TWO);
				} else if (count % 3 == 2) {
					province.setPlayer(GameData.PLAYER_THREE);
				}
				count++;
			}
		}
	}

	/**
	 * Divides the provinces among the players according to history. In case of
	 * two players - NEDERLAND vs BELGIUM In case of three player - NEDERLAND vs
	 * VLAANDEREN vs WALLONIE In the latter case, more placeable armies are
	 * given to the player with lower amounts of provinces
	 */
	public void divideProvincesHistorically() {

		GameData.CURRENT_SCENARIO = "historical";
		for (Province province : GameData.provinces) {

			if (GameData.PLAYER_AMOUNT == 2) {

				if (province.getNation() == Nationality.NEDERLANDS) {
					province.setPlayer(GameData.PLAYER_ONE);
				} else if (province.getNation() == Nationality.VLAAMS
						|| province.getNation() == Nationality.WAALS) {
					province.setPlayer(GameData.PLAYER_TWO);
				}
			}

			else if (GameData.PLAYER_AMOUNT == 3) {

				if (province.getNation() == Nationality.NEDERLANDS) {
					province.setPlayer(GameData.PLAYER_ONE);
					GameData.PLAYER_ONE.setUnplacedArmies(12);
				} else if (province.getNation() == Nationality.VLAAMS) {
					province.setPlayer(GameData.PLAYER_TWO);
					GameData.PLAYER_TWO.setUnplacedArmies(16);
				} else if (province.getNation() == Nationality.WAALS) {
					province.setPlayer(GameData.PLAYER_THREE);
					GameData.PLAYER_THREE.setUnplacedArmies(17);
				}
			}

		}

	}

	/**
	 * Simulates a German, or for the sake of being in 1815, a Prussian invasion
	 * of the Netherlands. Only available for two players!
	 */
	public void divideProvincesGermanInvasion() {

		GameData.CURRENT_SCENARIO = "germaninvasion";
		if (GameData.PLAYER_AMOUNT == 2) {

			for (Province province : GameData.provinces) {

				if (province.getName().equals("Friesland")
						|| province.getName().equals("Groningen")
						|| province.getName().equals("Gelderland")
						|| province.getName().equals("Drenthe")
						|| province.getName().equals("Overijssel")
						|| province.getName().equals("Noord-Brabant")
						|| province.getName().equals("Limburg")
						|| province.getName().equals("Luik")
						|| province.getName().equals("Luxemburg")) {
					province.setPlayer(GameData.PLAYER_ONE);
				} else {
					province.setPlayer(GameData.PLAYER_TWO);
				}
			}
		} else if (GameData.PLAYER_AMOUNT == 3) {
			System.out.println("Sorry, this is only a two player map!");
		}

	}

}
