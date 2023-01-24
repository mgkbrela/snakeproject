package am9_group2.snakeproject;

import java.awt.Color;
import java.awt.Point;

public class YellowSnakeMenu extends Snake {

    public YellowSnakeMenu(int pontos) {
        super(pontos);
        setColor(Color.YELLOW);
        snakeColor[0] = false;
        snakeColor[1] = false;
        snakeColor[2] = true;
    }

    @Override
    public boolean checkCollision(Barriers barrier) {

        boolean collide = false;

        for (int z = getBodySize() - 1; z > 0; --z) {
            if ((getBodyPos()[0].x == getBodyPos()[z].x) && (getBodyPos()[0].y == getBodyPos()[z].y)) {
                collide = true;
            }
        }

        if (getBodyPos()[0].y >= 290) {
            collide = true;
        }

        if (getBodyPos()[0].y < 0) {
            collide = true;
        }

        if (getBodyPos()[0].x >= 370) {
            collide = true;
        }

        if (getBodyPos()[0].x < 0) {
            collide = true;
        }

        return collide;
    }

}

