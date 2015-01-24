package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

public class TakeItem extends Item
{

	public TakeItem(Texture t) {
		super(t);

	}
	
	public TakeItem(Texture t,int x,int y) {
		super(t,x,y);

	}

	@Override
	public void activate() {
		System.out.println("TESSST");
		
	}

}
