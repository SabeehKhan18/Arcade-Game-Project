package Weapons;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import Characters.Centipede;
import Characters.Flea;
import Characters.Movable;
import Characters.Mushroom;
import Characters.Player;
import Characters.Scorpion;
import Characters.Spider;
import Game.Game;

public class Blaster extends Weapon {
	
	private int locationX, locationY, deltaX;
	private boolean dead;
	private Color fillColor;
	
	public static final int SPEED = 20;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 2*WIDTH;
	
	
	public Blaster(Game game, int x, int y) {
		this(game, x, y, 0, Color.pink);
		
	}
	
	public Blaster(Game game, int x, int y, int deltaX, Color color) {
		super(game);
		this.locationX = x;
		this.locationY = y;
		this.dead = false;
		this.deltaX = deltaX;
		this.fillColor = color;
	}

	public boolean isDead() {
		return this.dead;
	}
	
	@Override
	public void tick() {
		this.locationY = this.locationY - SPEED;
		this.locationX += this.deltaX;
		if (!this.game.isInsideWindow(new Point2D.Double(this.locationX,this.locationY)))  
			this.die();
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(this.fillColor);
		g.fillOval(this.locationX, this.locationY, WIDTH, HEIGHT);
	}

	@Override
	public void die() {
		super.die();
		this.dead = true;
	}
	
	@Override
	public void collide(Movable m) {
		// TODO Auto-generated method stub.
		if (!this.dead) {
			m.collideWithBlaster(this);
		}
	}

	@Override
	public void collideWithPlayer(Player p) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithMushroom(Mushroom m) {
		// TODO Auto-generated method stub.
		if (!this.dead) {
			m.damage();
			this.die();
		}
	}

	@Override
	public void collideWithCentipede(Centipede c) {
		// TODO Auto-generated method stub.
		if (!this.dead) {
			this.die();
			c.die();
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub.
		return new Rectangle(this.locationX, this.locationY, WIDTH, HEIGHT);
	}

	@Override
	public void collideWithBlaster(Blaster b) {
		// TODO Auto-generated method stub.
	}

	@Override
	public void collideWithScorpion(Scorpion s) {
		// TODO Auto-generated method stub.
		s.die();
		this.die();
	}

	@Override
	public void collideWithSpider(Spider sp) {
		// TODO Auto-generated method stub.
		sp.die();
		this.die();
	}

	@Override
	public void collideWithRYNO(RYNO r) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithLancer(Lancer s) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithFlea(Flea f) {
		// TODO Auto-generated method stub.
		this.die();
		f.die();
	}


}
