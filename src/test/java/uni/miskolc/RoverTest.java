package uni.miskolc;

import javax.swing.text.Position;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    void roverInitializesWithCorrectPositionAndDirection(){

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.N;

        Rover rover = new Rover(startingPosition, startingDirection);

        assertEquals(startingPosition, rover.getPosition());
        assertEquals(startingDirection, rover.getDirection());
    }
}
