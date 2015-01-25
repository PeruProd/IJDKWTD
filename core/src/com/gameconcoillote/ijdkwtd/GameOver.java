package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen{
    ijdkwtd g;
    private Background start;
    private SpriteBatch batch = new SpriteBatch();
    
    public GameOver(ijdkwtd game){
        g = game;
        start = new Background(game,new Texture(Gdx.files.internal("Game_over.png")));
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.app.log("OVER", "Dans le GameOver");
        delta *= 1000;
        start.update((int)delta);
        start.draw(this.batch);
    }
    @Override
    public void resize(int width, int height){
    }
    @Override
    public void show(){
    }
    @Override
    public void hide(){
    }
    @Override
    public void pause(){
    }
    @Override
    public void resume(){
    }
    @Override
    public void dispose(){
    }
}
