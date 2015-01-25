package com.gameconcoillote.ijdkwtd;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory extends Entity
{
	
	
	
	public Inventory() {
		super(new Texture(Gdx.files.internal("bar.png")),(ijdkwtd.HEIGHT)/2,0);
	}
	
	private ArrayList<Item> items = new ArrayList<Item>();
	
	
	
	
	public void draw(SpriteBatch sprite)
	{
		super.draw(sprite);
	}
	
	public void add(Item it)
	{
		this.items.add(it);
	}
	public int size()
	{
		return this.items.size();
	}
}
