package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class InGameScreen implements Screen{    
    private ArrayList<Entity> entities = new  ArrayList<Entity>();
	private ArrayList<Background> level = new  ArrayList<Background>();
	private ArrayList<String> dialogText = new ArrayList<String>();
	private Player player;
	private SpriteBatch batch;
	private BitmapFont font;
	private ijdkwtd game;
	private int dialogCompteur=0;
	private Reader reader = new Reader();
	private String langue, niveau, monologue, temp;
	private NotePanel notePanel;
	Music music;
	
	public InGameScreen(ijdkwtd game){
		this.game= game; 
		this.player = new Player(game);
		//background
		level.add(new Background(game,new Texture(Gdx.files.internal("Background1.jpg"))));
		this.game = game;
		batch=new SpriteBatch();
		font= new BitmapFont();
		font.setColor(Color.YELLOW);		
		this.notePanel=  new NotePanel(this.game,this.player); 		
		//test takeitem
	
		entities.add(notePanel);		
		entities.add(new Switch(game,new Texture(Gdx.files.internal("switch1.jpg")),753,166));
		
		
		entities.add(new NoteItem(game,new Texture(Gdx.files.internal("item/note_mur.png")),this.player, 300,214));	
		entities.add(new NoteItem(game,new Texture(Gdx.files.internal("item/note_mur.png")),this.player, 400,214));
		entities.add(new NoteItem(game,new Texture(Gdx.files.internal("item/note_mur.png")),this.player, 500,214));
		entities.add(new NoteItem(game,new Texture(Gdx.files.internal("item/note_mur.png")),this.player, 200,214));	
		//entities.add(new KeyItem(game,this.player, 600,214));
		
		entities.add(this.notePanel);
		entities.add(this.notePanel.getCross());
		entities.add(this.notePanel.getArrowLeft());
		entities.add(this.notePanel.getArrowRight());		
		entities.add(new Switch(game,new Texture(Gdx.files.internal("switch1.jpg")),753,166));
		entities.add(new Door(game,new Texture(Gdx.files.internal("door1.jpg")),831,47));
		entities.add(this.player);
		//DIALOG//
		//TODO Faire un appel de la création de monologue grace à la langue et le niveau.
		speak(game.getLangue(), "cavedebut"/*niveau*/);
		music = Gdx.audio.newMusic(Gdx.files.internal("music/cave.mp3"));
	}

	public void speak(String langue, String cas){
		monologue = reader.read(langue, cas);
		do{
			int index = monologue.indexOf('|');
			dialogText.add(monologue.substring(0,index));
			monologue = monologue.substring(index+1);
		}while (!(monologue.equals(" ")));
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
        
        System.out.println(game.getLangue());
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
