package com.gameconcoillote.ijdkwtd;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameconcoillote.ijdkwtd.Entity;

public class NotePanel extends Entity{
	
	private class CrossItem extends Item{
		private NotePanel notePanel;
		
		public CrossItem(ijdkwtd game,NotePanel np) {
			super(game,new Texture(Gdx.files.internal("item/croix.png")));
			notePanel = np;			
			this.box.x = this.notePanel.box.x-5;
			this.box.y = this.notePanel.box.y-5;
			this.activeDist = 100000;//infinity
		}
		@Override
		public void activate(){
			this.notePanel.setVisible(false);
		}
	}
	private class ArrowLeftItem extends Item{
		private NotePanel notePanel;
		
		public ArrowLeftItem(ijdkwtd game,NotePanel np){
			super(game,new Texture(Gdx.files.internal("item/fleche_gauche_pleine.png")),0,0);
			notePanel = np;		
			this.box.x = this.notePanel.box.x - this.notePanel.box.x/3;
			this.box.y = this.notePanel.box.y + this.notePanel.box.height/2;
			
			this.activeDist = 100000;//infinity
		}
		@Override
		public void activate(){
			if(this.notePanel.currentNote-1 >= 0){
				this.notePanel.currentNote--;
			}
		}
	}
	private class ArrowRightItem extends Item{
		private NotePanel notePanel;
		
		public ArrowRightItem(ijdkwtd game,NotePanel np) {
			super(game,new Texture(Gdx.files.internal("item/fleche_droite_pleine.png")),0,0);
			notePanel = np;		
			this.box.x = this.notePanel.box.x + this.notePanel.box.width;
			this.box.y = this.notePanel.box.y + this.notePanel.box.height/2;
			this.activeDist = 100000;//infinity
		}
		@Override
		public void activate(){
			if(this.notePanel.currentNote+1 < this.notePanel.notes.size() && this.notePanel.currentNote+1 < this.notePanel.player.nbNote() ){
				this.notePanel.currentNote++;
			}
		}
	}
	@SuppressWarnings("unused")
	private InGameScreen igs;
	private CrossItem cross = new CrossItem(game,this);
	private ArrowLeftItem arrowLeft = new ArrowLeftItem(game,this);
	private ArrowRightItem arrowRight = new ArrowRightItem(game,this);
	private ArrayList<Texture> notes = new ArrayList<Texture>();
	private int currentNote = 0;
	private Player player;
	
	public NotePanel(ijdkwtd game,Player p) {
		super(game,new Texture(Gdx.files.internal("item/note_lecture.png")),ijdkwtd.WIDTH/3,ijdkwtd.HEIGHT/6);	
		/*this.game.addEntity(this.cross);
		this.game.addEntity(this.arrowLeft);
		this.game.addEntity(this.arrowRight);*/		
		this.notes.add(new Texture(Gdx.files.internal("notes/note1.png")));
		this.notes.add(new Texture(Gdx.files.internal("notes/note2.png")));
		this.player = p;
		setVisible(false);
	}
	public CrossItem getCross(){
		return this.cross;
	}
	public ArrowLeftItem getArrowLeft(){
		return this.arrowLeft;
	}
	public ArrowRightItem getArrowRight(){
		return this.arrowRight;
	}
	public void draw(SpriteBatch sprite){
		super.draw(sprite);
		if(this.visible){	
			sprite.begin();
			sprite.draw(this.notes.get(this.currentNote),this.box.x,this.box.y);
			sprite.end();
		}
	}
	public void setVisible(boolean b){
		this.arrowLeft.visible = b;
		this.arrowRight.visible = b;
		this.cross.visible = b;
		this.visible = b;
	}
}
