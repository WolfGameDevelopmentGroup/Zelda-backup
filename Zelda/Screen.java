/*
	 Screen.java (Java)
	 
	 Objetivo: Gerar a tela do jogo.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 06/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.Font;

public class Screen extends Canvas{

	public static JFrame jframe;
	public static Canvas canvas;
	private String jframeTitle;
	private int WIDTH;
	private int HEIGHT;
	private int SCALE;
	private BufferStrategy bs;
	private BufferedImage layer;
	private Color bgColor = Color.WHITE;
	private Graphics g;

	public Screen(String jframeTitle, int WIDTH, int HEIGHT, int SCALE){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.SCALE = SCALE;

		this.canvas = new Canvas();
		this.canvas.setPreferredSize(new Dimension(this.WIDTH*this.SCALE, this.HEIGHT*this.SCALE));	

		this.jframeTitle = jframeTitle;
		this.jframe = new JFrame(this.jframeTitle);
		this.jframe.setPreferredSize(new Dimension(this.WIDTH*this.SCALE, this.HEIGHT*this.SCALE));

		this.jframe.add(this.canvas);
		this.jframe.setResizable(false);
		this.jframe.pack();
		this.jframe.setLocationRelativeTo(null);
		this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		this.canvas.createBufferStrategy(3);
		this.bs = this.canvas.getBufferStrategy();
		this.layer = new BufferedImage(this.WIDTH*this.SCALE,this.HEIGHT*this.SCALE,BufferedImage.TYPE_INT_RGB);
		this.g = this.layer.getGraphics();
		this.g.setColor(this.bgColor);
		this.showScreen();
		this.canvas.requestFocus();
	}

	public int getScreenWidth(){
		return this.WIDTH;
	}

	public int getScreenScale(){
		return this.SCALE;
	}

	public void showScreen(){
		this.jframe.setVisible(true);
	}

	private void drawBackground(){
		this.g.setColor(this.bgColor);
		this.g.fillRect(0,0,this.WIDTH*this.SCALE, this.HEIGHT*this.SCALE);
	}

	public void setBackgroungColor(Color bgColor){
		this.bgColor = bgColor;
		this.g.setColor(this.bgColor);
	}

}
