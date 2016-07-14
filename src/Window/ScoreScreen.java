package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.Game;

public class ScoreScreen {
	
	private Game game;
	private Rectangle toHome;
	private Rectangle playAgain;
	
	public ScoreScreen(Game game) {
		this.game = game;
		this.toHome = new Rectangle(this.game.getWidth() / 2 - 60,
				550,110,50);
		this.playAgain = new Rectangle(this.game.getWidth() / 2 - 60,
				650,250,50);
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font fnt0 = new Font("Times New Roman",Font.ITALIC, 50);
		
		g2.setColor(Color.WHITE);
		g2.setFont(fnt0);
		g2.drawString("GAME OVER", this.game.getWidth() /3, this.game.getHeight() /2 - 100);
		Font fnt1 = new Font("Times New Roman",Font.PLAIN, 50);
		g2.setFont(fnt1);
		g2.drawString("Your Score:" + String.valueOf(this.game.getScore()), 270, 450);
		g2.drawString("Menu", (int) this.toHome.getMinX(),(int) (this.toHome.getMinY()+this.toHome.getHeight()));
		g2.drawString("Play Again?", (int)this.playAgain.getMinX(), (int)(this.playAgain.getMinY()+this.playAgain.getHeight()));
		
		g2.setColor(Color.BLACK);
		g2.draw(this.toHome);
		g2.draw(this.playAgain);
		
	}
	
	public Rectangle getToHome() {
		return this.toHome;
	}
	
	public Rectangle getPlayAgain() {
		return this.playAgain;
	}

}
