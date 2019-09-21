/*
	 Main.java (Java)
	 
	 Purpose: Zelda game, Danki code game development project.
	 
	 Site: http://www.dirackslounge.online
	 
	 Version 1.0
	 
	 Programer: Rodolfo A C Neves (Dirack) 19/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

import Zelda.Game;

public class Main{

	public static void main(String[] args){

		String TITLE="Zelda Game #1";
		int WIDTH=200;
		int HEIGHT=200;
		int SCALE=1;

		Game game = new Game(TITLE, WIDTH, HEIGHT, SCALE);
		
		game.startGame();
	}

}
