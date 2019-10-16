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
import Zelda.Player;
import java.awt.Color;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements Runnable, KeyListener{

	public boolean isRunning=false;
	private int frame=0;
	private String TITLE;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private int SCALE=1;
	private Screen screen;
	private int framesToUpdatePlayerImage=10;
	private int countGameFrame=0;
	private Player player;

	public Game(String TITLE, int SCREEN_WIDTH, int SCREEN_HEIGHT, int SCALE) throws FileNotFoundException{
		this.TITLE = TITLE;
		this.SCREEN_WIDTH = SCREEN_WIDTH*SCALE;
		this.SCREEN_HEIGHT = SCREEN_HEIGHT*SCALE;
		this.SCALE = SCALE;
		this.screen = new Screen(TITLE, SCREEN_WIDTH, SCREEN_HEIGHT, SCALE);
		this.screen.setBackgroungColor(Color.WHITE);
		int x=100, y=100;
		this.player = new Player(16*SCALE,16*SCALE,x,y,this.screen.sheet);
		this.screen.canvas.addKeyListener(this);
	}

	public int getActualFrameNumber(){
		return this.frame;
	}

	public void updateGame(){
		this.frame++;

		if(this.player.moveRight){
			this.player.x++;
		}else if(this.player.moveLeft){
			this.player.x--;
		}else if(this.player.moveUp){
			this.player.y--;
		}else if(this.player.moveDown){
			this.player.y++;
		}

	}

	public void renderizeGame(){

		this.countGameFrame++;

		if(this.countGameFrame >= this.framesToUpdatePlayerImage){
			this.countGameFrame = 0;
			this.player.animatePlayer();
		}

		this.screen.drawFrame(this.player);
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

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.player.moveRight=true;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.player.moveLeft=true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.player.moveDown=true;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			this.player.moveUp=true;
		}
	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.player.moveRight=false;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.player.moveLeft=false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.player.moveDown=false;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			this.player.moveUp=false;
		}
	}

	public void keyTyped(KeyEvent e){}

}
