package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by naum on 1/25/15.
 */
public class Switch extends Item {
    private boolean status = true;
    Texture onn = new Texture(Gdx.files.internal("switch1.jpg"));
    Texture off = new Texture(Gdx.files.internal("switch2.jpg"));

    public Switch(ijdkwtd game,Texture t){
        super(game,t);
        status = false;
    }
    public Switch(ijdkwtd game,Texture t,int x,int y){
        super(game,t,x,y);
        status = false;
    }
    //draw the entity on the screen
    public void draw(SpriteBatch sprite){
        if(this.visible){
            sprite.begin();
            if (status){
                sprite.draw(onn, box.x, box.y);
            }
            else{
                sprite.draw(off, box.x, box.y);
            }
            sprite.end();
        }
    }
    public void activate() {
        if (status){
            System.out.println("Switch to on");
            ((InGameScreen) game.getScreen()).level = new Background(game,new Texture(Gdx.files.internal("Background1.jpg")));
            status = false;
        }
        else{
            System.out.println("Switch to on");
            ((InGameScreen) game.getScreen()).level = new Background(game,new Texture(Gdx.files.internal("black_Background.png")));
            status = true;
        }
    }
}
