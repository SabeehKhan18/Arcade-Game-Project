package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import Game.Game;
import Game.Sprites;
import Helpers.RandomHelper;
import Weapons.Blaster;
import Weapons.Lancer;
import Weapons.RYNO;

public class Scorpion extends Movable {
	private int x;
	private int y;
	private int speed;
	private boolean moveRight;

	public Scorpion(Game game) {
		 super(game);
		 if (RandomHelper.randBoolean()) {
			this.x = 0;
			this.speed = 1;
			this.moveRight = true;
		 }
		 else {
			 this.x = game.getWidth() - 32;
			 this.speed = -1;
			 this.moveRight = false;
		 }
		 this.y = RandomHelper.randRange(32*5, 800 - 32*11);
	}
	
	public void move() {
		this.x += this.speed;
		if (!this.game.isInsideWindowX(new Point2D.Double(this.x, this.y))) {
			this.die();
		}
		
	}
	
	@Override
	public void tick() {
		move();
	}

	@Override
	public void render(Graphics2D g) {
		if(this.moveRight){
			g.drawImage(Sprites.scorpion, this.x, this.y, 32, 32, null);
		}
		else{
			g.drawImage(Sprites.scorpion, this.x + 32, this.y, -32, 32, null);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub.
		return new Rectangle(this.x,this.y,32,32);
	}

	@Override
	public void collide(Movable m) {
		// TODO Auto-generated method stub.
		m.collideWithScorpion(this);
	}

	@Override
	public void collideWithPlayer(Player p) {
		// never collides with player

	}

	@Override
	public void collideWithMushroom(Mushroom m) {
		// randomly poisons mushroom
		m.poison();
	}

	@Override
	public void collideWithCentipede(Centipede c) {
		// nothing to do here

	}

	@Override
	public void collideWithScorpion(Scorpion s) {
		// Nothing to do here
	}

	@Override
	public void collideWithSpider(Spider sp) {
		// TODO Auto-generated method stub.
		
	}
	
	@Override
	public void collideWithBlaster(Blaster b) {
		// TODO Auto-generated method stub.
		this.die();
		b.die();
	}

	@Override
	public void collideWithRYNO(RYNO r) {
		this.die();
	}

	@Override
	public void collideWithLancer(Lancer s) {
		// TODO Auto-generated method stub.
		this.die();
		s.die();
	}

	@Override
	public void collideWithFlea(Flea f) {
		// TODO Auto-generated method stub.
		
	}

}
