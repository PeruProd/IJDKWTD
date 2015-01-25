package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by Hamor on 25/01/2015.
 */
public class Reader {
    public String read(String langue, String level){
        FileHandle file = Gdx.files.local("text\\"+langue+"\\"+level+".txt");
        String txt = file.readString();
        return txt;
    }
}
