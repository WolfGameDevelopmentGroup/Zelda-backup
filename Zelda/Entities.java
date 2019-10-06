/*
	 Entities.java (Java)
	 
	 Purpose: Superclass for Player, Enemies and Objects to load on the Game screen.
	 
	 Site: http://www.dirackslounge.online
	 
	 Version 1.0
	 
	 Programer: Rodolfo Dirack 06/10/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import Zelda.SpriteSheet;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public abstract class Entities{

	protected int width;
	protected int height;
	protected int x;
	protected int y;
	protected BufferedImage[] image = new BufferedImage[8];
	protected int curentImageIndex = 0;


	public void setSize(int WIDTH,int HEIGHT){
		this.width=WIDTH;
		this.height=HEIGHT;
	}

	public void setPosition(int X,int Y){
		this.x = X;
		this.y = Y;
	}

	public void draw(Graphics g){
               Graphics2D g2 = (Graphics2D) g;
               g2.drawImage(this.image[this.curentImageIndex],this.x,this.y,this.width,this.height,null);
       }

	public void update(){}

}







