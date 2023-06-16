class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BSTToSkewedTree {
    Node node;

    // Function to perform inorder traversal on the BST
    // and modify it into a skewed tree
    public void convertToSkewedTree(Node root) {
        // Base case
        if (root == null)
            return;

        // Convert the left subtree into a skewed tree
        convertToSkewedTree(root.left);

        // Perform right rotation
        Node rightNode = root.right;
        root.right = rightNode != null ? rightNode.left : null;
        root.left = null;

        // Move the root to the right subtree
        node = root;

        // Convert the right subtree into a skewed tree
        convertToSkewedTree(rightNode);
    }

    // Function to traverse the skewed tree and display
    // the node values in ascending order
    public void traverseSkewedTree() {
        Node currNode = node;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.right;
        }
    }

    public static void main(String[] args) {
        // Create the BST
        BSTToSkewedTree tree = new BSTToSkewedTree();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        // Convert the BST into a skewed tree
        tree.convertToSkewedTree(tree.node);

        // Traverse and display the skewed tree in ascending order
        System.out.println("Node values in ascending order:");
        tree.traverseSkewedTree();
    }
}
