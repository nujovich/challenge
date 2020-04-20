package challenge;

public class MyLinkedList {
    private Node root;
    private int size;
    private int max;



    public void insert(final int data) {
        final Node node = new Node(data, null);
        if (this.root == null) {
            this.root = node;
        } else {
            Node n = this.root;
            while (n.getNextNode() != null) {
                n = n.getNextNode();
            }
            n.setNextNode(node);
        }
        this.size++;
    }

    public int removeAtRoot() {
        final int data = this.root.getData();
        final Node newRoot = this.root.getNextNode();
        this.root = newRoot;
        this.size--;
        return data;

    }

    public void show() {
        Node node = this.root;
        while (node != null && node.getNextNode() != null) {
            System.out.println(node.getData());
            node = node.getNextNode();
        }
        if (node == null) {
            System.out.println("You have reached the end of the queue.");
        } else {
            System.out.println(node.getData());
        }

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(final Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public int getMax() {
        this.max = 0;
        Node node = this.root;
        while (node.getNextNode() != null) {
            if (node.getData() > this.max) {
                this.max = node.getData();
            }
            node = node.getNextNode();
        }
        if (node.getData() > this.max) {
            this.max = node.getData();
        }
        return this.max;
    }

    public void setMax(final int max) {
        this.max = max;
    }
}