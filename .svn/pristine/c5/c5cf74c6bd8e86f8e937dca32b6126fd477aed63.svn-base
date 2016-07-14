package Levels;

import java.util.ArrayList;

import Game.Game;

public class LevelManager {
	private Game game;
	private Level level;
	private ArrayList<String> levels;
	int timer = 0;
	
	public LevelManager(Game game) {
		this.game = game;
		this.levels = new ArrayList<>();
		setLevelList();
	}
	private void setLevelList() {
		this.levels.add("level1.txt");
		this.levels.add("level2.txt");
		this.levels.add("level3.txt");
		this.levels.add("level4.txt");
		this.levels.add("level5.txt");
		this.levels.add("level6.txt");
	}
	
	public void changeLevel() {
		this.timer++;
		int size = this.levels.size();
		int curr = this.levels.indexOf(this.level.getString());
		if(curr + 1 < size){
			if (this.game.getKeyManager().level_up && this.timer % 8 == 0 ) {
				this.level = new Level(this.game, this.levels.get(curr + 1));
				System.out.println("Loaded Level: " + (curr + 2));
				this.timer = 0;
			}
		}
		if(curr > 0){
			if (this.game.getKeyManager().level_down && this.timer % 8 == 0) {
				this.level = new Level(this.game, this.levels.get(curr - 1));
				System.out.println("Loaded Level: " + (curr));
				this.timer = 0;
			}
		}
			
	}
	
	public void nextLevel() {
		int currentLevel = this.levels.indexOf(this.level.getString());
		if (currentLevel < this.levels.size()-1) {
			this.level = new Level(this.game, this.levels.get(currentLevel+1));
			System.out.println("Loaded level: " + (currentLevel+2));
		}
		else {
			this.game.win();
		}
	}
	
	public Level getLevel() {
		return this.level;
	}

	public void setLevelInit() {
		this.level = new Level(this.game, this.levels.get(0));
		System.out.println("Loaded Level: 1");
	}
}
