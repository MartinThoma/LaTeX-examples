public class SinglyLinkedList {

    Node head;

    private boolean isEqual(Node node, int content) {
        return node.container == content;
    }

    private Node findNode(int number) {
        Node currentNode = head;

        while (!isEqual(currentNode, number) && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        if (isEqual(currentNode, number)) {
            return currentNode;
        } else {
            return null;
        }
    }

    public void append(int number) {
        Node toInsert = new Node(number);
        toInsert.next = head;
        head = toInsert;

        /*
         * schlecht: Node currentNode = head;
         *
         * while (currentNode.next != null) { currentNode = currentNode.next; }
         * currentNode.next = n;
         */
    }

    public void remove(int number) {
        Node previous = head;
        Node currentNode = head;

        while (!isEqual(currentNode, number) && currentNode.next != null) {
            previous = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode.next != null) {
            previous.next = currentNode.next;
        }
    }

    public int find(int number) {
        Node node = findNode(number);

        if (node == null) {
            return 0;
        } else {
            return node.container;
        }
    }

    public void printList() {
        Node currentNode = head;
        System.out.print("head -> ");
        while (currentNode != null) {
            System.out.print(currentNode.container + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}

