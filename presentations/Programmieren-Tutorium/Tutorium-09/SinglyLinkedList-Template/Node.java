public class Node {
    // Usually you would use "Generics" at this point to be able
    // to hold arbitrary Objects, not only Bikes.
    private final Bike element;
    private Node next;

    /**
     * Constructor.
     *
     * @param element the element you want to add
     */
    public Node(Bike element) {
        this.element = element;
    }

    /**
     * Getter for the content of this node.
     *
     * @return the element
     */
    public Bike getElement() {
        return element;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Node[element=" + element + "]";
    }
}
