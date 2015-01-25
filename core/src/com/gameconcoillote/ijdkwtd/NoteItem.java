package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

public class NoteItem extends TakeItem
{

	public NoteItem(Texture t, Player p, int x, int y) {
		super(t, p, x, y);
	}

	public NoteItem(Texture t, Player p) {
		super(t, p);
	}
	
	public void use()
	{
		
		this.player.getGame().getNotePanel().setVisible(true);;
	}

}
