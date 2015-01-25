package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

public class TakeItem extends Item
{

	private Player player;
	private boolean canTake = true;
	private boolean canActivate = false;
	private boolean oneUse = false;
	
	public TakeItem(Texture t,Player p) {
		super(t);
		this.player = p;
	}
	
	public TakeItem(Texture t,Player p,int x,int y) {
		super(t,x,y);
		this.player = p;
	}

	@Override
	public void activate() {
		
		if(this.canTake)
		{
			take();
		}
		else if(this.canActivate)
		{
			use();
			
			if(this.oneUse) this.canActivate = false;
		}
		
		
	}
	
	public void use()
	{
		System.out.println("SALUT");
	}
	
	public void take()
	{
		if(this.canTake)
		{
			this.player.takeItem(this);
			//this.visible = false;
			this.canTake = false;
			this.canActivate = true;
		}
	}

	public boolean canTake()
	{
		return this.canTake;
	}
}
