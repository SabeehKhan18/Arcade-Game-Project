package Game;

import java.awt.image.BufferedImage;

public class Sprites {

	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static BufferedImage mushroom0, mushroom1, mushroom2, mushroom3, mushroom4,
								pMushroom0, pMushroom1, pMushroom2, pMushroom3,
								player, scorpion, spider, flea, centHead, centBody;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("spritesheet.png"));
		player = sheet.sprite(0*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		mushroom0 = sheet.sprite(1*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		mushroom1 = sheet.sprite(1*WIDTH, 1*HEIGHT, WIDTH, HEIGHT);
		mushroom2 = sheet.sprite(1*WIDTH, 2*HEIGHT, WIDTH, HEIGHT);
		mushroom3 = sheet.sprite(1*WIDTH, 3*HEIGHT, WIDTH, HEIGHT);
		pMushroom0 = sheet.sprite(2*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		pMushroom1 = sheet.sprite(2*WIDTH, 1*HEIGHT, WIDTH, HEIGHT);
		pMushroom2 = sheet.sprite(2*WIDTH, 2*HEIGHT, WIDTH, HEIGHT);
		pMushroom3 = sheet.sprite(2*WIDTH, 3*HEIGHT, WIDTH, HEIGHT);
		scorpion = sheet.sprite(3*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		spider = sheet.sprite(4*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		flea = sheet.sprite(5*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		centHead = sheet.sprite(6*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
		centBody = sheet.sprite(7*WIDTH, 0*HEIGHT, WIDTH, HEIGHT);
	}
	
}
