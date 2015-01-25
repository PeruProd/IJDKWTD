package com.gameconcoillote.ijdkwtd.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.Files;
import com.gameconcoillote.ijdkwtd.ijdkwtd;

public class DesktopLauncher {	
		
	public static void main(String[] arg){
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Game Cancoillotte 2015: We Just Don't Know What To Do";
		config.width=ijdkwtd.WIDTH;
		config.height=ijdkwtd.HEIGHT;
		config.resizable=false;
		config.addIcon("logo_icone_32.png",Files.FileType.Local);
		new LwjglApplication(new ijdkwtd(), config);	
	}
}
