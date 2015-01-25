package com.gameconcoillote.ijdkwtd;



import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameconcoillote.ijdkwtd.Entity;

public class NotePanel extends Entity
{
	
	private class CrossItem extends Item
	{
		private NotePanel notePanel;
		
		public CrossItem(NotePanel np) {
			super(new Texture(Gdx.files.internal("item/croix.png")));
			notePanel = np;
			
			
			this.box.x = this.notePanel.box.x-5;
			this.box.y = this.notePanel.box.y-5;
			
		}

		@Override
		public void activate() {
			this.notePanel.setVisible(false);
		}
		
	}
	
	private class ArrowLeftItem extends Item
	{
		private NotePanel notePanel;
		
		public ArrowLeftItem(NotePanel np) {
			super(new Texture(Gdx.files.internal("item/fleche_gauche_pleine.png")),0,0);
			notePanel = np;
			
			this.box.x = this.notePanel.box.x - this.notePanel.box.x/3;
			this.box.y = this.notePanel.box.y + this.notePanel.box.height/2;
		}

		@Override
		public void activate() {
			this.notePanel.currentNote--;
		}
		
	}
	
	private class ArrowRightItem extends Item
	{
		private NotePanel notePanel;
		
		public ArrowRightItem(NotePanel np) {
			super(new Texture(Gdx.files.internal("item/fleche_droite_pleine.png")),0,0);
			notePanel = np;
			
			this.box.x = this.notePanel.box.x + this.notePanel.box.width;
			this.box.y = this.notePanel.box.y + this.notePanel.box.height/2;
		}

		@Override
		public void activate() {
			this.notePanel.currentNote++;
		}
		
	}
	
	private InGameScreen igs;
	private CrossItem cross = new CrossItem(this);
	private ArrowLeftItem arrowLeft = new ArrowLeftItem(this);
	private ArrowRightItem arrowRight = new ArrowRightItem(this);
	private ArrayList<Texture> notes = new ArrayList<Texture>();
	private int currentNote = 0;
	
	public NotePanel(InGameScreen i) {
		super(new Texture(Gdx.files.internal("item/note_lecture.png")), 200, 200);
		this.igs = i;
		
		this.igs.addEntity(this.cross);
		this.igs.addEntity(this.arrowLeft);
		this.igs.addEntity(this.arrowRight);
		
		this.notes.add(new Texture(Gdx.files.internal("notes/note1.png")));
		this.notes.add(new Texture(Gdx.files.internal("notes/note2.png")));

	}
	
	public void draw(SpriteBatch sprite){
		super.draw(sprite);
		
		if(this.visible)
		{
			
			sprite.begin();
			sprite.draw(this.notes.get(this.currentNote),this.box.x,this.box.y);
			sprite.end();
		}
	}
	
	public void setVisible(boolean b)
	{
		this.arrowLeft.visible = b;
		this.arrowRight.visible = b;
		this.cross.visible = b;
		this.visible = b;
	}
	
	

}
