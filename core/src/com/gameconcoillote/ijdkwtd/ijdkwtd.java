package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;


public class ijdkwtd extends Game implements InputProcessor{
	private Screen inGameScreen, menuScreen;
	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
    private int dt;//main game loop time
      
    @Override
    public void create(){
        inGameScreen = new InGameScreen(this);
        menuScreen = new MenuScreen(this);
        Gdx.input.setInputProcessor(this);
        setScreen(menuScreen);
    }

    /*@Override
    public void render(){
    	Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
    	Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    	this.dt =(int)(System.currentTimeMillis() - this.dt);
        super.render();
        this.inGameScreen.render(dt);
        this.dt = (int)System.currentTimeMillis();
    }*/
    @Override
    public boolean keyDown(int keycode){
        return false;
    }
    @Override
    public boolean keyUp(int keycode){	
        return false;
    }
    @Override
    public boolean keyTyped(char character){
        //System.out.println("Key pressed: " + character);
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){
        //System.out.println("Mouse coords:" + screenX + " " + screenY);

        if(getScreen().getClass().getName().compareTo("com.gameconcoillote.ijdkwtd.InGameScreen") == 0){

            ((InGameScreen) this.inGameScreen).getPlayer().move(screenX, screenY);
        }
        else if(getScreen().getClass().getName().compareTo("com.gameconcoillote.ijdkwtd.MenuScreen") == 0){

            setScreen(inGameScreen);
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button){
        if(getScreen().getClass().getName().compareTo("com.gameconcoillote.ijdkwtd.InGameScreen") == 0) {
            ((InGameScreen) this.inGameScreen).getPlayer().changeAnimation(0);
            
            for(Entity e: ((InGameScreen) this.inGameScreen).getEntities())
            {
            	if(e instanceof Item)
            	{
            		if(((Item) e).collideWith(screenX, screenY))
            		{
            			((Item) e).activate();
            		}
            	}
            }
        }
        
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer){
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY){
        return false;
    }
    @Override
    public boolean scrolled(int amount){
        return false;
    }
}
