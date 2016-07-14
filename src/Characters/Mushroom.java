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

public class Mushroom extends Movable {

	private int x, y;
	private int damageValue;
	private boolean spiderCanKill;
	private boolean isInsidePlayerArea;
	private boolean isPoisoned;
	public static final int INITIAL_DAMAGE = 4;
	
	public Mushroom(Game game, int xLocation, int yLocation) {
		super(game);
		this.x = xLocation;
		this.y = yLocation;
		this.damageValue = Mushroom.INITIAL_DAMAGE;
		this.spiderCanKill = RandomHelper.randBoolean();
		if (game.isInsidePlayerArea(new Point2D.Double(this.x,this.y))) {
			this.isInsidePlayerArea = true;
			this.game.numMushroomsDelta(1);
		} else {
			this.isInsidePlayerArea = false;
		}
		this.isPoisoned = false;
	}
	@Override
	public void die() {
		this.game.removeMovable(this);
		if(this.isInsidePlayerArea)
			this.game.numMushroomsDelta(-1);
	}
	
	public void damage() {
		this.damageValue--;
		if (this.damageValue <= 0) {
			this.die();
		}
	}
	
	public void revive() {
		this.damageValue = Mushroom.INITIAL_DAMAGE;
	}
	
	@Override
	public void tick() {
		// Nothing to do here
	}

	@Override
	public void render(Graphics2D g) {
		if(this.isPoisoned){
			switch (this.damageValue) {
				case (4): { g.drawImage(Sprites.pMushroom0, this.x, this.y, 32, 32, null); break;
				}
				case (3):{ g.drawImage(Sprites.pMushroom1, this.x, this.y, 32, 32, null); break;
				}
				case (2):{ g.drawImage(Sprites.pMushroom2, this.x, this.y, 32, 32, null); break;
				}
				case (1):{ g.drawImage(Sprites.pMushroom3, this.x, this.y, 32, 32, null); break;
				}
			default:
				break;
			}
		}
		else{
			switch (this.damageValue) {
				case (4): { g.drawImage(Sprites.mushroom0, this.x, this.y, 32, 32, null); break;
				}
				case (3):{ g.drawImage(Sprites.mushroom1, this.x, this.y, 32, 32, null); break;
				}
				case (2):{ g.drawImage(Sprites.mushroom2, this.x, this.y, 32, 32, null); break;
				}
				case (1):{ g.drawImage(Sprites.mushroom3, this.x, this.y, 32, 32, null); break;
				}
			default:
				break;
			}
		}
	}
	
	public void poison() {
		this.isPoisoned = true;
	}

	@Override
	public void collide(Movable m) {
		m.collideWithMushroom(this);
	}

	@Override
	public void collideWithPlayer(Player p) {
		p.setIsMoveValid(false);
	}

	@Override
	public void collideWithMushroom(Mushroom m) {
		this.die();
	}

	@Override
	public void collideWithCentipede(Centipede c) {
//		c.setIsMoveValid(false);
		c.collideWithMushroom(this);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, 32, 32);
	}

	@Override
	public void collideWithBlaster(Blaster b) {
		if (!b.isDead()) {
			this.damage();
			b.die();
			
		}
	}

	@Override
	public void collideWithScorpion(Scorpion s) {
		s.collideWithMushroom(this);
	}

	@Override
	public void collideWithSpider(Spider sp) {
		//handled in spider instead
	}
	
	public boolean canKill() {
		return this.spiderCanKill;
	}

	@Override
	public void collideWithRYNO(RYNO r) {
		this.damage();
	}

	@Override
	public void collideWithLancer(Lancer l) {
		this.damage();
		l.die();
	}

	public boolean isInPlayerArea() {
		return this.isInsidePlayerArea;
	}
	
	public boolean getPoisonedStatus() {
		return this.isPoisoned;
	}
	@Override
	public void collideWithFlea(Flea f) {
		// TODO Auto-generated method stub.
		
	}
}
