package com.gameconcoillote.ijdkwtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

/**
 * Created by naum on 1/25/15.
 */
public class Level2Screen implements Screen{
    private ArrayList<Entity> entities = new  ArrayList<Entity>();
    private ArrayList<Background> level = new  ArrayList<Background>();
    private ArrayList<String> dialogText = new ArrayList<String>();
    private Player player;
    private SpriteBatch batch = new SpriteBatch();
    private BitmapFont font;
    @SuppressWarnings("unused")
	private ijdkwtd game;
    private int dialogCompteur=0;
    private NotePanel notePanel;
    Music music;

    public Level2Screen(ijdkwtd game){
        //player
        this.player = new Player(game);
        entities.add(this.player);
        //background
        level.add(new Background(game,new Texture(Gdx.files.internal("Background2.jpg"))));
        this.game = game;
        //this.notePanel=  new NotePanel(game,this);
        //test takeitem;
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
    }

    public void addEntity(Entity en){this.entities.add(en);}
    public Player getPlayer(){
        return this.player;
    }

    public void nextDialog(){
        if (dialogText.size() > dialogCompteur+1)
            dialogCompteur++;
    }
    public NotePanel getNotePanel(){
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