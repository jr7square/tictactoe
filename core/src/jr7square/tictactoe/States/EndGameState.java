package jr7square.tictactoe.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import jr7square.tictactoe.Tictactoe;

/**
 * Created by Junior on 7/4/2016.
 */
public class EndGameState extends State {

    private Image title;
    private Image YesBtn;
    private Image NoBtn;
    private Image background;
    private Stage stage;
    private boolean anotherGame;
    private boolean noMoreGames;


    public EndGameState(GameStateManager gsm, String winner){
        super(gsm);
        if(winner.equals("X")){
            title = new Image(new Texture("XplayerTitle.png"));
        }
        else if(winner.equals("O")){
            title = new Image(new Texture("OplayerTitle.png"));
        }
        else if(winner.equals("D")){
            title = new Image(new Texture("drawtitle.png"));
        }

        YesBtn = new Image(new Texture("YesButton.png"));
        NoBtn = new Image(new Texture("NoButton.png"));
        background = new Image(new Texture("background.png"));

        title.setPosition((Tictactoe.WIDTH /2) - (title.getWidth() / 2),(Tictactoe.HEIGHT /2 + 100) - (title.getHeight() / 2));
        YesBtn.setPosition((Tictactoe.WIDTH /2) - (YesBtn.getWidth() / 2 + 100),(Tictactoe.HEIGHT /2) - (YesBtn.getHeight() / 2));
        NoBtn.setPosition((Tictactoe.WIDTH /2 + 100) - (NoBtn.getWidth() / 2),(Tictactoe.HEIGHT /2) - (NoBtn.getHeight() / 2));

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(background);
        stage.addActor(title);
        stage.addActor(YesBtn);
        stage.addActor(NoBtn);

        anotherGame = false;
        noMoreGames = false;

        this.setListeners();
    }

    @Override
    protected void handleInput() {
        if(anotherGame){
            System.out.println("Another Game!");
            gsm.set(new PlayState(gsm));
            dispose();
        }
        else if(noMoreGames){
            System.out.println("No more Games!");
            System.exit(0);
        }


    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        sb.end();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void setListeners() {
        YesBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("Yes");
                anotherGame = true;
                return true;
            }
        });

        NoBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("No");
                noMoreGames = true;
                return true;
            }
        });

    }
}
