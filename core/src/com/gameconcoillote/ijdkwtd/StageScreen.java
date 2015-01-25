package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StageScreen implements Screen {
	private Stage stage;
	@SuppressWarnings("unused")
	private ijdkwtd game;

	public StageScreen(ijdkwtd game){
		stage=new Stage();
		this.game = game;
	}
	@Override
	public void show(){
		stage=new Stage();
	}
	@Override
	public void render(float delta){
		 Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		 Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 stage.act(Gdx.graphics.getDeltaTime());
		 stage.draw();
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub	
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub	
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub	
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub	
	}
}
