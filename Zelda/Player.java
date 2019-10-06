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

public class Player extends Entities{

	public Player(int WIDTH, int HEIGHT, int x, int y, SpriteSheet sprite){

		this.setSize(WIDTH,HEIGHT);
		this.setPosition(x,y);
		this.loadImages(sprite);
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

	public void update(){}

}
