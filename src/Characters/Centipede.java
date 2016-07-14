package Characters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.Game;
import Game.Sprites;
import Weapons.Blaster;
import Weapons.Lancer;
import Weapons.RYNO;

public class Centipede extends Movable {
	
	protected int x, y, lastX, lastY, xSpawn, ySpawn, numBodies;
	private int yStep;
	private int count = 0, bodyCount;
	private boolean hit, movingLeft, isMoveValid, movingDown, movingLeftBody, hitBody, firstHead;
	private Centipede lastBody;
	private Centipede after, before;
	public static final Color BODYCOLOR = Color.green;
	public static final Color HEADCOLOR = Color.black;
	public static final Color BODYBORDER = Color.red;
	
	public Centipede(Game game, int xSpawn, int ySpawn, int numBodies) {
		super(game);
		this.x = xSpawn;
		this.y = ySpawn;
		this.xSpawn = xSpawn;
		this.ySpawn = ySpawn;
		this.lastX = this.x;
		this.lastY = this.y;
		this.hit = false;
		this.hitBody = false;
		this.movingDown = false;
		this.movingLeft = true;
		this.movingLeftBody = true;
		this.isMoveValid = true;
		this.numBodies = numBodies;
		this.bodyCount = numBodies;
		this.yStep = 32;
		this.firstHead = true;
	}
	
	public void move() {
		// Now actually perform the move
		if (this.before == null) {
			headMove();
		}
		else {
			bodyMove();
		}
		
		// For the first few moves, create the new body pieces
		if(this.bodyCount > 0){
			if (this.bodyCount == this.numBodies) {
				Centipede body1 = new Centipede(this.game, this.xSpawn, this.ySpawn, 0);
				this.game.addMovable(body1);
				body1.setBefore(this);
				this.setAfter(body1);
				this.lastBody = body1;
			}
			else {
				Centipede newBody = new Centipede(this.game, this.xSpawn, this.ySpawn, 0);
				this.game.addMovable(newBody);
				newBody.setBefore(this.lastBody);
				this.lastBody.setAfter(newBody);
				this.lastBody = newBody;
			}
			this.bodyCount--;
		}
	}
	
	public void headMove() {
		this.isMoveValid = true;
		this.lastX = this.x;
		this.lastY = this.y;
		
//		if (this.firstHead) {
//			this.firstHead = false;
//			return;
//		}
		
		if (this.hit) {
			this.hit = false;
			this.movingLeft = !this.movingLeft;
		}
		if (this.movingLeft && !this.movingDown) {
			this.x -= 32;
		}
		if (!this.movingLeft && !this.movingDown){
			this.x += 32;
		}
		if (this.movingDown) {
			this.yStep = 32;
			this.y += this.yStep;
			if (this.y >= 800 - 10*32)
				this.movingDown = false;
		}
		if(this.x == this.BORDERWIDTH && !this.movingLeft){
			this.movingLeft = !this.movingLeft;
			this.isMoveValid = false;
			this.y += this.yStep;
		}
		if(this.x <= -5 && this.movingLeft){
			this.movingLeft = !this.movingLeft;
			this.isMoveValid = false;
			this.y += this.yStep;
		}
		
		if (this.y + 32 >= this.BORDERHEIGHT || (this.y <= 32 && this.yStep < 0)) {
			Centipede current = this;
			while (current != null) {
				current.yStep = -current.yStep;
				current = current.after;
			}
		}
	}
	
	public void bodyMove() {
		// Controls body movement
		this.lastX = this.x;
		this.lastY = this.y;
		this.x = this.before.getLastX();
		this.y = this.before.getLastY();
		
		
		// Helps with graphics
		if (this.hitBody) {
			this.hitBody = false;
			this.movingLeftBody = !this.movingLeftBody;
		}
		if(this.x == 0 && this.movingLeftBody){
			this.movingLeftBody = !this.movingLeftBody;
		}
		if(this.x == this.BORDERWIDTH-32 && !this.movingLeftBody){
			this.movingLeftBody = !this.movingLeftBody;
		}
	}
	
	@Override
	public void tick(){
		//temp code
		if(this.count >= 10){
			move();
			this.count = 0;
		}
		this.count++;
	}
	
	@Override
	public void render(Graphics2D g) {
		if (this.before == null) {
			headRender(g);
			return;
		}
		bodyRender(g);
	}
	
	public void headRender(Graphics2D g) {
		if(!this.isMoveValid){
			this.x = this.lastX;
			this.y = this.lastY + this.yStep;
		}
		if (this.firstHead) {
			this.firstHead = false;
			this.x = this.lastX; this.y = this.lastY;
		}
		if(this.movingLeft){
			g.drawImage(Sprites.centHead, this.x + 32, this.y, -32, 32, null);
		}
		else{
			g.drawImage(Sprites.centHead, this.x, this.y, 32, 32, null);
		}
	}
	
	public void bodyRender(Graphics2D g) {
		if(this.movingLeftBody){
			g.drawImage(Sprites.centBody, this.x + 32, this.y, -32, 32, null);
		}
		else{
			g.drawImage(Sprites.centBody, this.x, this.y, 32, 32, null);
		}
	}

	@Override
	public void die() {
		super.die();
		
		this.game.createMushroom(this.x,this.y);
		
		
		if (this.before != null) {
			this.before.setAfter(null);
		}
		if (this.after != null) {
			this.after.setBefore(null);
		}
	}
	
	public void setIsMoveValid(boolean value) {
		this.isMoveValid = value;
	}
	
	public void hitMushroom() {
		this.isMoveValid = false;
		this.hit = true;
		this.hitBody = true;
	}
	
	public void setAfter(Centipede after) {
		this.after = after;
	}
	
	public void setBefore(Centipede before) {
		this.before = before;
	}
	
	@Override
	public void collide(Movable m) {
		m.collideWithCentipede(this);
		
	}

	@Override
	public void collideWithPlayer(Player p) {
		p.die();
	}

	@Override
	public void collideWithMushroom(Mushroom m) {
//		hit = true;
		this.hitMushroom();
		if (m.getPoisonedStatus()) {
			this.movingDown = true;
		}
	}

	@Override
	public void collideWithCentipede(Centipede c) {
		this.hitMushroom();
		c.hitMushroom();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, 32, 32);
	}

	@Override
	public void collideWithBlaster(Blaster b) {
		this.die();
		b.die();
	}

	@Override
	public void collideWithScorpion(Scorpion s) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithSpider(Spider sp) {
		// TODO Auto-generated method stub.
		
	}

	public int getLastX() {
		return this.lastX;
	}

	public int getLastY() {
		return this.lastY;
	}

	@Override
	public void collideWithRYNO(RYNO r) {
		this.die();
		r.die();
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
