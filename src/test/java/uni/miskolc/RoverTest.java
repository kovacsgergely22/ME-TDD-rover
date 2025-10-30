package uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    void testRoverInitialState() {
        // Most már 'Direction' enumot használunk a 'char' helyett
        Rover rover = new Rover(0, 0, Direction.NORTH);

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        // Az ellenőrzés is az enumra történik
        assertEquals(Direction.NORTH, rover.getDirection());
    }
}
