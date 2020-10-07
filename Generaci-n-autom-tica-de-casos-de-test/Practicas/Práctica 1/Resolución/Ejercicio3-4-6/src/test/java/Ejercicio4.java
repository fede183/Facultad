import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio4 {
    @Test
    public void max(){
        MaxBetweenInt max = new MaxBetweenInt();
        assertEquals(max.max(1, 2), 2);
    }
}