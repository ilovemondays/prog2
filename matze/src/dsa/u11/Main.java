package dsa.u11;

/**
 * Created by matze on 15.05.17.
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1, null);
        list.insert(2,1);
        list.insert(3, list.findByValue(2));

        list.iterate();
    }
}
