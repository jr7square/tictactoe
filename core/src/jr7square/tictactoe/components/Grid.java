package jr7square.tictactoe.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Junior on 5/12/2016.
 */
public class Grid {
    private Table table;
    private int playerTurn;
    private final int SIZE_GRID = 9;
    private Image Iboard;
    private Image[] images;
    private int[] played;
    private Stage stage;

    public Grid() {
        playerTurn = 1;
        table = new Table();
        images = new Image[SIZE_GRID];
        played = new int[SIZE_GRID];
        Iboard = new Image(new Texture("tictactoeboard.png"));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        //don't forget to add the event listener to each image
        //and add the table to the stage
        for(int i = 0; i < SIZE_GRID; i++){
            images[i] = new Image(new Texture("transparent.png"));
            table.add(images[i]).width(120).height(120).pad(15);
            if((i+1) % 3 == 0){
                table.row();
            }
        }
        Iboard.setWidth(480);
        Iboard.setHeight(480);
        Iboard.setPosition(0, 164);
        table.setFillParent(true);
        //table.setDebug(true);
        stage.addActor(Iboard);
        stage.addActor(table);

        this.setListeners();

    }

    //This method needs some work, If only the for loop worked mmm...
    private void setListeners(){
        /* i goes out of scope in ClickListener event,
           figured this out later
        for(i = 0; i < SIZE_GRID -1; i++) {
            images[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    images[i].setVisible(false);
                    System.out.println("Clicked");
                }
            });
        }
        */


        //8 adding Listeners to each square in grid, there's got to be another way tho
        images[0].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if(playerTurn % 2 == 0){
                    images[0].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[0] = 2;
                }
                else{
                    images[0].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[0] = 1;
                }
                playerTurn++;

                System.out.println("Clicked");
            }
        });

        images[1].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if(playerTurn % 2 == 0){
                    images[1].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[1] = 2;
                }
                else{
                    images[1].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[1] = 1;
                }
                playerTurn++;
            }
        });

        images[2].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[2].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[2] = 2;
                } else {
                    images[2].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[2] = 1;
                }
                playerTurn++;
            }
        });

        images[3].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[3].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[3] = 2;
                } else {
                    images[3].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[3] = 1;
                }
                playerTurn++;
            }
        });

        images[4].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[4].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[4] = 2;
                } else {
                    images[4].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[4] = 1;
                }
                playerTurn++;
            }
        });

        images[5].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[5].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[5] = 2;
                } else {
                    images[5].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[5] = 1;
                }
                playerTurn++;
            }
        });

        images[6].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[6].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[6] = 2;
                } else {
                    images[6].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[6] = 1;
                }
                playerTurn++;
            }
        });

        images[7].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[7].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[7] = 2;
                } else {
                    images[7].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[7] = 1;
                }
                playerTurn++;
            }
        });

        images[8].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerTurn % 2 == 0) {
                    images[8].setDrawable(new SpriteDrawable(new Sprite(new Texture("O.png"))));
                    played[8] = 2;
                } else {
                    images[8].setDrawable(new SpriteDrawable(new Sprite(new Texture("X.png"))));
                    played[8] = 1;
                }
                playerTurn++;
            }
        });



    }

    public void drawGrid(){
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public boolean Xwin() {
        if(playerTurn <= SIZE_GRID){
            if((played[0] == 1 && played[1] == 1 && played[2] == 1) ||
                    (played[3] == 1 && played[4] == 1 && played[5] == 1) ||
                    (played[6] == 1 && played[7] == 1 && played[8] == 1) ||
                    (played[0] == 1 && played[3] == 1 && played[6] == 1) ||
                    (played[1] == 1 && played[4] == 1 && played[7] == 1) ||
                    (played[2] == 1 && played[5] == 1 && played[8] == 1) ||
                    (played[0] == 1 && played[4] == 1 && played[8] == 1) ||
                    (played[2] == 1 && played[4] == 1 && played[6] == 1)){
                //Player X wins
                return true;
            }
        }
        return false;
    }


    public boolean Owin() {
        if(playerTurn <= SIZE_GRID){
            if((played[0] == 2 && played[1] == 2 && played[2] == 2) ||
                    (played[3] == 2 && played[4] == 2 && played[5] == 2) ||
                    (played[6] == 2 && played[7] == 2 && played[8] == 2) ||
                    (played[0] == 2 && played[3] == 2 && played[6] == 2) ||
                    (played[1] == 2 && played[4] == 2 && played[7] == 2) ||
                    (played[2] == 2 && played[5] == 2 && played[8] == 2) ||
                    (played[0] == 2 && played[4] == 2 && played[8] == 2) ||
                    (played[2] == 2 && played[4] == 2 && played[6] == 2)){
                //Player O wins
                return true;
            }
        }
        return false;
    }

    public boolean draw(){
        if((playerTurn > SIZE_GRID) && !Owin() && !Xwin()){
            return true;
        }
        return false;
    }

    public void dispose(){
        table.reset();
        stage.dispose();
    }

}
