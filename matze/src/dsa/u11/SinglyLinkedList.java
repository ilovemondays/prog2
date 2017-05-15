package dsa.u11;

/**
 * Created by matze on 15.05.17.
 */
public class SinglyLinkedList {
    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        head = new Node();
        tail = new Node(head, null);
        head.setNext(tail);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     *
     * @param value
     * @return
     */
    public Node findByValue(Object value) {
        Node act = head;
        while (act != tail) {
            if(act.getValue() == value) {
                break;
            }
            act = act.getNext();
        }
        if(act == tail) {
            return null;
        }
        return act;
    }

    /**
     *
     * @param x
     * @param p
     */
    public void insert(Object x, Object p) {
        Node position = findByValue(p);
        if(position == null) return;
        insert(x, position);
    }
    public void insert(Object x, Node position) {
        Node newNode = new Node(position.getNext(), x);
        position.setNext(newNode);

        if(newNode.getNext() == tail) {
            tail.setNext(newNode);
        }
    }

    public void insertBefore(Object x, Object p) {
        Node position = findByValue(p);
        if(position == null) return;
        insertBefore(x, position);
    }
    public void insertBefore(Object x, Node position) {
        if(position == tail) {
            Node newNode = new Node(tail,x);
            tail.getNext().setNext(newNode);
            tail.setNext(newNode);
        } else {
            Node clone = new Node(position.getNext(), position.getValue());
            position.setNext(clone);
            position.setValue(x);
        }
    }

    public void delete(Object x) {
        Node position = findByValue(x);
        if(position == null) return;
        delete(position);
    }
    public void delete(Node position) {
        Node act = head;
        while(act.getNext() != position) {
            act = act.getNext();
        }
        act.setNext(position.getNext());
        if(position.getNext() == tail) {
            tail.setNext(act);
        }
    }

    public SinglyLinkedList concat(SinglyLinkedList l1, SinglyLinkedList l2) {
        SinglyLinkedList newList = new SinglyLinkedList();
        l1.getTail().getNext().setNext(l2.getHead().getNext());
        newList.setHead(new Node(l1.getHead().getNext(), null));
        newList.setTail(new Node(l2.getTail().getNext(), null));
        return newList;
    }

    @Override
    public String toString() {
        return "Start: "+head.toString();
    }

    public void iterate() {
        Node act = head;
        while (act != tail) {
            System.out.println(act.toString());
        }
    }
}
