package am9_group2.snakeproject;

import java.awt.Color;
import java.awt.Point;

public class Snake {

    private int bodySize;
    private final Point[] bodyPos;
    private final int scale = 10;
    private int speed;
    private Color color;
    int score;
    protected boolean dead;
    protected boolean[] snakeColor = new boolean[3];

    protected boolean upDirection = false;
    protected boolean downDirection = false;
    protected boolean rightDirection = true;
    protected boolean leftDirection = false;

    public Snake(int pts) {
        bodySize = 5;
        bodyPos = new Point[pts];
        bodyPos[0] = (new Point(130, 100));
        bodyPos[1] = (new Point(120, 100));
        bodyPos[2] = (new Point(110, 100));
        bodyPos[3] = (new Point(100, 100));
        bodyPos[4] = (new Point(90, 100));
        speed = 5;
        color = (Color.BLUE);
        score = 0;
        dead = false;

        snakeColor[0] = true;
        snakeColor[1] = false;
        snakeColor[2] = false;
    }

    protected void move() {

        for (int z = this.bodySize - 1; z > 0; z--) {
            this.bodyPos[z].x = this.bodyPos[z - 1].x;
            this.bodyPos[z].y = this.bodyPos[z - 1].y;
        }

        if (leftDirection) {
            bodyPos[0].x -= scale;
        }

        if (rightDirection) {
            bodyPos[0].x += scale;
        }

        if (upDirection) {
            bodyPos[0].y -= scale;
        }

        if (downDirection) {
            bodyPos[0].y += scale;
        }
    }

    protected boolean checkCollision(Barriers barrier) {

        boolean collide = false;

        for (int z = getBodySize() - 1; z > 0; --z) {
            if (getBodyPos()[0].equals(getBodyPos()[z])) {
                collide = true;
            }
        }
        
        for (Point p : barrier.pos) {
            if (getBodyPos()[0].equals(p)) {
                collide = true;
            }
        }

        if (getBodyPos()[0].y >= 290) {
            getBodyPos()[0].y = 0;
        }

        if (getBodyPos()[0].y < 0) {
            getBodyPos()[0].y = 290 - scale;
        }

        if (getBodyPos()[0].x >= 370) {
            getBodyPos()[0].x = 0;
        }

        if (getBodyPos()[0].x < 0) {
            getBodyPos()[0].x = 370 - scale;
        }

        return collide;
    }

    protected boolean addPart() {

        Point posLast = getBodyPos()[getBodySize() - 1];
        Point posPen = getBodyPos()[getBodySize() - 2];
        Point posNew = new Point();

        if (posLast.x == posPen.x) {
            posNew.x = posLast.x;
            if (posLast.y > posPen.y) {
                posNew.y = posLast.y + scale;
            } else {
                posNew.y = posLast.y - scale;
            }

        } else if (posLast.x > posPen.x) {
            posNew.x = posLast.x + scale;
            posNew.y = posLast.y;

        } else {
            posNew.x = posLast.x - scale;
            posNew.y = posLast.y;
        }

        setBodySize(getBodySize() + 1);
        getBodyPos()[getBodySize() - 1] = new Point(posNew.x, posNew.y);

        return false;
    }

    public int getBodySize() {
        return bodySize;
    }

    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }

    public Point[] getBodyPos() {
        return bodyPos;
    }

    public int getScale() {
        return scale;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}