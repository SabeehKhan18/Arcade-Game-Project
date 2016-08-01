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

public class Spider extends Movable {

	private int initY, x, y, diagHeight, speed;
	private boolean moveDiag;
	private static final String soundPath = "sounds\\Ratchet_&_Clank_(USA)_(En,Fr,De,Es,It).iso_03332.wav";
	
	public Spider(Game game) {
		super(game);
		this.diagHeight = this.SQUARESIZE*5;
		this.initY = RandomHelper.randRange(800-10*this.SQUARESIZE, game.getHeight());
		this.y = this.initY;
		if (RandomHelper.randBoolean()) {
			this.speed = 1;
			this.x = 0;
		} else {
			this.x = game.getWidth() - this.SQUARESIZE;
			this.speed = -1;
		}
		this.moveDiag = true;
	}
	
	@Override
	public void tick() {
		// Auto-generated method stub.
		this.move();
	}
	
	public void move() {
		if (this.moveDiag) {
			this.x += this.speed;
			this.y -= 1;
			if (this.initY - this.y >= this.diagHeight) {
				this.moveDiag = false;
			}
		} else {
			this.y += 1;
			if (this.y >= this.initY)
				this.moveDiag = true;
		}
		if (!this.game.isInsideWindowX(new Point2D.Double(this.x, this.y))) {
			this.die();
		}
	}

	@Override
	public void render(Graphics2D g) {
		// Auto-generated method stub.
		g.drawImage(Sprites.spider, this.x, this.y, 32, 32, null);
	}
	
	@Override
	public void die() {
		game.playSound(soundPath);
		super.die();
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub.
		return new Rectangle(this.x, this.y , this.SQUARESIZE, this.SQUARESIZE);
	}

	@Override
	public void collide(Movable m) {
		// TODO Auto-generated method stub.
		m.collideWithSpider(this);
	}

	@Override
	public void collideWithPlayer(Player p) {
		p.die();
	}

	@Override
	public void collideWithMushroom(Mushroom m) {
		// TODO Auto-generated method stub.
		if (m.canKill()) {
			m.die();
		}
	}

	@Override
	public void collideWithCentipede(Centipede c) {
		// nothing to do here
		
	}


	@Override
	public void collideWithScorpion(Scorpion s) {
		// nothing to do here		
	}

	@Override
	public void collideWithSpider(Spider sp) {
		// Nothing to do here
	}

	@Override
	public void collideWithRYNO(RYNO r) {
		this.die();
	}

	@Override
	public void collideWithBlaster(Blaster b) {
		// TODO Auto-generated method stub.
		this.die();
		b.die();
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
