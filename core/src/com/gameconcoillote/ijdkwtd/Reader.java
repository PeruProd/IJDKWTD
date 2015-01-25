package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.File;

/**
 * Created by Hamor on 25/01/2015.
 */
public class Reader {
    public String read(String langue, String level){
        FileHandle file;
        if (File.separatorChar == '/' ){
            file = Gdx.files.local("text/"+langue+"/"+level+".txt");
        }else{
            file = Gdx.files.local("text\\"+langue+"\\"+level+".txt");
        }

        String txt = file.readString();
        return txt;
    }
}
