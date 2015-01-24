package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

public class SwitchItem extends Item
{

	public SwitchItem(Texture t) {
		super(t);

	}
	
	public SwitchItem(Texture t,int x,int y) {
		super(t,x,y);

	}

	@Override
	public void activate() {
		System.out.println("TESSST");
		
	}

}
