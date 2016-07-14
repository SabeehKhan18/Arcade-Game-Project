package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Game.Game;
import Game.Sprites;
import Weapons.Blaster;
import Weapons.Lancer;
import Weapons.RYNO;
import Weapons.Weapon;

public class Player extends Movable {

	private int x,y;
	private int lastX, lastY, xSpawn, ySpawn;
	private int speed, weaponNumber, deathCount;
	private boolean isMoveValid, isDead;
	private Weapon w;
	public Player(Game game, int xSpawn, int ySpawn){
		super(game);
		this.x = xSpawn; this.y = ySpawn;
		this.xSpawn = xSpawn; this.ySpawn = ySpawn;
		this.lastX = this.x; this.lastY = this.y;
		this.speed = 3;
		this.isMoveValid = true;
		this.isDead = false;
		this.deathCount = 0;
	}
	
	@Override
	public void tick() {
		move();
	}
	
	@Override
	public void render(Graphics2D g){
		if (!this.isMoveValid) {
			this.x = this.lastX;
			this.y = this.lastY;
		}
		g.drawImage(Sprites.player, this.x, this.y, 32, 32, null);
		if (this.game.getKeyManager().space) {
			this.shoot();
		}
	}
	
	public void move() {
		this.isMoveValid = true;
		this.lastX = this.x;
		this.lastY = this.y;
		if (this.game.getKeyManager().up) {
			this.y -= this.speed;
		}
		if (this.game.getKeyManager().down) {
			this.y += this.speed;
		}
		if (this.game.getKeyManager().left) {
			this.x -= this.speed;
		}
		if (this.game.getKeyManager().right) {
			this.x += this.speed;
		}
		if (this.game.getKeyManager().one) {
			this.setWeaponNumber(1);
		}
		if (this.game.getKeyManager().two) {
			this.setWeaponNumber(2);
		}
		if (this.game.getKeyManager().three) {
			this.setWeaponNumber(3);
		}
		if (this.y < 800-(10*32) || this.y > 800-32 || this.x < 0 || this.x > 800-32) {
			this.isMoveValid = false;
		}
	}
	
	public void shoot(){
		
		if (!this.game.hasWeapon()) {
			switch(this.weaponNumber) {
			case 2:
				this.w = new RYNO(this.game, this.x, this.y);
				break;
			case 3:
				this.w = new Lancer(this.game, this.x, this.y);
				break;
			default: 
				this.w = new Blaster(this.game, this.x, this.y);
				break;
			}
			this.game.addMovable(this.w);
		}

	}
	@Override
	public void die() {
		this.isDead = true;
	}
	
	public void setIsMoveValid(boolean value) {
		this.isMoveValid = value;
	}

	@Override
	public void collide(Movable m) {
		m.collideWithPlayer(this);
	}

	@Override
	public void collideWithPlayer(Player p) {
		// Nothing to do here
	}

	@Override
	public void collideWithMushroom(Mushroom m) {
		this.setIsMoveValid(false);
	}

	@Override
	public void collideWithCentipede(Centipede c) {
		this.die();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x,this.y,32,32);
	}

	@Override
	public void collideWithBlaster(Blaster b) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithScorpion(Scorpion s) {
		// TODO Auto-generated method stub.
		this.die();
	}

	@Override
	public void collideWithSpider(Spider sp) {
		// TODO Auto-generated method stub.
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

	public void setWeaponNumber(int i) {
		this.weaponNumber = i;
	}
	
	public boolean getIsDead(){
		return this.isDead;
	}
	public void setAlive() {
		this.deathCount++;
		this.isDead = false;
		this.x = this.xSpawn;
		this.y = this.ySpawn;
	}
	
	public int getDeathCount(){
		return this.deathCount;
	}
	
	public void setDeathCount(int count) {
		this.deathCount = count;
	}

	@Override
	public void collideWithFlea(Flea f) {
		this.die();
		f.die();
	}

}
