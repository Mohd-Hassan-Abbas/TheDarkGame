package i.have.an.game.thedarkgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class GameController {

    GameController(){

    }
    static String KeysCondition(){

            if(Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                return "up_right_shift";
            }else if(Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                return "up_left_shift";
            }else if(Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                return "up_left";
            }else if(Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                return "up_right";
            }else if( Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)){
                return "right_shift";
            }else if( Gdx.input.isKeyPressed(Input.Keys.LEFT) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)){
                return "left_shift";
            }else if( Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                return "left";
            }else if( Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                return "right";
            }else if( Gdx.input.isKeyPressed(Input.Keys.UP)){
                return "up";
            }else{
                return "NO_INPUT";
            }

    }
     static int getTouchOn(Rectangle rect){

        if(Gdx.input.isTouched()){
            float x = Gdx.input.getX();
            float y = Gdx.input.getY();
                y = Gdx.graphics.getHeight()-y;
            System.out.println("x: " + x + " y: " + y);
            if(x > rect.x && x < rect.x+rect.width && y > rect.y && y < rect.y+rect.height){

                return 1;
            }else{
                return -1;
            }
        }else{
            return 0;
        }
    }
}
