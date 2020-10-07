import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio6 {
    @Test
    public void diferentEdgeAndBrantch(){
        DiferentEdgeAndBranch dif = new DiferentEdgeAndBranch();
        assertEquals(dif.valuate(2), 2);
    }
}