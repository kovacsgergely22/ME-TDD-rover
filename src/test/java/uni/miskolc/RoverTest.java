package uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    //private final int PLANET_WIDTH = 10;
    //private final int PLANET_HEIGHT = 10;
    private final Planet planet = new Planet(10, 10);

    @Test
    void testRoverInitialState() {

        Rover rover = new Rover(0, 0, Direction.NORTH,  planet);

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());

        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testRoverCanTurnRightFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH, planet);
        rover.execute("r"); // "r" = right
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testRoverCanTurnRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.EAST, planet);
        rover.execute("r");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    void testRoverCanTurnLeftFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH,  planet);
        rover.execute("l"); // "l" = left
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testRoverCanTurnLeftFromEast() {
        Rover rover = new Rover(0, 0, Direction.WEST,   planet);
        rover.execute("l");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    void testRoverHandlesMultipleTurnCommands() {
        Rover rover = new Rover(0, 0, Direction.NORTH,  planet);
        rover.execute("rrl"); // N -> E -> S -> E
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testRoverMovesForwardNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH, planet);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }

    @Test
    void testRoverMovesForwardEast() {
        Rover rover = new Rover(0, 0, Direction.EAST, planet);
        rover.execute("f");
        assertEquals(1, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    void testRoverMovesBackwardNorth() {
        Rover rover = new Rover(5, 5, Direction.NORTH, planet);
        rover.execute("b");
        assertEquals(5, rover.getX());
        assertEquals(4, rover.getY());
    }

    @Test
    void testRoverMovesBackwardSouth() {
        Rover rover = new Rover(5, 5, Direction.SOUTH, planet);
        rover.execute("b");
        assertEquals(5, rover.getX());
        assertEquals(6, rover.getY());
    }

    @Test
    void testRoverTurnsLeftMovesForward() {
        Rover rover = new Rover(4, 4, Direction.NORTH, planet);
        rover.execute("lf"); //
        assertEquals(3, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testRoverWrapsAroundNorthEdge() {
        // A bolygó tetején van (y=9) és Északra megy
        Rover rover = new Rover(0, 9, Direction.NORTH, planet);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY()); // Visszateker y=0-ra
    }

    @Test
    void testRoverWrapsAroundSouthEdge() {
        // A bolygó alján van (y=0) és Délre megy
        Rover rover = new Rover(0, 0, Direction.SOUTH, planet);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(9, rover.getY()); // Visszateker y=9-re (10-1)
    }

    @Test
    void testRoverWrapsAroundEastEdge() {
        // A bolygó jobb szélén van (x=9) és Keletre megy
        Rover rover = new Rover(9, 0, Direction.EAST, planet);
        rover.execute("f");
        assertEquals(0, rover.getX()); // Visszateker x=0-ra
        assertEquals(0, rover.getY());
    }

}
