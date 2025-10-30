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

    @Test
    void testRoverTurnsRightFromNorth() {
        Rover rover = new Rover(0, 0, Direction.NORTH);
        rover.receiveCommand('r');
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    /**
     * Teszt: Keletről (E) jobbra fordulva Délre (S) kell nézzen.
     */
    @Test
    void testRoverTurnsRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.EAST);
        rover.receiveCommand('r');
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    /**
     * Teszt: Délről (S) jobbra fordulva Nyugatra (W) kell nézzen.
     */
    @Test
    void testRoverTurnsRightFromSouth() {
        Rover rover = new Rover(0, 0, Direction.SOUTH);
        rover.receiveCommand('r');
        assertEquals(Direction.WEST, rover.getDirection());
    }

    /**
     * Teszt: Nyugatról (W) jobbra fordulva Északra (N) kell nézzen.
     */
    @Test
    void testRoverTurnsRightFromWest() {
        Rover rover = new Rover(0, 0, Direction.WEST);
        rover.receiveCommand('r');
        assertEquals(Direction.NORTH, rover.getDirection());
    }
}
