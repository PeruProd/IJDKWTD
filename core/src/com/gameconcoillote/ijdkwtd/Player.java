package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
	//where the player have to go
	private Vector2 dest = new Vector2(125,0);//to make him not to walk distance where the player stop trying to reach the destination											 
	private int prec = 5;//precision of the click
	private Inventory inventory = new Inventory(game);;
	private boolean canTakeSomethingAnim = false;
	private InGameScreen igs;
	private int nbNote = 0;
	

	public Player(ijdkwtd game) {
		this(game,0,0);
		this.box.width = 250;
		this.box.height = 163;
	}	
	public Player(ijdkwtd game,int x,int y){
		super(game,new Texture(Gdx.files.internal("anim_wait_mini/wait1.png")),x,y);

		//idle
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait1.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait2.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait3.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait4.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait5.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait6.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait7.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait8.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait9.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait10.png")),0);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_wait_mini/wait11.png")),0);
		super.getAnim(0).setDelay(200);	
		//walk right
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk1.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk2.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk3.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk4.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk5.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk6.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk7.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk8.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk9.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk10.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk11.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk12.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk13.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk14.png")),1);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_right_mini/Walk15.png")),1);	
		//walk left
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk1.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk2.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk3.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk4.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk5.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk6.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk7.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk8.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk9.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk10.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk11.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk12.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk13.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk14.png")),2);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_walk_left_mini/Walk15.png")),2);	
		//nope
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope1.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope2.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope3.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope4.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope5.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope6.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope7.png")),3);
		super.addTextureInAnim(new Texture(Gdx.files.internal("anim_nope_mini/nope8.png")),3);	
	}	
	public void move(int x,int y){
		this.dest.x = x;
		this.dest.y = y;
	}
	public void update(int dt){
		
		if(this.box.x+this.box.width/2 < this.dest.x - this.prec){
			this.move.x = this.speed.x;
			this.changeAnimation(1);
		}
		else if(this.box.x +this.box.width/2> this.dest.x + this.prec){
			this.move.x = -this.speed.x;
			this.changeAnimation(2);
		}
		else{
			this.move.x = 0;
			if(this.canTakeSomethingAnim)
			{
				this.changeAnimation(3);
			}
			else
			{
				this.changeAnimation(0);
			}
		}
			
		
		super.update(dt);
		
	}
	public void saying(SpriteBatch batch, BitmapFont font,String texte){
		font.draw(batch,texte,Gdx.graphics.getWidth()-600,Gdx.graphics.getHeight()-100);
	}
	
	public void draw(SpriteBatch sprite)
	{
		super.draw(sprite);
		this.inventory.draw(sprite);
	}
	
	public void takeItem(TakeItem it)
	{
		if(!this.canTakeSomethingAnim)
		{
			if(it.canTake())
			{
				if( !(it instanceof NoteItem)  || !this.inventory.containNotes() )
				{
				
					this.inventory.add(it);
				}
				else
				{
					it.lock();
				}
				
				if(it instanceof NoteItem)
				{
					this.takeNote();
				}
					
			}
			
		}
	}
	
	public void takeNote()
	{
		this.nbNote++;
	}
	
	public int nbNote()
	{
		return this.nbNote;
	}
	
	public InGameScreen getGame()
	{
		return this.igs;
	}
}
