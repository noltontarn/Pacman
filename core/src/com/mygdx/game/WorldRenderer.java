package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private PacmanGame pacmanGame;
	private SpriteBatch batch;
	private World world;
	private Texture pacmanImg;
	private Pacman pacman;
	private MazeRenderer mazeRenderer;

	public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        batch = pacmanGame.batch;
 
        this.world = world;
        pacman = world.getPacman();
        pacmanImg = new Texture("pacman.png");
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
    }
	
	public void render(float delta) {
		mazeRenderer.render();
    	SpriteBatch batch = pacmanGame.batch;
    	Vector2 pos = pacman.getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x, pos.y);
        batch.end();
    }
}
