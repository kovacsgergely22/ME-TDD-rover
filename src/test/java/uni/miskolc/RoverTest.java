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
    void testRoverTurnsRight() {
        // Létrehozunk egy rovert, ami északra néz
        Rover rover = new Rover(0, 0, Direction.NORTH);

        // Kiadjuk a parancsot
        rover.receiveCommand("r"); // 'r' a 'right' (jobbra)

        // Elvárás: A rover most 'E' (East) felé néz
        assertEquals('E', rover.getDirection());

        // Teszteljük körbe
        rover.receiveCommand("r");
        assertEquals('S', rover.getDirection()); // Dél

        rover.receiveCommand("r");
        assertEquals('W', rover.getDirection()); // Nyugat

        rover.receiveCommand("r");
        assertEquals('N', rover.getDirection()); // Vissza Északra
    }
}
