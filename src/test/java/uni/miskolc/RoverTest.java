package uni.miskolc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    //private final int PLANET_WIDTH = 10;
    //private final int PLANET_HEIGHT = 10;
    private Planet defaultPlanet;

    @BeforeEach
    void setUp() {
        this.defaultPlanet = new Planet(10, 10);
    }

    @Test
    void testRoverInitialState() {

        Rover rover = new Rover(0, 0, Direction.NORTH,  defaultPlanet);

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());

        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testRoverCanTurnRightFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH, defaultPlanet);
        rover.execute("r"); // "r" = right
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testRoverCanTurnRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.EAST, defaultPlanet);
        rover.execute("r");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    void testRoverCanTurnLeftFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH,  defaultPlanet);
        rover.execute("l"); // "l" = left
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testRoverCanTurnLeftFromEast() {
        Rover rover = new Rover(0, 0, Direction.WEST,   defaultPlanet);
        rover.execute("l");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    void testRoverHandlesMultipleTurnCommands() {
        Rover rover = new Rover(0, 0, Direction.NORTH,  defaultPlanet);
        rover.execute("rrl"); // N -> E -> S -> E
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testRoverMovesForwardNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH, defaultPlanet);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }

    @Test
    void testRoverMovesForwardEast() {
        Rover rover = new Rover(0, 0, Direction.EAST, defaultPlanet);
        rover.execute("f");
        assertEquals(1, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    void testRoverMovesBackwardNorth() {
        Rover rover = new Rover(5, 5, Direction.NORTH, defaultPlanet);
        rover.execute("b");
        assertEquals(5, rover.getX());
        assertEquals(4, rover.getY());
    }

    @Test
    void testRoverMovesBackwardSouth() {
        Rover rover = new Rover(5, 5, Direction.SOUTH, defaultPlanet);
        rover.execute("b");
        assertEquals(5, rover.getX());
        assertEquals(6, rover.getY());
    }

    @Test
    void testRoverTurnsLeftMovesForward() {
        Rover rover = new Rover(4, 4, Direction.NORTH, defaultPlanet);
        rover.execute("lf"); //
        assertEquals(3, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testRoverWrapsAroundNorthEdge() {
        // A bolygó tetején van (y=9) és Északra megy
        Rover rover = new Rover(0, 9, Direction.NORTH, defaultPlanet);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY()); // Visszateker y=0-ra
    }

    @Test
    void testRoverWrapsAroundSouthEdge() {
        // A bolygó alján van (y=0) és Délre megy
        Rover rover = new Rover(0, 0, Direction.SOUTH, defaultPlanet);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(9, rover.getY()); // Visszateker y=9-re (10-1)
    }

    @Test
    void testRoverWrapsAroundEastEdge() {
        // A bolygó jobb szélén van (x=9) és Keletre megy
        Rover rover = new Rover(9, 0, Direction.EAST, defaultPlanet);
        rover.execute("f");
        assertEquals(0, rover.getX()); // Visszateker x=0-ra
        assertEquals(0, rover.getY());
    }

    @Test
    void testRoverInitializesWithPositionAndDirection() {
        Rover rover = new Rover(0, 0, Direction.NORTH, defaultPlanet);
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testRoverStopsAtObstacle() {
        int[] obstacle = new int[]{0, 2};

        Planet planetWithObstacle = new Planet(10, 10, List.of(obstacle));

        Rover rover = new Rover(0, 1, Direction.NORTH, planetWithObstacle);
        String status = rover.execute("f");

        assertEquals("OBSTACLE:0,2", status);
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }

    @Test
    void testRoverStopsAtObstacleDuringSequence() {
        // Point obstacle = new Point(0, 2); helyett:
        int[] obstacle = new int[]{0, 2};
        Planet planetWithObstacle = new Planet(10, 10, List.of(obstacle));

        Rover rover = new Rover(0, 0, Direction.NORTH, planetWithObstacle);
        String status = rover.execute("ffr");

        assertEquals("OBSTACLE:0,2", status);
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testRoverStopsAtObstacleWhenWrapping() {
        // Point obstacle = new Point(0, 0); helyett:
        int[] obstacle = new int[]{0, 0};
        Planet planetWithObstacle = new Planet(10, 10, List.of(obstacle));

        Rover rover = new Rover(0, 9, Direction.NORTH, planetWithObstacle);
        String status = rover.execute("f");

        assertEquals("OBSTACLE:0,0", status);
        assertEquals(0, rover.getX());
        assertEquals(9, rover.getY());
    }

}
