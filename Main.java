/*
	 Main.java (Java)
	 
	 Purpose: Zelda game, Danki code game development project.
	 
	 Site: http://www.dirackslounge.online
	 
	 Version 0.1
	 
	 Programer: Rodolfo A C Neves (Dirack) 19/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

import Zelda.Game;
import Zelda.FileNotFoundException;

public class Main{

	public static void main(String[] args) throws FileNotFoundException{

		String TITLE="Zelda Game #1";
		int SCREEN_WIDTH=200;
		int SCRREN_HEIGHT=200;
		int SCALE=3;

		Game game = new Game(TITLE, SCREEN_WIDTH, SCRREN_HEIGHT, SCALE);
		
		game.startGame();
	}

}
