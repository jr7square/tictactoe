package jr7square.tictactoe.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import jr7square.tictactoe.Tictactoe;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Tictactoe.WIDTH;
		config.height = Tictactoe.HEIGHT;
		config.title = Tictactoe.TITLE;
		new LwjglApplication(new Tictactoe(), config);
	}
}
