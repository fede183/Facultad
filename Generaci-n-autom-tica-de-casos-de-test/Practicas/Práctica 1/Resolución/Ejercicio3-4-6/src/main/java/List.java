public class List {
    Node header;

    public boolean containsElem(int elem) {
        Node curr = this.header;
        while (curr!=null) {
            if (curr.value==elem) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
