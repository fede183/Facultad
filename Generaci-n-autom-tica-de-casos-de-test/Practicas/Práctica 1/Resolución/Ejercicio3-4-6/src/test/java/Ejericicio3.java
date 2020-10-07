import static org.junit.jupiter.api.Assertions.*;

class Ejericicio3 {

    @org.junit.jupiter.api.Test
    void containsElem_SecondElement() {
        Node first = new Node();
        Node second = new Node();
        first.value = 1;
        second.value = 2;
        first.next = second;
        List list = new List();
        list.header = first;
        assertTrue(list.containsElem(second.value));
    }

    @org.junit.jupiter.api.Test
    void containsElem_NotElement() {
        List list = new List();
        assertFalse(list.containsElem(1));
    }
}