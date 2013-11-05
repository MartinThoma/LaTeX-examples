public class BikeStorage {
    private Node head;

    /**
     * Add a bike to the BikeStorage.
     *
     * @param bike the bike you want to add
     */
    public void add(Bike bike) {
        Node newNode = new Node(bike);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Check if bike is in the BikeStorage
     *
     * @param bike the bike you want to search
     * @return the bike, if you found it, otherwise {@code null}
     */
    public boolean contains(Bike bike) {
        // Normalerweise würde man hier nach einer Seriennummer
        // oder ähnlichem - also "identifizierenden" Attributen
        // von Bike - suchen und dann das gesamte Bike zurückgeben
        Node currentNode = head;

        // usually you you should implement .equals(),
        // and not use != or == for objects
        while (currentNode != null && currentNode.getElement() != bike) {
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
    public Bike get(Bike bike) {
        if (contains(bike)) {
            Node currentNode = head;
            while (currentNode.getElement() != bike) {
                currentNode = currentNode.getNext();
            }
            return bike;
        } else {
            return null;
        }
    }

    /**
     * Remove bike from the BikeStorage, if it exists.
     *
     * @param bike the bike you want to search
     * @return {@code bike} if it is in BikeStorage, otherwise {@code null}
     */
    public Bike remove(Bike bike) {
        if (!contains(bike)) {
            return null;
        } else if (head.getElement() == bike) {
            head = head.getNext();
            return bike;
        } else {
            // Knoten und Vorgängerknoten finden
            Node previousNode = head;
            Node currentNode = head;

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
     * Print all bikes in BikeStorage.
     */
    public void printBikes() {
        Node currentNode = head;
        System.out.print("start -> ");
        while (currentNode != null) {
            System.out.print(currentNode);
            System.out.print(" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }
}
