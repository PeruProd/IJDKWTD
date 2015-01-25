package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;


public class ijdkwtd extends Game implements InputProcessor{
	private Screen inGameScreen, menuScreen;
	public final static int WIDTH = 1024; //Gdx.graphics.getDesktopDisplayMode().width
	public final static int HEIGHT = 768; //Gdx.graphics.getDesktopDisplayMode().height
    private int dt;//main game loop time
      
    @Override
    public void create(){
        inGameScreen = new InGameScreen(this);
        menuScreen = new MenuScreen(this);
        Gdx.input.setInputProcessor(this);
        setScreen(menuScreen);
    }

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
        if(getScreen().getClass().getName().compareTo("com.gameconcoillote.ijdkwtd.InGameScreen") == 0){
            if (screenY > 300) {
                ((InGameScreen) this.inGameScreen).getPlayer().move(screenX, screenY);
            }else{
                ((InGameScreen) this.inGameScreen).nextDialog();
            }
        }
        else {
            if (getScreen().getClass().getName().compareTo("com.gameconcoillote.ijdkwtd.MenuScreen") == 0) {
                if (((MenuScreen) getScreen()).menuLang) {
                    ((MenuScreen) getScreen()).gotoMenuLangue();
                } else {
                    setScreen(inGameScreen);
                }
            }
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
