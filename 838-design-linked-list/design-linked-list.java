class MyLinkedList {

    // Node of the linked list
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size;

    // Constructor
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at index
    public int get(int index) {

        // Invalid index
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head;

        // Move to index
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    // Add at beginning
    public void addAtHead(int val) {

        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;

        size++;
    }

    // Add at end
    public void addAtTail(int val) {

        Node newNode = new Node(val);

        // Empty list
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node curr = head;

        // Reach last node
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;

        size++;
    }

    // Add before index
    public void addAtIndex(int index, int val) {

        // If index is invalid
        if (index < 0 || index > size) {
            return;
        }

        // Insert at beginning
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // Insert at end
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);

        Node curr = head;

        // Reach node BEFORE index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        // curr = node before insertion position
        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    // Delete node at index
    public void deleteAtIndex(int index) {

        // Invalid index
        if (index < 0 || index >= size) {
            return;
        }

        // Delete head
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;

        // Reach node BEFORE index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        // Skip the node being deleted
        curr.next = curr.next.next;

        size--;
    }
}