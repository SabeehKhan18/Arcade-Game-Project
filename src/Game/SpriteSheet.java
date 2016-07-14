package Game;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage spritesheet;
	
	public SpriteSheet(BufferedImage spritesheet){
		this.spritesheet = spritesheet;
	}
	
	public BufferedImage sprite(int x, int y, int width, int height){
		return this.spritesheet.getSubimage(x, y, width, height);
	}

}
