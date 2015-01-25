package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.graphics.Texture;

//an item is an entity which have a specific behavior when used
//ex: a switch or a door etc
public abstract class Item extends Entity{
	public Item(ijdkwtd game, Texture t){
		super(game,t);
	}
	public Item(ijdkwtd game,Texture t,int x,int y){
		super(game,t,x,y);
	}
	public boolean collideWith(int x,int y){
		return (x > this.box.x && x < this.box.x+this.box.width) && 
		(y < ijdkwtd.HEIGHT -this.box.y && y > ijdkwtd.HEIGHT-this.box.y-this.box.height);
	}
	public void update(int dt){
		super.update(dt);	
	}	
	//define the behavior of the item when activated
	public abstract void activate();
}
