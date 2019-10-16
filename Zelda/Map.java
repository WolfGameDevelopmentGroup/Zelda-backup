/*
	 SpriteSheet.java (java)
	 
	 Purpose: To load game objects sprites.
	 
	 Version 0.1
	 
	 Site: http://www.dirackslounge.online
	 
	 Programer: Rodolfo A. C. Neves (Dirack) 06/07/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Zelda.FileNotFoundException;
import java.net.URL; 

public class Map extends SpriteSheet{

	protected int[] pixels;

	public Map(String path) throws FileNotFoundException{

		super(path);

		this.pixels = new int[this.spritesheet.getWidth() * this.spritesheet.getHeight()];
		this.loadMap();
	}

	public void loadMap(){

		int width = this.spritesheet.getWidth();
		int height = this.spritesheet.getHeight();
		int i;

		this.spritesheet.getRGB(0,0,width,height,this.pixels,0,width);

		for(i=0; i < pixels.length; i++){
			if(pixels[i] == 0xFFFF0000) 
				System.out.println("RED pixel");
		}

	}
}
