package jr7square.tictactoe.States;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import jr7square.tictactoe.components.Grid;

/**
 * Created by Junior on 5/10/2016.
 */
public class PlayState extends State {

    private Grid grid;
    public PlayState(GameStateManager gsm){
        super(gsm);
        grid = new Grid();


    }
    @Override
    protected void handleInput() {
        if(grid.Xwin()){
            gsm.set(new EndGameState(gsm, "X"));
            dispose();
        }
        else if(grid.Owin()){
            gsm.set(new EndGameState(gsm, "O"));
            dispose();
        }
        else if(grid.draw()){
            gsm.set(new EndGameState(gsm,"D"));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        grid.drawGrid();
        sb.end();
    }

    @Override
    public void dispose() {
        grid.dispose();
    }
}
