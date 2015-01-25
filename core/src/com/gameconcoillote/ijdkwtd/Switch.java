package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by naum on 1/25/15.
 */
public class Switch extends Item {

    private boolean status = false;
    Texture onn = new Texture(Gdx.files.internal("switch1.jpg"));
    Texture off = new Texture(Gdx.files.internal("switch2.jpg"));

    public Switch(Texture t){
        super(t);
        status = false;
    }

    public Switch(Texture t,int x,int y){
        super(t,x,y);
        status = false;
    }

    //draw the entity on the screen
    public void draw(SpriteBatch sprite){
        if(this.visible)
        {
            sprite.begin();
            if (status){
                sprite.draw(onn, box.x, box.y);
            }else{
                sprite.draw(off, box.x, box.y);
            }

            sprite.end();
        }
    }

    public void activate() {
        if (status) {
            System.out.println("Switch to off");
            status = false;
        }else{
            System.out.println("Switch to on");
            status = true;
        }
    }

}
