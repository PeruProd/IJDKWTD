package com.gameconcoillote.ijdkwtd;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InGameScreen implements Screen{    
    private ArrayList<Entity> entities = new  ArrayList<Entity>();
	private ArrayList<Background> level = new  ArrayList<Background>();
	private ArrayList<String> dialogText = new ArrayList<String>();

	private Player player;
	private SpriteBatch batch;
	private BitmapFont font;
	private String text="PeruProd";
	private ijdkwtd game;
	private int dialogCompteur=0;
	private NotePanel notePanel = new NotePanel(this);
	Music music;
	
	public InGameScreen(ijdkwtd game){
		//player
		this.player = new Player(this);
		entities.add(this.player);
		//background
		level.add(new Background(new Texture(Gdx.files.internal("Background1.jpg"))));
		this.game = game;
		batch=new SpriteBatch();
		font= new BitmapFont();
		font.setColor(Color.YELLOW);		
		//test takeitem
		entities.add(new NoteItem(new Texture(Gdx.files.internal("item/note_mur.png")),this.player, 300,214));
		entities.add(new NoteItem(new Texture(Gdx.files.internal("item/note_mur.png")),this.player, 200,214));
		
		entities.add(notePanel);
		
		entities.add(new Switch(new Texture(Gdx.files.internal("switch1.jpg")),753,166));
		//DIALOG//
		dialogText.add("Hi you.");
		dialogText.add("...");
		dialogText.add("How are you ?");
		dialogText.add("...");
		dialogText.add("Seems like we're trapped...");
		dialogText.add("...");
		dialogText.add("You're not very talkative...");
		dialogText.add("...");
		dialogText.add("Well, we need to get out of this place.");
		dialogText.add("...");
		dialogText.add("Say something !");
		dialogText.add("...");
		dialogText.add("Say apple !");
		dialogText.add("...");
		dialogText.add("At least, you don't jump for no reason.");
		dialogText.add("But... Where are we...?");
		dialogText.add("This place is creepy as \"phoque\" (like they say in Besançon)");
		dialogText.add("Damn... This sounds very stressful...");

		music = Gdx.audio.newMusic(Gdx.files.internal("music/cave.mp3"));


	}	 

    @Override
    public void render(float delta){
		delta *= 1000;
		Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		music.setLooping(true);
		music.play();
    	for(Background bg: this.level){
        	bg.update((int)delta);
        	bg.draw(this.batch);
        } 
        for(Entity e: entities){
        	e.update((int)delta);
        	e.draw(this.batch);
        }
        batch.begin();
        player.saying(batch,font,dialogText.get(dialogCompteur));
        batch.end();
    }

    public void addEntity(Entity en){this.entities.add(en);}
    public Player getPlayer(){
    	return this.player;
    }

	public void nextDialog(){
		if (dialogText.size() > dialogCompteur+1)
		dialogCompteur++;
	}
	
	public NotePanel getNotePanel()
	{
		return this.notePanel;
	}
    
    public ArrayList<Entity> getEntities(){
    	return this.entities;
    } 
    
    @Override
    public void resize(int width, int height){
        // TODO Auto-generated method stub    
    }
    @Override
    public void show(){
		// TODO Auto-generated method stub
    }
	@Override
	public void pause(){
		// TODO Auto-generated method stub	
	}
	@Override
	public void resume(){
		// TODO Auto-generated method stub		
	}
	@Override
	public void hide(){
		// TODO Auto-generated method stub	
	}
	@Override
	public void dispose(){
		// TODO Auto-generated method stub		
	}
}
