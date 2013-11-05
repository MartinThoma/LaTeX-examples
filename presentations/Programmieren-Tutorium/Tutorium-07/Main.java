public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.printList();

        // append new elements at the front of the list
        list.append(12);
        list.printList();
        list.append(13);
        list.printList();
        list.append(14);
        list.printList();
        list.append(15);
        list.printList();

        // remove elements
        list.remove(13);
        list.printList();

        // find elements
        int numberA = list.find(14);
        int numberB = list.find(13);
        System.out.println(numberA + " " + numberB);
    }
}

