public class SinglyLinkedList<E> {
    private Node<E> head;

    /**
     * Add an object to the list.
     *
     * @param object the element you want to add
     */
    public void add(E object) {
        Node<E> newNode = new Node<E>(object);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Check if object is in is in the SinglyLinkedList
     *
     * @param object the object you want to  search
     * @return the bike, if you found it, otherwise {@code null}
     */
    public boolean contains(E object) {
        Node<E> currentNode = head;

        while (currentNode != null && currentNode.getElement().equals(object)) {
            currentNode = currentNode.getNext();
        }

        return currentNode != null;
    }

    /**
     * Get a bike.
     *
     * @param bike the bike you want to get
     * @return
     */
    public E get(E bike) {
        if (contains(bike)) {
            Node<E> currentNode = head;
            while (currentNode.getElement() != bike) {
                currentNode = currentNode.getNext();
            }
            return bike;
        } else {
            return null;
        }
    }

    /**
     * Remove bike from the SinglyLinkedList, if it exists.
     *
     * @param bike the bike you want to search
     * @return {@code bike} if it is in SinglyLinkedList, otherwise {@code null}
     */
    public E remove(E bike) {
        if (!contains(bike)) {
            return null;
        } else if (head.getElement() == bike) {
            head = head.getNext();
            return bike;
        } else {
            // Knoten und Vorgängerknoten finden
            Node<E> previousNode = head;
            Node<E> currentNode = head;

            while (currentNode.getElement() != bike) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }

            // Zeiger umbiegen
            previousNode.setNext(currentNode.getNext());
            return bike;
        }
    }

    /**
     * Print all bikes in SinglyLinkedList.
     */
    public void printBikes() {
        Node<E> currentNode = head;
        System.out.print("start -> ");
        while (currentNode != null) {
            System.out.print(currentNode);
            System.out.print(" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }
}
