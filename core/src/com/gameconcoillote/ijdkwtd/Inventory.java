package com.gameconcoillote.ijdkwtd;

import java.util.ArrayList;

public class Inventory
{
	private ArrayList<Item> items = new ArrayList<Item>();
	
	
	public Inventory()
	{
		
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
