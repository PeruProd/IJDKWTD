package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

public class TakeItem extends Item
{

	protected Player player;
	private boolean canTake = true;
	private boolean canActivate = false;
	private boolean oneUse = false;
	private boolean locked = false;
	
	public TakeItem(ijdkwtd game,Texture t,Player p) {
		super(game,t);
		this.player = p;
	}
	
	public TakeItem(ijdkwtd game,Texture t,Player p,int x,int y) {
		super(game,t,x,y);
		this.player = p;
	}

	@Override
	public void activate() {
		if(!this.locked)
			{
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
		
		
	}
	
	public void use()
	{
		System.out.println("SALUT");
	}
	
	public void update(int dt)
	{
		super.update(dt);;
	}
	
	public void take()
	{
		if(this.canTake && !this.locked)
		{
			this.player.takeItem(this);
			this.canTake = false;
			this.canActivate = true;
			this.activeDist = 100000;//infinity
		}
	}

	public boolean canTake()
	{
		return this.canTake;
	}
	
	public void lock()
	{
		this.locked = true;
		this.visible =false;
		this.canTake = false;
		this.canActivate = false;
		
	}
}
