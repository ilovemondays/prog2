package dsa.u11;

/**
 * Created by Team 13 on 15.05.17.
 */
public class Node {
    private Node next;
    private Object value;

    public Node() {
        value = -1;
    }
    public Node(Node next, Object value) {

    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "["+getValue()+"] -> ";
    }
}
