/*
	 FileNotFoundException.java (java)
	 
	 Purpose: Inform if the spritesheet is not found.
	 
	 Version 0.1
	 
	 Site: http://www.dirackslounge.online
	 
	 Programer: Rodolfo A. C. Neves (Dirack) 21/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package Zelda;

public class FileNotFoundException extends Exception{

	private String path;

	public FileNotFoundException(String path){
		super();
		this.path = path;
	}

	@Override
	public String getMessage(){
		return "SpriteSheet not found in path: "+path+" \nPlease verify correct file path";
	}
}
