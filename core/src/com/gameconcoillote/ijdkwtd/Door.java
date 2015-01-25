package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by naum on 1/25/15.
 */
public class Door extends Item {
    @SuppressWarnings("unused")
	private boolean status = false;
    
    public Door(ijdkwtd game,Texture t){
        super(game,t);
        status = false;
    }
    public Door(ijdkwtd game,Texture t,int x,int y){
        super(game,t,x,y);
        status = false;
    }
    public void activate() {
        //game.level2Screen = new Level2Screen(game);
        //game.setScreen(game.level2Screen);

    		if(!((InGameScreen) this.game.getScreen()).getPlayer().hasAKey)
    		{
    			((InGameScreen) game.getScreen()).speak(game.getLangue(),"portesanscle");

                game.level2Screen = new Level2Screen(game);
                game.setScreen(game.level2Screen);
    		}
    		else
    		{
    			((InGameScreen) game.getScreen()).speak(game.getLangue(),"porteaveccle");
    			
    			game.gameOver = new GameOver(game);
    	        game.setScreen(game.gameOver);
    		}
        
    }
}
