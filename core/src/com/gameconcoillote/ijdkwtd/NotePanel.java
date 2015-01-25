package com.gameconcoillote.ijdkwtd;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.gameconcoillote.ijdkwtd.Entity;

public class NotePanel extends Entity
{
	
	private class CrossItem extends Item
	{
		private NotePanel notePanel;
		
		public CrossItem(NotePanel np) {
			super(new Texture(Gdx.files.internal("item/croix.png")));
			notePanel = np;
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
		}

		@Override
		public void activate() {
			this.notePanel.setVisible(false);
		}
		
	}
	
	private class ArrowRightItem extends Item
	{
		private NotePanel notePanel;
		
		public ArrowRightItem(NotePanel np) {
			super(new Texture(Gdx.files.internal("item/fleche_droite_pleine.png")),0,0);
			notePanel = np;
		}

		@Override
		public void activate() {
			this.notePanel.setVisible(false);
		}
		
	}
	
	private InGameScreen igs;
	private CrossItem cross = new CrossItem(this);
	private ArrowLeftItem arrowLeft = new ArrowLeftItem(this);
	private ArrowRightItem arrowRight = new ArrowRightItem(this);
	
	public NotePanel(InGameScreen i) {
		super(new Texture(Gdx.files.internal("item/note_lecture.png")), 100, 100);
		this.igs = i;
		
		this.igs.addEntity(this.cross);
		this.igs.addEntity(this.arrowLeft);
		this.igs.addEntity(this.arrowRight);

	}
	
	public void setVisible(boolean b)
	{
		this.arrowLeft.visible = b;
		this.arrowRight.visible = b;
		this.cross.visible = b;
		this.visible = b;
	}
	
	

}
