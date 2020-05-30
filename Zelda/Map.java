/*
	 Map.java (java)
	 
	 Purpose: To load game map sprites.
	 
	 Version 0.1
	 
	 Site: http://www.dirackslounge.online
	 
	 Programer: Rodolfo A. C. Neves (Dirack) 16/10/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Zelda.FileNotFoundException;
import java.net.URL; 
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Map extends SpriteSheet{

	protected int[] pixels;
	protected BufferedImage tileFloor;
	protected BufferedImage tileGrass;
	protected BufferedImage tileEnemy;
	protected BufferedImage tileGun;
	protected BufferedImage tilePack;
	protected BufferedImage tileLife;
	protected int width;
	protected int height;
	public int firstPixelx;
	public int firstPixely;

	public Map(String path, SpriteSheet tiles) throws FileNotFoundException{

		super(path);
		this.tileFloor = tiles.getSprite(16,0,16,16);
		this.tileGrass = tiles.getSprite(0,0,16,16);
		this.tileEnemy = tiles.getSprite(7*16,16,16,16);
		this.tileGun = tiles.getSprite(7*16,0,16,16);
		this.tilePack = tiles.getSprite(6*16,16,16,16);
		this.tileLife = tiles.getSprite(6*16,0,16,16);
		this.width = this.spritesheet.getWidth();
		this.height = this.spritesheet.getHeight();

		this.pixels = new int[this.width * this.height];
		this.loadMap();
	}

	public void loadMap(){

		this.spritesheet.getRGB(0,0,this.width,this.height,this.pixels,0,this.width);
	}

	public void draw(Graphics g, int SCALE, int playerx, int playery, int screenWidth, int screenHeight){

		int xx, yy, currentPixel;
		playerx = (int)(playerx/(16*SCALE));
		playery = (int)(playery/(16*SCALE));
		screenWidth = (int)(screenWidth/(16*SCALE));
		screenHeight = (int)(screenHeight/(16*SCALE));
		this.firstPixelx = playerx - screenWidth/2;
		this.firstPixely = 0;

		if(playerx < screenWidth/2) firstPixelx = 0;
		if((playery + screenHeight/2) > this.height){
			firstPixelx = this.width * this.height - screenHeight * screenWidth;
		}

		Graphics2D g2 = (Graphics2D) g;

		for(xx=0; xx < screenWidth+1; xx++){
			for(yy=0; yy < screenHeight+1; yy++){

				currentPixel = this.pixels[(xx + this.firstPixelx) + yy * this.width];

				if(currentPixel == hexaColor.BLACK.value){ 
					g2.drawImage(this.tileGrass,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}else if(currentPixel == hexaColor.WHITE.value){
					g2.drawImage(this.tileFloor,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}else if(currentPixel == hexaColor.RED.value){
					g2.drawImage(this.tileGrass,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
					g2.drawImage(this.tileEnemy,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}else if(currentPixel == hexaColor.ORANGE.value){
					g2.drawImage(this.tileGrass,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
					g2.drawImage(this.tileGun,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}else if(currentPixel == hexaColor.GREEN.value){
					g2.drawImage(this.tileGrass,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
					g2.drawImage(this.tilePack,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}else if(currentPixel == hexaColor.YELLOW.value){
					g2.drawImage(this.tileGrass,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
					g2.drawImage(this.tileLife,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}else{
					g2.drawImage(this.tileGrass,xx*16*SCALE,yy*16*SCALE,16*SCALE,16*SCALE,null);
				}
			}
		}
	}

	public enum hexaColor{
		BLACK(0xFF000000), WHITE(0xFFFFFFFF), RED(0xFFFF0000), ORANGE(0xFF6A00),
		GREEN(0xFF00FF21), YELLOW(0xFFFFD800);

		public int value;

		hexaColor(int value){
			this.value = value;
		}
	}
}
