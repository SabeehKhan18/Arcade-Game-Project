package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Game.Game;

public class KeyManager implements KeyListener {
		
		private Game game;
		private boolean[] keys;
		public boolean up, down, left, right, level_up, level_down, space,
		one, two, three;
		public boolean pressed = false;
		
		public KeyManager(Game game){
			this.keys = new boolean[256];
			this.game = game;
		}
		
		public void tick(){
			this.up = this.keys[KeyEvent.VK_UP];
			this.down = this.keys[KeyEvent.VK_DOWN];
			this.left = this.keys[KeyEvent.VK_LEFT];
			this.right = this.keys[KeyEvent.VK_RIGHT];
			this.level_up = this.keys[KeyEvent.VK_U];
			this.level_down = this.keys[KeyEvent.VK_D];
			this.space = this.keys[KeyEvent.VK_SPACE];
			this.one = this.keys[KeyEvent.VK_1];
			this.two = this.keys[KeyEvent.VK_2];
			this.three = this.keys[KeyEvent.VK_3];
		}

		@Override
		public void keyPressed(KeyEvent e) {
			this.keys[e.getKeyCode()] = true;
			if (e.getKeyCode() == KeyEvent.VK_P) {
				this.game.togglePaused();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
				this.keys[e.getKeyCode()] = false;
				
		}

		@Override
		public void keyTyped(KeyEvent e) {
			//nothing
		}
		
}
