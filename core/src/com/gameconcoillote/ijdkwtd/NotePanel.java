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
	
	private InGameScreen igs;
	private CrossItem cross = new CrossItem(this);
	
	public NotePanel(InGameScreen i) {
		super(new Texture(Gdx.files.internal("item/note_lecture.png")), 0, 0);
		this.igs = i;
		this.igs.addEntity(this.cross);

	}
	
	public void setVisible(boolean b)
	{
		this.cross.visible = b;
		this.visible = b;
	}
	
	

}
