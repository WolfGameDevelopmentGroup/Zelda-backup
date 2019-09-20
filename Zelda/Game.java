/*
	 Game.java (Java)
	 
	 Purpose: Game class, start, renderize and update the game.
	 
	 Site: http://www.dirackslounge.online
	 
	 Version 1.0
	 
	 Programer: Rodolfo Dirack 19/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;

public class Game implements Runnable{

	public boolean isRunning=false;
	private int frame=0;

	public int getActualFrameNumber(){
		return this.frame;
	}

	public void updateGame(){
		this.frame++;
	}

	public void renderizeGame(){
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
