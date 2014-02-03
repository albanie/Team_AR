package colin.test.newapp;

import colin.test.newapp.model.Eater;
import colin.test.newapp.model.World;
import colin.test.newapp.ui.HighScore;
import colin.test.newapp.ui.Score;
import colin.test.newapp.util.PreferencesHelper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LevelCompletedScreen implements Screen{
	private static final float CAMERA_WIDTH = 10;
	private static final float CAMERA_HEIGHT = 7;
	private Game myGame;
	Stage stage;
	Eater eater;
	Table table;
	World world;
	PreferencesHelper phelp = new PreferencesHelper();
	private OrthographicCamera cam;
public LevelCompletedScreen(Game myGame,World world){
	this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
	this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
	this.cam.update();
	this.myGame=myGame;
	this.world=world;
	this.eater=this.world.getEater();
}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 1f, 0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		int highScore =phelp.getHighScore();
		Skin skin = new Skin(Gdx.files.internal("data/textbuttons.json"));
		BitmapFont buttonFont = new BitmapFont();
		table=new Table();
		table.setFillParent(true);
		stage=new Stage();
		Label highScoreLabel = new Label( "Highscore "+highScore, skin);
		Label scoreLabel = new Label( "Score "+eater.getScore(), skin);
		table.add(highScoreLabel);
		table.row();
		table.add(scoreLabel).pad(10);
		table.row();
		if(world.loadNextLevel()){
		
		TextButton nextLevelButton = new TextButton("Next Level", skin );
		nextLevelButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				myGame.getScreen().dispose();
				

				myGame.setScreen(new GameScreen(myGame,world));
					}
			
	});
		//button2.setPosition(Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-100);
		table.add(nextLevelButton).pad(10);
		}
		
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}