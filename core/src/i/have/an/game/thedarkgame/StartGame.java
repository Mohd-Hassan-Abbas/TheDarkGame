package i.have.an.game.thedarkgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class StartGame {

    static  int startBtnClicked =0;
    static SpriteBatch batch;

    static Texture startGameBtn;
    static Rectangle startGameBtnRectl1;
    static Texture backgroundImage;

    StartGame(SpriteBatch sp){

        batch = sp;

        setRect();

        backgroundImage = new Texture("background_static1.jpg");
        startGameBtn = new Texture("start_blue-green_btn.jpg");


    }

    static void render(){

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(230,100,150,0);
        batch.begin();
        batch.draw(backgroundImage,0,0,(float)Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight());
        batch.draw(startGameBtn,startGameBtnRectl1.getX(),startGameBtnRectl1.getY(),startGameBtnRectl1.getWidth(),startGameBtnRectl1.getHeight());
        batch.end();

        Controllers();
    }

    static void dispose(){

        startGameBtn.dispose();
        backgroundImage.dispose();
    }

    static void setRect(){

        startGameBtnRectl1 = new Rectangle((float)Gdx.graphics.getWidth()/2-75, (float)Gdx.graphics.getHeight()/2-(float)Gdx.graphics.getHeight()/4,150,60);
        System.out.println("rectX : " + startGameBtnRectl1.getX() + "  rectY" + startGameBtnRectl1.getY() + " rectWidth" + startGameBtnRectl1.getWidth() + " rectHeight" + startGameBtnRectl1.getHeight());
    }

    static void Controllers(){

        startBtnClicked = GameController.getTouchOn(startGameBtnRectl1);

        if (startBtnClicked == 1) MyGdxGame.CurrentScreen = 1;


    }
}
