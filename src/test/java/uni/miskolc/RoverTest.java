package uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    private final int PLANET_WIDTH = 10;
    private final int PLANET_HEIGHT = 10;

    @Test
    void testRoverInitialState() {

        Rover rover = new Rover(0, 0, Direction.NORTH);

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());

        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testRoverCanTurnRightFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH);
        rover.execute("r"); // "r" = right
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testRoverCanTurnRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.EAST);
        rover.execute("r");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    void testRoverCanTurnLeftFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH);
        rover.execute("l"); // "l" = left
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testRoverCanTurnLeftFromEast() {
        Rover rover = new Rover(0, 0, Direction.WEST);
        rover.execute("l");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    void testRoverHandlesMultipleTurnCommands() {
        Rover rover = new Rover(0, 0, Direction.NORTH);
        rover.execute("rrl"); // N -> E -> S -> E
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testRoverMovesForwardNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH, PLANET_WIDTH, PLANET_HEIGHT);
        rover.execute("f");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY()); // Y nő
    }

    @Test
    void testRoverMovesForwardEast() {
        Rover rover = new Rover(0, 0, Direction.EAST, PLANET_WIDTH, PLANET_HEIGHT);
        rover.execute("f");
        assertEquals(1, rover.getX()); // X nő
        assertEquals(0, rover.getY());
    }

}
