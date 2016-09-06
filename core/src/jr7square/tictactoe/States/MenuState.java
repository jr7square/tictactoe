package jr7square.tictactoe.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import jr7square.tictactoe.Tictactoe;

/**
 * Created by Junior on 5/10/2016.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        //setting the camera location and area to focus
        cam.setToOrtho(false, Tictactoe.WIDTH, Tictactoe.HEIGHT);

        background = new Texture("background.png");
        playBtn = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        //drawing with respect to the camera location
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, 0, 0);

        //drawing button at the center of the screen
        sb.draw(playBtn, cam.position.x - (playBtn.getWidth() / 2), cam.position.y - (playBtn.getHeight() / 2));
        sb.end();

    }

    //remember to cleanup
    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
