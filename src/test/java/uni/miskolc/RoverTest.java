package uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

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

}
