public class Order {
    private BSTNode root;
    private String tableID;
    private static String restaurantName;

    public String getTableID() {return tableID;}
    public void setTableID(String tableID) {this.tableID = tableID;}
    public BSTNode getRoot() {return root;}
    public void setRoot(BSTNode root) {this.root = root;}
    public static void setRestaurantName(String name) {restaurantName = name;}

    public Order(String tableID) {
        this.tableID = tableID;
        this.root = null;
    }


    public void insert(MenuItem m) {root = insertRecursive(root, m);}
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


    public void preorder() {preorderRecursive(root);}
    private void preorderRecursive(BSTNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderRecursive(node.getLeft());
            preorderRecursive(node.getRight());
        }
    }


    public void inorder() {inorderRecursive(root);}
    private void inorderRecursive(BSTNode node) {
        if (node != null) {
            inorderRecursive(node.getLeft());
            System.out.println(node.getData());
            inorderRecursive(node.getRight());
        }
    }


    public void postorder() {postorderRecursive(root);}
    private void postorderRecursive(BSTNode node) {
        if (node != null) {
            postorderRecursive(node.getLeft());
            postorderRecursive(node.getRight());
            System.out.println(node.getData());
        }
    }


    public int size() {return sizeRecursive(root);}
    private int sizeRecursive(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
    }


    public int height() {return heightRecursive(root);}
    private int heightRecursive(BSTNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightRecursive(node.getLeft());
        int rightHeight = heightRecursive(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getTotalQty() {return getTotalQtyRecursive(root);}
    private int getTotalQtyRecursive(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.getData().getQuantity()
                + getTotalQtyRecursive(node.getLeft())
                + getTotalQtyRecursive(node.getRight());
    }

    public MenuItem search(String itemName) {return searchRecursive(root, itemName);}
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


    public double getTotalBeforeTaxAndTip() {return getTotalBeforeTaxAndTipRecursive(root);}
    private double getTotalBeforeTaxAndTipRecursive(BSTNode node) {
        if (node == null) {
            return 0.0;
        }
        double currentItemTotal = node.getData().getPrice() * node.getData().getQuantity();
        return currentItemTotal
                + getTotalBeforeTaxAndTipRecursive(node.getLeft())
                + getTotalBeforeTaxAndTipRecursive(node.getRight());
    }
    public double getTip(double tipPct) {return getTotalBeforeTaxAndTip() * (tipPct / 100.0);}
    public double getTax(double taxPct) {return getTotalBeforeTaxAndTip() * (taxPct / 100.0);}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(restaurantName).append(" Table ").append(tableID).append("\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append(String.format("%-20s %-10s %-10s %-10s%n","Item","Price","Qty","Total"));
        sb.append("--------------------------------------------------------------------------------\n");
        toStringInorderRecursive(root, sb);
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
    private void toStringInorderRecursive(BSTNode node, StringBuilder sb) {
        if (node != null) {
            toStringInorderRecursive(node.getLeft(), sb);
            sb.append(node.getData().toString()).append("\n");
            toStringInorderRecursive(node.getRight(), sb);
        }
    }
}
