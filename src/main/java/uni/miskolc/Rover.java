package uni.miskolc;

public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private final int planetWidth;
    private final int planetHeight;


    public Rover(int x, int y, Direction direction, int planetWidth, int planetHeight) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planetWidth = planetWidth;
        this.planetHeight = planetHeight;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public Direction getDirection() {
        return this.direction;
    }

    public int getPlanetWidth() {
        return planetWidth;
    }

    public int getPlanetHeight() {
        return planetHeight;
    }

    public void setX(int x) {
        if (x == 10) {
            this.x = 0;
        }
        else if (x == -1) {
            this.x = 9;
        }
        else {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y == 10) {
            this.y = 0;
        }
        else if (y == -1) {
            this.y = 9;
        }
        else {
            this.y = y;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'r') {
                this.direction = this.direction.turnRight();
            }
            else if (command == 'l') {
                this.direction = this.direction.turnLeft();
            }
            else if (command == 'f') {
                moveForward();
            }
            else if (command == 'b') {
                moveBackward();
            }
        }
    }

    private void moveForward() {
        switch (this.direction) {
            case NORTH -> {
                setY(getY() + 1);
            }
            case EAST -> {
                setX(getX() + 1);
            }
            case SOUTH -> {
                setY(getY() - 1);
            }
            case WEST -> {
                setX(getX() - 1);
            }
            default -> {
                throw new IllegalStateException("Unexpected value: " + this.direction);
            }
        }
    }

    private void moveBackward() {
        switch (this.direction) {
            case NORTH -> {
                setY(getY() - 1);
            }
            case EAST -> {
                setX(getX() - 1);
            }
            case SOUTH -> {
                setY(getY() + 1);
            }
            case WEST -> {
                setX(getX() + 1);
            }
        }
    }
}
