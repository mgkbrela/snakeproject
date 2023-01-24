package am9_group2.snakeproject;

import java.awt.Color;

public class RedSnakeMenu extends Snake {

	public RedSnakeMenu(int pts) {
            super(pts);
            setColor(Color.RED);
            snakeColor[0] = false;
            snakeColor[1] = true;
            snakeColor[2] = false;
	}

}
