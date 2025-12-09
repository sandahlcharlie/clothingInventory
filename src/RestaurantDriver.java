/**
 * Driver class to test the order class using Binary Search Trees.
 * Creates multiple orders with menu items and tests
 * methods of Order, MenuItem, and BSTNode classes.
 * @author Charles
 * @version 0.1
 */public class RestaurantDriver {
    /**
     * Main method that names the restaurant, creates 15 menu items
     * Creates 2 orders and adds 15 items to each order in different
     * order avoiding alphabetically
     * Tests all methods and shows results before finally printing the
     * receipts of the two orders.
     */
    public static void main(String[] args) {
        Order.setRestaurantName("Salty's");

        MenuItem item1 = new MenuItem("Hamburger",9.99 ,1);
        MenuItem item2 = new MenuItem("Cheeseburger",11.99 ,1);
        MenuItem item3 = new MenuItem("Fries",4.99 ,1);
        MenuItem item4 = new MenuItem("Chicken Tenders",8.99 ,1);
        MenuItem item5 = new MenuItem("Chicken Sandwich",10.99 ,1);
        MenuItem item6 = new MenuItem("Special Sauce",0.50 ,1);
        MenuItem item7 = new MenuItem("Fried Fish",12.99 ,1);
        MenuItem item8 = new MenuItem("Onion Rings",6.99 ,1);
        MenuItem item9 = new MenuItem("Milkshake",5.99 , 1);
        MenuItem item10 = new MenuItem("Salad",7.99 ,1);
        MenuItem item11 = new MenuItem("Hot Dog",4.99 ,1);
        MenuItem item12 = new MenuItem("Soda",1.99 ,1);
        MenuItem item13 = new MenuItem("Sweet Tea",1.99 ,1);
        MenuItem item14 = new MenuItem("Coffee",1.49 ,1);
        MenuItem item15 = new MenuItem("Bottled Water",1.49 ,1);

        Order order1 = new Order("12");
        order1.insert(item10);
        order1.insert(item5);
        order1.insert(item15);
        order1.insert(item1);
        order1.insert(item7);
        order1.insert(item9);
        order1.insert(item3);
        order1.insert(item2);
        order1.insert(item4);
        order1.insert(item6);
        order1.insert(item8);
        order1.insert(item11);
        order1.insert(item13);
        order1.insert(item14);
        order1.insert(item12);

        Order order2 = new Order("10");
        order2.insert(item8);
        order2.insert(item6);
        order2.insert(item6);
        order2.insert(item8);
        order2.insert(item10);
        order2.insert(item11);
        order2.insert(item14);
        order2.insert(item4);
        order2.insert(item1);
        order2.insert(item2);
        order2.insert(item15);
        order2.insert(item5);
        order2.insert(item7);
        order2.insert(item9);
        order2.insert(item3);

        System.out.println("Size Order 1: " + order1.size());
        System.out.println("Height Order 1: " + order1.height());
        System.out.println("Total Quantity of items Order 1: " + order1.getTotalQty());

        System.out.println("\nSearch for 'Cheeseburger' in order 1:");
        MenuItem found1 = order1.search("Cheeseburger");
        if(found1 != null) {
            System.out.println("Found: " + found1.getName());
        } else {
            System.out.println("Item not found.");
        }

        System.out.println("\nSearch for 'Pizza' in order 1:");
        MenuItem notFound1 = order1.search("Pizza");
        if(notFound1 != null) {
            System.out.println("Found: " + notFound1.getName());
        } else {
            System.out.println("Item not found.");
        }

        System.out.println("\nPreorder Traversal Order 1:");
        order1.preorder();
        System.out.println("\nInorder Traversal Order 1:");
        order1.inorder();
        System.out.println("\nPostorder Traversal Order 1:");
        order1.postorder();

        System.out.println("\nOrder 1 Totals/Tax/Tip");
        System.out.printf("Total Before Tax/Tip: $%.2f%n", order1.getTotalBeforeTaxAndTip());
        System.out.printf("Tax (10.5%%): $%.2f%n", order1.getTax(10.5));
        System.out.printf("Tip (18.5%%): $%.2f%n", order1.getTip(18.5));


        System.out.println("Size Order 2: " + order2.size());
        System.out.println("Height Order 2: " + order2.height());
        System.out.println("Total Quantity of items Order 2: " + order2.getTotalQty());

        System.out.println("\nSearch for 'Cheeseburger' in order 2:");
        MenuItem found2 = order1.search("Cheeseburger");
        if(found2 != null) {
            System.out.println("Found: " + found2.getName());
        } else {
            System.out.println("Item not found.");
        }

        System.out.println("\nSearch for 'Pizza' in order 2:");
        MenuItem notFound2 = order1.search("Pizza");
        if(notFound2 != null) {
            System.out.println("Found: " + notFound2.getName());
        } else {
            System.out.println("Item not found.");
        }
        System.out.println("\nPreorder Traversal Order 2:");
        order2.preorder();
        System.out.println("\nInorder Traversal Order 2:");
        order2.inorder();
        System.out.println("\nPostorder Traversal Order 2:");
        order2.postorder();

        System.out.println("\nOrder 2 Totals/Tax/Tip");
        System.out.printf("Total Before Tax/Tip: $%.2f%n", order2.getTotalBeforeTaxAndTip());
        System.out.printf("Tax (10.5%%): $%.2f%n", order2.getTax(10.5));
        System.out.printf("Tip (18.5%%): $%.2f%n", order2.getTip(18.5));
        System.out.println("\nPrint Both Orders:\n");

        System.out.println(order1.toString());
        System.out.println();
        System.out.println(order2.toString());
    }
}
