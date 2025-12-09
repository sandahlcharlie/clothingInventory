public class Order {
    private BSTNode root;
    private String tableID;
    private static String restaurantName;

    public String getTableID() {return tableID;}

    public void setTableID(String tableID) {this.tableID = tableID;}

    public BSTNode getRoot() {return root;}

    public void setRoot(BSTNode root) {this.root = root;}

    public Order( String tableID ) {
        this.tableID = tableID;
        this.root = null;
    }


    public void insert(MenuItem m) {
        root = insertRecursive(root, m);
    }
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


    public void preorder() {
        preorderRecursive(root);
    }
    private void preorderRecursive(BSTNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderRecursive(node.getLeft());
            preorderRecursive(node.getRight());
        }
    }


    public void inorder() {
        inorderRecursive(root);
    }
    private void inorderRecursive(BSTNode node) {
        if (node != null) {
            inorderRecursive(node.getLeft());
            System.out.println(node.getData());
            inorderRecursive(node.getRight());
        }
    }


    public void postorder() {
        postorderRecursive(root);
    }
    private void postorderRecursive(BSTNode node) {
        if (node != null) {
            postorderRecursive(node.getLeft());
            postorderRecursive(node.getRight());
            System.out.println(node.getData());
        }
    }


    public int size() {
        return sizeRecursive(root);
    }
    private int sizeRecursive(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
    }


    public int height() {
        return heightRecursive(root);
    }
    private int heightRecursive(BSTNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightRecursive(node.getLeft());
        int rightHeight = heightRecursive(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getTotalQty() {
        return getTotalQtyRecursive(root);
    }
    private int getTotalQtyRecursive(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.getData().getQuantity()
                + getTotalQtyRecursive(node.getLeft())
                + getTotalQtyRecursive(node.getRight());
    }

    public MenuItem search(String itemName) {
        return searchRecursive(root, itemName);
    }
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

    public double getTotalBeforeTaxAndTip() {
        return getTotalRecursive(root);
    }
    private double getTotalRecursive(BSTNode node) {
        if (node == null) {
            return 0.0;
        }
        double currentItemTotal = node.getData().getPrice() * node.getData().getQuantity();
        return currentItemTotal + getTotalRecursive(node.getLeft()) + getTotalRecursive(node.getRight());
    }

    public double getTip(double tipPct) {
        double subtotal = getTotalBeforeTaxAndTip();
        return subtotal * (tipPct / 100.0);
    }

    public double getTax(double taxPct) {
        double subtotal = getTotalBeforeTaxAndTip();
        return subtotal * (taxPct / 100.0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Downtown Café Table 12\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append(String.format("%-10s\t$ %-10s\t%-5s\tTotal\n", "Item", "Price", "Qty"));
        sb.append("--------------------------------------------------------------------------------\n");
        buildStringRecursive(root, sb);
        double subtotal = getTotalBeforeTaxAndTip();
        double taxAmount = getTax(8.0);
        double tipAmount = getTip(20.0);
        double grandTotal = subtotal + taxAmount + tipAmount;
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append(String.format("Total:\t$%.2f\n", subtotal));
        sb.append(String.format("Tax:\t\t$ %.2f\n", taxAmount));
        sb.append(String.format("Tip:\t\t$ %.2f\n", tipAmount));
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append(String.format("Grand total: $ %.2f", grandTotal));
        return sb.toString();
    }

    private void buildStringRecursive(BSTNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        buildStringRecursive(node.getLeft(), sb);
        double itemTotal = node.getData().getPrice() * node.getData().getQuantity();
        sb.append(String.format("%-10s\t$ %5.2f\t\t%d\t\t$%5.2f\n",
                node.getData().getName(),
                node.getData().getPrice(),
                node.getData().getQuantity(),
                itemTotal));
        buildStringRecursive(node.getRight(), sb);
    }
}
