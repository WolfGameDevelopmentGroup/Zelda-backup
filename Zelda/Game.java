/*
	 Game.java (Java)
	 
	 Purpose: Game class, start, renderize and update the game.
	 
	 Site: http://www.dirackslounge.online
	 
	 Version 0.1
	 
	 Programer: Rodolfo Dirack 19/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;

import Zelda.Screen;
import java.awt.Color;
import java.util.*;

public class Game implements Runnable{

	public boolean isRunning=false;
	private int frame=0;
	private String TITLE;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private int SCALE=1;
	private Screen screen;

	public Game(String TITLE, int SCREEN_WIDTH, int SCREEN_HEIGHT, int SCALE){
		this.TITLE = TITLE;
		this.SCREEN_WIDTH = SCREEN_WIDTH*SCALE;
		this.SCREEN_HEIGHT = SCREEN_HEIGHT*SCALE;
		this.SCALE = SCALE;
		this.screen = new Screen(TITLE, SCREEN_WIDTH, SCREEN_HEIGHT, SCALE);
		this.screen.setBackgroungColor(Color.WHITE);
	}

	public int getActualFrameNumber(){
		return this.frame;
	}

	public void updateGame(){
		this.frame++;
	}

	public void renderizeGame(){
		this.screen.drawFrame();
	}

	public synchronized void startGame(){
		this.isRunning = true;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run(){

		while(isRunning){
			updateGame();
			renderizeGame();
			try{
				Thread.sleep(1000/60);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

}
