/*
	 Player.java (Java)
	 
	 Purpose: Player of Zelda game.
	 
	 Site: http://www.dirackslounge.online
	 
	 Version 1.0
	 
	 Programer: Rodolfo Dirack 06/10/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends Entities{

	public Player(int WIDTH, int HEIGHT, int x, int y, SpriteSheet sprite){

		this.setSize(WIDTH,HEIGHT);
		this.setPosition(x,y);
		this.loadImages(sprite);
		this.curentImageIndex = 0;
	}

	private void loadImages(SpriteSheet sprite){

		int i,j;

		for(j=0;j<2;j++){
			for(i=0;i<4;i++){
				this.image[i+(j*4)] = sprite.getSprite(32+(i*16),0+(j*16),16,16);
			}
		}
	}

	public int getCurentImageIndex(){
		return this.curentImageIndex;
	}

	public void setCurentImageIndex(int index){
		this.curentImageIndex = index;
	}

	public void draw(Graphics g, boolean moveRight){

		Graphics2D g2 = (Graphics2D) g;

		if(moveRight){
			if(this.curentImageIndex < 4){
				g2.drawImage(this.image[this.curentImageIndex],
				this.x,this.y,this.width,this.height,null);
			}
		} else {
			if(this.curentImageIndex <= 7){
				g2.drawImage(this.image[this.curentImageIndex],
				this.x,this.y,this.width,this.height,null);
			}
		}

	}

	public void update(){}

}
