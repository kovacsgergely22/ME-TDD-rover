package uni.miskolc;

public class Rover {
    private int x;
    private int y;
    private Direction direction;
    //private final int planetWidth;
    //private final int planetHeight;
    private final Planet planet;


    public Rover(int x, int y, Direction direction, Planet planet) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = planet;
    }

    // A getterek a primitív mezőket adják vissza
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public Direction getDirection() {
        return this.direction;
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {

            if (command == 'r') {
                this.direction = this.direction.turnRight();
            } else if (command == 'l') {
                this.direction = this.direction.turnLeft();
            } else if (command == 'f') {
                String status = move(true); // true = forward
                if (!status.equals("OK")) {
                    return status;
                }
            } else if (command == 'b') {
                String status = move(false); // false = backward
                if (!status.equals("OK")) {
                    return status;
                }
            }
        }

        // A jelentés is a belső x, y mezőkből dolgozik
        return commands;
    }

    private String move(boolean isForward) {
        int dx = 0;
        int dy = 0;

        Direction moveDir = isForward ? this.direction : this.direction.turnLeft().turnLeft();

        switch (moveDir) {
            case NORTH -> dy = 1;
            case EAST -> dx = 1;
            case SOUTH -> dy = -1;
            case WEST -> dx = -1;
        }

        // 2. Számoljuk ki a *következő* potenciális pozíciót
        int nextPotentialX = this.x + dx;
        int nextPotentialY = this.y + dy;

        // 3. Kérjük meg a bolygót, hogy "tekerje körbe"
        // Visszakapunk egy int[2] tömböt
        int[] wrappedCoords = this.planet.wrap(nextPotentialX, nextPotentialY);
        int wrappedX = wrappedCoords[0];
        int wrappedY = wrappedCoords[1];

        // 4. ELLENŐRZÉS: int x, int y átadásával
        if (this.planet.hasObstacleAt(wrappedX, wrappedY)) {
            // Akadály van! Nem mozgunk, és jelentjük.
            return String.format("OBSTACLE:%d,%d", wrappedX, wrappedY);
        } else {
            // Nincs akadály. Végrehajtjuk a mozgást.
            // Frissítjük a belső állapotot
            this.x = wrappedX;
            this.y = wrappedY;
            return "OK";
        }
    }
}
