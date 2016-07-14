package Levels;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Game.Game;
import Helpers.Utils;

public class Level {
	
	private int spawnCentX, spawnCentY, spawnPlayerX, spawnPlayerY, mushroomCount;
	private Game game;
	private int[][] tiles;
	private String path;
	private ArrayList<Rectangle> mushrooms;
	
	public Level(Game game, String path){
		this.game = game;
		this.path = path;
		this.mushrooms = new ArrayList<>();
		loadLevel(path);
	}
	
	@SuppressWarnings("unused")
	public void render(Graphics2D g) {
		//render map
		for (int y = 0; y < 25; y++) {
			for (int x = 0; x < 25; x++) {
				if (this.tiles[x][y] == 1) {
					// Create a mushroom as red block
					this.game.createMushroom(x*32, y*32);
				}
			}
		}
	}
	
	private void loadLevel(String path1){
		String level = Utils.loadFileAsString(path1);
		this.spawnPlayerX = Integer.parseInt(level.substring(0, 2));
		this.spawnPlayerY = Integer.parseInt(level.substring(3, 5));
		this.spawnCentX = Integer.parseInt(level.substring(5, 7));
		this.spawnCentY = Integer.parseInt(level.substring(8, 10));
		this.mushroomCount = Integer.parseInt(level.substring(10, 12));

		this.tiles = new int[25][25];
		for (int y = 0; y < 25; y++) {
			for (int x = 0; x < 25; x++) {
				this.tiles[x][y] = Integer.parseInt(level.substring(12+x+(y*25), 13+x+(y*25)));
			}
		}
	}

	//getters and setters
	public int getSpawnCentX() {
		return this.spawnCentX *32;
	}

	public void setSpawnCentX(int spawnCentX) {
		this.spawnCentX = spawnCentX;
	}

	public int getSpawnCentY() {
		return this.spawnCentY * 32;
	}

	public void setSpawnCentY(int spawnCentY) {
		this.spawnCentY = spawnCentY;
	}

	public int getSpawnPlayerX() {
		return this.spawnPlayerX*32;
	}

	public void setSpawnPlayerX(int spawnPlayerX) {
		this.spawnPlayerX = spawnPlayerX;
	}

	public int getSpawnPlayerY() {
		return this.spawnPlayerY*32;
	}

	public void setSpawnPlayerY(int spawnPlayerY) {
		this.spawnPlayerY = spawnPlayerY;
	}

	public int[][] getTiles() {
		return this.tiles;
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}
	
	public String getString() {
		return this.path;
	}
	
	public ArrayList<Rectangle> getMushrooms(){
		return this.mushrooms;
	}
	
	public int getMushroomCount(){
		return this.mushroomCount;
	}
	

}
