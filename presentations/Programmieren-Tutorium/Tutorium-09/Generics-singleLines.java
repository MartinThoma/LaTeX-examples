public class SinglyLinkedList<E> {
    private Node<E> head;

    public void add(E object) {
        Node<E> newNode = new Node<E>(object);
        newNode.setNext(head);
        head = newNode;
    }
}
