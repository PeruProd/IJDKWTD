package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class MenuScreen implements Screen{
	private Background level;
	private SpriteBatch batch = new SpriteBatch();

	private ijdkwtd game;

	public MenuScreen(ijdkwtd game){
		//background
		level = new Background(new Texture(Gdx.files.internal("Background2.jpg")));
		this.game = game;
	}	 

    @Override
    public void render(float delta){
		delta *= 1000;
		Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        level.update((int)delta);
        level.draw(this.batch);
    }

    @Override
    public void resize(int width, int height){
        // TODO Auto-generated method stub    
    }
    @Override
    public void show(){
		// TODO Auto-generated method stub
    }
	@Override
	public void pause(){
		// TODO Auto-generated method stub	
	}
	@Override
	public void resume(){
		// TODO Auto-generated method stub		
	}
	@Override
	public void hide(){
		// TODO Auto-generated method stub	
	}
	@Override
	public void dispose(){
		// TODO Auto-generated method stub		
	}
}
