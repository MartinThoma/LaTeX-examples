public class Node {
    public Bike element;
    public Node next;

    public Node(Bike element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Node[element=" + element + "]";
    }
}
