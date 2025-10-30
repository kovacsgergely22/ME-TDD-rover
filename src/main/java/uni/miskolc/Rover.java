package uni.miskolc;

public class Rover {
    private int x;
    private int y;
    private Direction direction;

    public Rover() {}

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
                switch (this.direction) {
                    case NORTH:
                        this.direction = Direction.EAST;
                        break;
                    case EAST:
                        this.direction = Direction.SOUTH;
                        break;
                    case SOUTH:
                        this.direction = Direction.WEST;
                        break;
                    case WEST:
                        this.direction = Direction.NORTH;
                        break;
                }
            }
        }
    }
}
