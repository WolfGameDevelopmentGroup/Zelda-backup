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

public class SpriteSheet{

	protected BufferedImage spritesheet;

	public SpriteSheet(String path) throws FileNotFoundException{

		URL input = getClass().getResource(path);

		try {
			if( input == null){
				throw new FileNotFoundException(path);
			}

			spritesheet = ImageIO.read(getClass().getResource(path));

		} catch (IOException | FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}


	public BufferedImage getSprite(int x, int y, int width, int height){
		return spritesheet.getSubimage(x,y,width,height);
	}

}
