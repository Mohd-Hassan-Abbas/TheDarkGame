package i.have.an.game.thedarkgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	MainScreen mainScreen;
	StartGame startGame;
	 static int CurrentScreen = 0;

	@Override
	public void create () {

		batch = new SpriteBatch();
			startGame = new StartGame(batch);
			mainScreen = new MainScreen(batch);

	}

	@Override
	public void render () {

		if (CurrentScreen == 0) {
			StartGame.render();

		} else if (CurrentScreen==1) {


			MainScreen.render();
		}

	}
	
	@Override
	public void dispose () {

		batch.dispose();
		if (CurrentScreen == 0) {
			StartGame.dispose();

		}else if(CurrentScreen==1){
			MainScreen.dispose();
		}


	}
}
