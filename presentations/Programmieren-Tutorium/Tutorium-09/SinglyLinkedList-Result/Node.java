public class Node<E> {
    private final E element;
    private Node<E> next;

    /**
     * Constructor.
     *
     * @param element the element you want to add
     */
    public Node(E element) {
        this.element = element;
    }

    /**
     * Getter for the content of this node.
     *
     * @return the element
     */
    public E getElement() {
        return element;
    }

    /**
     * @return the next
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<E> next) {
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
