package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Text {

    private String theText;
    BitmapFont bitmapFont;
    SpriteBatch spriteBatch;

    public Text(){
        theText="";
        bitmapFont=new BitmapFont();
        spriteBatch = new SpriteBatch();
    }

    public void render(){
        spriteBatch.begin();
        bitmapFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        bitmapFont.draw(spriteBatch, theText, 25, 160);
        spriteBatch.end();
    }


    public void setText(String text){
        theText = text;
    }


}

