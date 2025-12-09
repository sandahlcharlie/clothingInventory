/**
 * A node in a Binary Search Tree with a MenuItem as data
 * Each node stores left and right child nodes
 * @author Charles Sandahl
 * @version 0.1
 */
public class BSTNode {
    private MenuItem data;
    private BSTNode left;
    private BSTNode right;

    /**
     * Constructs node with MenuItem as data and left and right child nodes
     * @param m is the MenuItem to store
     * @param l this is left child node
     * @param r this is right child node
     */
    public BSTNode( MenuItem m, BSTNode l, BSTNode r ){
        this.data = m;
        this.left = l;
        this.right = r;
    }
    /**
     * Gets the MenuItem stored in this node
     * @return the MenuItem data
     */
    public MenuItem getData() {
        return data;
    }

    /**
     * Sets the MenuItem data for this node
     * @param data the MenuItem to store
     */
    public void setData(MenuItem data) {
        this.data = data;
    }

    /**
     * Gets the left child node
     * @return the left child BSTNode
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Sets the left child node
     * @param left the left child to set
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /**
     * Gets the right child node
     * @return the right child BSTNode
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * Sets the right child node
     * @param right the right child to set
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }
}
