/**
 * Represents a restaurant order stored as a Binary Search Tree of MenuItems
 * Can set the name of the restaurant
 * Each order is associated with a specific table
 * @author Charles Sandahl
 * @version 0.1
 */
public class Order {
    private BSTNode root;
    private String tableID;
    private static String restaurantName;
    /**
     * Gets the tableID for this order
     * @return the tableID as a String
     */
    public String getTableID() {return tableID;}
    /**
     * Sets the tableID for this order
     * @param tableID to set
     */
    public void setTableID(String tableID) {this.tableID = tableID;}
    /**
     * Gets the for this order
     * @return the root BSTNode
     */
    public BSTNode getRoot() {return root;}
    /**
     * Sets the root BSTNode for this order
     * @param root the root node to set
     */
    public void setRoot(BSTNode root) {this.root = root;}
    /**
     * Sets the restaurantName globally
     * @param name is the name to set
     */
    public static void setRestaurantName(String name) {restaurantName = name;}

    /**
     * Constructs a new Order with the specified table ID
     * Initializes an empty BST with the root as null
     * @param tableID the table number for the order
     */
    public Order(String tableID) {
        this.tableID = tableID;
        this.root = null;
    }

    /**
     * Inserts a MenuItem into the BST by calling a recursive helper method
     * If an item with the same name and price already exists,
     * the quantities are combined rather than creating a duplicate node
     * @param m the MenuItem to insert
     */
    public void insert(MenuItem m) {root = insertRecursive(root, m);}
    /**
     * Recursive helper method for inserting MenuItem into BST
     * @param node the current node
     * @param m    the MenuItem to insert
     * @return the node after insertion
     */
    private BSTNode insertRecursive(BSTNode node, MenuItem m) {
        if (node == null) {
            return new BSTNode(m, null, null);
        }
        int compareResult = m.compareTo(node.getData());
        if (compareResult < 0) {
            node.setLeft(insertRecursive(node.getLeft(), m));
        } else if (compareResult > 0) {
            node.setRight(insertRecursive(node.getRight(), m));
        } else {
            MenuItem existingItem = node.getData();
            int newQuantity = existingItem.getQuantity() + m.getQuantity();
            existingItem.setQuantity(newQuantity);
        }
        return node;
    }

    /**
     * Performs a preorder traversal of the BST, printing each MenuItem
     * by calling recursive helper method
     * Order: root, left subtree, right subtree
     */
    public void preorder() {preorderRecursive(root);}
    /**
     * Recursive helper method for preorder traversal of the BST
     * @param node the current node
     */
    private void preorderRecursive(BSTNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderRecursive(node.getLeft());
            preorderRecursive(node.getRight());
        }
    }

    /**
     * Performs an inorder traversal of the BST, printing each MenuItem
     * by calling recursive helper method
     * Order: left subtree, root, right subtree
     */
    public void inorder() {inorderRecursive(root);}
    /**
     * Recursive helper method for inorder traversal of the BST
     * @param node the current node
     */
    private void inorderRecursive(BSTNode node) {
        if (node != null) {
            inorderRecursive(node.getLeft());
            System.out.println(node.getData());
            inorderRecursive(node.getRight());
        }
    }

    /**
     * Performs a postorder traversal of the BST, printing each MenuItem
     * by calling recursive helper method
     * Order: left subtree, right subtree, root
     */
    public void postorder() {postorderRecursive(root);}
    /**
     * Recursive helper method for postorder traversal of the BST
     * @param node the current node
     */
    private void postorderRecursive(BSTNode node) {
        if (node != null) {
            postorderRecursive(node.getLeft());
            postorderRecursive(node.getRight());
            System.out.println(node.getData());
        }
    }

    /**
     * Calculates the number of nodes in the BST by calling recursive helper method
     * @return the total number of nodes
     */
    public int size() {return sizeRecursive(root);}
    /**
     * Recursive helper method that calculates the size of the tree
     * @param node the current node
     * @return the number of nodes
     */
    private int sizeRecursive(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
    }

    /**
     * Calculates the height of the BST by calling recursive helper method
     * Empty tree returns -1, a tree with one node is 0
     * @return the height of the BST
     */
    public int height() {return heightRecursive(root);}
    /**
     * Recursive helper method that calculates the height of the tree
     * @param node the current node
     * @return the height of the BST
     */
    private int heightRecursive(BSTNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightRecursive(node.getLeft());
        int rightHeight = heightRecursive(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Calculates the total quantity of all items in the order
     * by calling recursive helper method
     * @return the total quantity across all items
     */
    public int getTotalQty() {return getTotalQtyRecursive(root);}
    /**
     * Recursive helper method that calculates the total quantity
     * @param node the current node
     * @return the sum of quantities
     */
    private int getTotalQtyRecursive(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.getData().getQuantity()
                + getTotalQtyRecursive(node.getLeft())
                + getTotalQtyRecursive(node.getRight());
    }

    /**
     * Searches for a MenuItem by name using recursive helper method
     * @param itemName the name of the item to find
     * @return the MenuItem if found, otherwise null
     */
    public MenuItem search(String itemName) {return searchRecursive(root, itemName);}
    /**
     * Recursive method that searches for a MenuItem by name
     * @param node the current node
     * @param itemName the name to search for
     * @return the MenuItem if found, null otherwise
     */
    private MenuItem searchRecursive(BSTNode node, String itemName) {
        if (node == null) {
            return null;
        }
        int compareResult = itemName.compareToIgnoreCase(node.getData().getName());
        if (compareResult == 0) {
            return node.getData();
        } else if (compareResult < 0) {
            return searchRecursive(node.getLeft(), itemName);
        } else {
            return searchRecursive(node.getRight(), itemName);
        }
    }

    /**
     * Calculates the total cost of all items in the order before tax and tip
     * by calling a recursive helper method
     * Each item's total is calculated as price * quantity and then added up
     *
     * @return the subtotal of the order
     */
    public double getTotalBeforeTaxAndTip() {return getTotalBeforeTaxAndTipRecursive(root);}
    /**
     * Recursive helper method that calculates the total cost before tax and tip
     * @param node the current node
     * @return the subtotal
     */
    private double getTotalBeforeTaxAndTipRecursive(BSTNode node) {
        if (node == null) {
            return 0.0;
        }
        double currentItemTotal = node.getData().getPrice() * node.getData().getQuantity();
        return currentItemTotal
                + getTotalBeforeTaxAndTipRecursive(node.getLeft())
                + getTotalBeforeTaxAndTipRecursive(node.getRight());
    }
    /**
     * Calculates the tip amount based on the subtotal and tip percentage
     * @param tipPct the tip percentage as a percentage of total bill
     * @return the tip amount in dollars
     */
    public double getTip(double tipPct) {return getTotalBeforeTaxAndTip() * (tipPct / 100.0);}
    /**
     * Calculates the tax amount based on the subtotal and tax percentage.
     * @param taxPct the tax percentage as a percentage of total bill
     * @return the tax amount in dollars
     */
    public double getTax(double taxPct) {return getTotalBeforeTaxAndTip() * (taxPct / 100.0);}

    /**
     * Returns a formatted string representation of the entire order
     * Includes restaurant name, table ID, all items, subtotal,
     *  tax 8%, tip 20%, and grand total by calling a helper method
     * that does inorder traversal to get the items in alphabetical order
     * @return a formatted string containing the complete order details
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(restaurantName).append(" Table ").append(tableID).append("\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append(String.format("%-20s %-10s %-10s %-10s%n", "Item", "Price", "Qty", "Total"));
        sb.append("--------------------------------------------------------------------------------\n");
        appendItemsAlphabetically(root, sb);
        sb.append("--------------------------------------------------------------------------------\n");
        double total = getTotalBeforeTaxAndTip();
        double tax = getTax(8.0);
        double tip = getTip(20.0);
        double grandTotal = total + tax + tip;
        sb.append("Total:\t$").append(String.format("%.2f", total)).append("\n");
        sb.append("Tax:\t$ ").append(String.format("%.2f", tax)).append("\n");
        sb.append("Tip:\t$ ").append(String.format("%.2f", tip)).append("\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("Grand total: $ ").append(String.format("%.2f", grandTotal)).append("\n");
        return sb.toString();
    }
    /**
     * Recursive helper method that appends MenuItems to the
     * String being built in alphabetical order using inorder traversal
     * @param node the current node
     * @param sb StringBuilder to append to
     */
    private void appendItemsAlphabetically(BSTNode node, StringBuilder sb) {
        if (node != null) {
            appendItemsAlphabetically(node.getLeft(), sb);
            sb.append(node.getData().toString()).append("\n");
            appendItemsAlphabetically(node.getRight(), sb);
        }
    }
}