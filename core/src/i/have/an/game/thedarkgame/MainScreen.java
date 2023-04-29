package i.have.an.game.thedarkgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class MainScreen {

    static SpriteBatch batch;
    static Texture backgroundImage;
    static Texture[][] BoyTextures;
    static Rectangle BoyRect;
    static Animation<Texture> BoyIdleAnimation;
    static Animation<Texture> BoyWalkAnimation;
    static Animation<Texture> BoyRunAnimation;
    static Animation<Texture> BoyJumpAnimation;
    static Animation<Texture> BoyDeadAnimation;
    static boolean BoyStanding = true;
    static boolean BoyWalking = false;
    static boolean BoyRunning = false;
    static boolean BoyJumping = false;
    static boolean BoyDead = false;
    static boolean leftKeyPressed = false;
    static boolean rightKeyPressed = false;
    static boolean upKeyPressed = false;
    static boolean shiftRightPressed = false;
    static boolean BoyRightSide = true;
    static float InitialVelocity = 10f;
    private static float time = 0f;

    MainScreen(SpriteBatch sp){

        batch = sp;

        setRect();

        resources();

        BoyIdleAnimation = new Animation<>(0.05f, new Array<>(BoyTextures[0]), Animation.PlayMode.LOOP);
        BoyWalkAnimation = new Animation<>(0.05f, new Array<>(BoyTextures[1]), Animation.PlayMode.LOOP);
        BoyRunAnimation = new Animation<>(0.05f, new Array<>(BoyTextures[2]), Animation.PlayMode.LOOP);
        BoyJumpAnimation = new Animation<>(0.1f, new Array<>(BoyTextures[3]), Animation.PlayMode.NORMAL);
        BoyDeadAnimation = new Animation<>(0.1f, new Array<>(BoyTextures[4]), Animation.PlayMode.NORMAL);

    }
    void resources(){

        backgroundImage = new Texture("background_static1.jpg");

        BoyTextures = new Texture[5][15];

        for(int i=0;i<5;i++){
            for(int j=0;j<15;j++){
                switch (i){
                    case 0:
                        BoyTextures[i][j] = new Texture("flatboy/idle/Idle ("+(j+1)+").png");
                        break;
                    case 1:
                        BoyTextures[i][j] = new Texture("flatboy/walk/Walk ("+(j+1)+").png");
                        break;
                    case 2:
                        BoyTextures[i][j] = new Texture("flatboy/run/Run ("+(j+1)+").png");
                        break;
                    case 3:
                        BoyTextures[i][j] = new Texture("flatboy/jump/Jump ("+(j+1)+").png");
                        break;
                    case 4:
                        BoyTextures[i][j] = new Texture("flatboy/dead/Dead ("+(j+1)+").png");
                        break;
                }

            }
        }


    }
    static void render(){

        time += Gdx.graphics.getDeltaTime();


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(230,100,150,0);

        batch.begin();

        batch.draw(backgroundImage,0,0,(float)Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight());

        if(BoyStanding) {
            if(BoyRightSide){
                batch.draw( BoyIdleAnimation.getKeyFrame(time), BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }else{
                Sprite s = new Sprite(BoyIdleAnimation.getKeyFrame(time));
                s.flip(true,false);
                //BoyRect.setX(BoyRect.getX() - BoyRect.getWidth());
                batch.draw(s, BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }

        } else if (BoyWalking) {

            if(BoyRightSide){
                batch.draw( BoyWalkAnimation.getKeyFrame(time), BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }else{
                Sprite s = new Sprite(BoyWalkAnimation.getKeyFrame(time));
                s.flip(true,false);
                //BoyRect.setX(BoyRect.getX() - BoyRect.getWidth());
                batch.draw(s, BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }

        } else if (BoyRunning) {

            if(BoyRightSide){
                batch.draw(BoyRunAnimation.getKeyFrame(time), BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }else{
                Sprite s = new Sprite(BoyRunAnimation.getKeyFrame(time));
                s.flip(true,false);
                //BoyRect.setX(BoyRect.getX() - BoyRect.getWidth());
                batch.draw(s, BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());
            }

        } else if (BoyJumping) {

            JumpRect(BoyRect);
            if(BoyRightSide){
                batch.draw( BoyJumpAnimation.getKeyFrame(time), BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }else{
                Sprite s = new Sprite(BoyJumpAnimation.getKeyFrame(time));
                s.flip(true,false);
                //BoyRect.setX(BoyRect.getX() - BoyRect.getWidth());
                batch.draw(s, BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }


        } else if(BoyDead) {

            if(BoyRightSide){
                batch.draw( BoyDeadAnimation.getKeyFrame(time), BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }else{
                Sprite s = new Sprite(BoyDeadAnimation.getKeyFrame(time));
                s.flip(true,false);
                //BoyRect.setX(BoyRect.getX() - BoyRect.getWidth());
                batch.draw(s, BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());
            }

        }else{

            if(BoyRightSide){
                batch.draw( BoyIdleAnimation.getKeyFrame(time), BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());

            }else{
                Sprite s = new Sprite(BoyIdleAnimation.getKeyFrame(time));
                s.flip(true,false);
                //BoyRect.setX(BoyRect.getX() - BoyRect.getWidth());
                batch.draw(s, BoyRect.getX(), BoyRect.getY(), BoyRect.getWidth(), BoyRect.getHeight());
            }


        }
        batch.end();

        Controllers();
    }
    static void dispose(){

        for(int i=0;i<5;i++){
            for(int j=0;j<15;j++){
                BoyTextures[i][j].dispose();

            }
        }
        backgroundImage.dispose();
    }
    static void setRect(){
            BoyRect = new Rectangle(100, 50, 130, 180);
        }
    static void Controllers(){

        String Keys = GameController.KeysCondition();

        switch (Keys) {
            case "up_right_shift":
                shiftRightPressed = true;
                leftKeyPressed = false;
                upKeyPressed = true;
                rightKeyPressed = true;
                BoyRightSide = true;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, false, false, true, false);
                }

                break;
            case "up_left_shift":
                shiftRightPressed = true;
                leftKeyPressed = true;
                upKeyPressed = true;
                rightKeyPressed = false;
                BoyRightSide = false;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, false, false, true, false);
                }

                break;
            case "up_right":
                shiftRightPressed = false;
                leftKeyPressed = false;
                upKeyPressed = true;
                rightKeyPressed = true;
                BoyRightSide = true;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, false, false, true, false);
                }

                break;
            case "up_left":
                shiftRightPressed = true;
                leftKeyPressed = false;
                upKeyPressed = true;
                rightKeyPressed = true;
                BoyRightSide = false;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, false, false, true, false);
                }

                break;
            case "right_shift":
                shiftRightPressed = true;
                leftKeyPressed = false;
                upKeyPressed = false;
                rightKeyPressed = true;
                BoyRightSide = true;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, false, true, false, false);
                }

                break;
            case "left_shift":
                shiftRightPressed = true;
                leftKeyPressed = true;
                upKeyPressed = false;
                rightKeyPressed = false;
                BoyRightSide = false;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, false, true, false, false);
                }

                break;
            case "left":
                shiftRightPressed = false;
                leftKeyPressed = true;
                upKeyPressed = false;
                rightKeyPressed = false;
                BoyRightSide = false;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, true, false, false, false);
                }

                break;
            case "right":
                shiftRightPressed = false;
                leftKeyPressed = false;
                upKeyPressed = false;
                rightKeyPressed = true;
                BoyRightSide = true;
                MoveRect(BoyRect);
                if (!BoyJumping) {
                    BoyStatus(false, true, false, false, false);
                }

                break;
            case "up":
                shiftRightPressed = false;
                leftKeyPressed = false;
                upKeyPressed = true;
                rightKeyPressed = false;
                if (!BoyJumping) {
                    BoyStatus(false, false, false, true, false);
                }

                break;
            default:
                if (!BoyJumping) {
                    BoyStatus(false, false, false, false, false);
                }
                break;
        }

        if(Keys.equals("NO_INPUT")){
            if(!BoyJumping){BoyStatus(true,false,false,false,false);}
        }
    }
    private static void BoyStatus(boolean Standing,boolean Walking,boolean Running,boolean Jumping,boolean Dead){
        if(Jumping){
            BoyJumping=true;
            BoyStanding=false;
            BoyRunning=false;
            BoyWalking=false;
            BoyDead=false;
        }
        if(Walking){
            BoyWalking=true;
            BoyStanding=false;
            BoyRunning=false;
            BoyJumping=false;
            BoyDead=false;
        }
        if(Running){
            BoyWalking=false;
            BoyStanding=false;
            BoyRunning=true;
            BoyJumping=false;
            BoyDead=false;
        }
        if(Standing){
            BoyWalking=false;
            BoyStanding=true;
            BoyRunning=false;
            BoyJumping=false;
            BoyDead=false;
        }
        if(Dead){
            BoyWalking=false;
            BoyStanding=false;
            BoyRunning=false;
            BoyJumping=false;
            BoyDead=true;
        }

        }
    private static void JumpRect(Rectangle rect) {
        InitialVelocity-=0.4;
        if(InitialVelocity>0){
            rect.setY(rect.getY()+(InitialVelocity));
        }else if(rect.getY()>50){
            rect.setY(rect.getY()+InitialVelocity);
        }else{
            BoyStatus(true,false,false,false,false);
            InitialVelocity=10;
        }

    }
    private static void MoveRect(Rectangle rect){
        if(BoyRightSide){
            if(shiftRightPressed && rightKeyPressed){
                rect.setX(rect.getX()+2f);
            }else if(rightKeyPressed){
                rect.setX(rect.getX()+1.2f);
            }
        }else{
        if(shiftRightPressed && leftKeyPressed){
            rect.setX(rect.getX()-2f);
        }else if(leftKeyPressed) {
                rect.setX(rect.getX() - 1.2f);
            }
        }
    }
}
