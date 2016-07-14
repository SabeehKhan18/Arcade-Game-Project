package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.Game;
import Weapons.Blaster;
import Weapons.Lancer;
import Weapons.RYNO;

public abstract class Movable {
	
	protected Game game;
	protected final int BORDERWIDTH, BORDERHEIGHT, SQUARESIZE = 32;
	
	public Movable(Game game) {
		this.game = game;
		this.BORDERWIDTH = game.getWidth();
		this.BORDERHEIGHT = game.getHeight();
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public void die() {
		this.game.removeMovable(this);
	}
	
	public abstract Rectangle getBounds();
	
	public abstract void collide(Movable m);
	
	public abstract void collideWithPlayer(Player p);
	
	public abstract void collideWithMushroom(Mushroom m);
	
	public abstract void collideWithCentipede(Centipede c);
	
	public abstract void collideWithBlaster(Blaster b);
	
	public abstract void collideWithRYNO(RYNO r);
	
	public abstract void collideWithScorpion(Scorpion s);
	
	public abstract void collideWithSpider(Spider sp);
	
	public abstract void collideWithLancer(Lancer l);
	
	public abstract void collideWithFlea(Flea f);
	
}
	
