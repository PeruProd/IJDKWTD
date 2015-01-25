package com.gameconcoillote.ijdkwtd;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.gameconcoillote.ijdkwtd.Entity;

public class NotePanel extends Entity
{
	
	private class CrossItem extends Item
	{

		public CrossItem() {
			super(new Texture(Gdx.files.internal("item/croix.png")));

		}

		@Override
		public void activate() {
			System.out.println("CROSS");
			
		}
		
	}
	
	private InGameScreen igs;
	private CrossItem cross = new CrossItem();
	
	public NotePanel(InGameScreen i) {
		super(new Texture(Gdx.files.internal("item/note_lecture.png")), 0, 0);
		this.igs = i;
		//this.visible = false;
		// TODO Stub du constructeur généré automatiquement
	}
	
	

}
