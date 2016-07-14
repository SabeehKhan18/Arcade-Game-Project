package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.Game;

public class Menu {
	private Game game;
	
	private Rectangle playButton;
	private Rectangle helpButton;
	private Rectangle quitButton;
	
	public Menu(Game game) {
		this.game = game;
		this.playButton = new Rectangle(game.getWidth() / 2 - 105,
				150,100,50);
		this.helpButton = new Rectangle(game.getWidth() / 2 - 105,
				250,100,50);
		this.quitButton = new Rectangle(game.getWidth() / 2 - 105,
				350,100,50);
	}

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("Times New Roman",Font.ITALIC, 50);
		g2d.setFont(fnt0);
		
		g2d.setColor(Color.BLACK);
		g2d.draw(this.playButton);
		g2d.draw(this.helpButton);
		g2d.draw(this.quitButton); 
		
		g2d.setColor(Color.WHITE);
		g2d.drawString("Centipede", this.game.getWidth() / 2 - 110, 100);
		Font fnt1 = new Font("Times New Roman", Font.PLAIN, 40);
		g2d.setFont(fnt1);
		g2d.drawString("Play", this.playButton.x, this.playButton.y + this.playButton.height);
		g2d.drawString("Help", this.helpButton.x, this.helpButton.y + this.helpButton.height);
		g2d.drawString("Quit", this.quitButton.x, this.quitButton.y + this.quitButton.height);
		
	}
	
	public Rectangle getPlayButton() {
		return this.playButton;
	}
	
	public Rectangle getHelpButton() {
		return this.helpButton;
	}
	
	public Rectangle getQuitButton() {
		return this.quitButton;
	}

}
