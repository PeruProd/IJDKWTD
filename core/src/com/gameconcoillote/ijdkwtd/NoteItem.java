package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

public class NoteItem extends TakeItem{
	public NoteItem(ijdkwtd g,Texture t, Player p, int x, int y){
		super(g,t, p, x, y);
	}
	public NoteItem(ijdkwtd g,Texture t, Player p){
		super(g,t, p);
	}
	public void use(){
		if(game.getScreen().getClass().getName().compareTo("com.gameconcoillote.ijdkwtd.InGameScreen") == 0){
			((InGameScreen) game.getScreen()).getNotePanel().setVisible(true);
		}
	}
}
