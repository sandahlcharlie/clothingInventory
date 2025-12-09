public class RestaurantDriver {
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

        System.out.println("Size: " + order1.size());
        System.out.println("Height: " + order1.height());
        System.out.println("Total Quantity of items: " + order1.getTotalQty());

        System.out.println("\nSearch for 'Cheeseburger':");
        MenuItem found = order1.search("Cheeseburger");
        if(found != null) {
            System.out.println("Found: " + found.getName());
        } else {
            System.out.println("Item not found.");
        }

        System.out.println("\nSearch for 'Pizza':");
        MenuItem notFound = order1.search("Pizza");
        if(notFound != null) {
            System.out.println("Found: " + notFound.getName());
        } else {
            System.out.println("Item not found.");
        }

        System.out.println("\nPreorder Traversal:");
        order1.preorder();

        System.out.println("\nInorder Traversal:");
        order1.inorder();

        System.out.println("\nPostorder Traversal:");
        order1.postorder();

        System.out.println("\nOrder 1 Totals/Tax/Tip");
        System.out.printf("Total Before Tax/Tip: $%.2f%n", order1.getTotalBeforeTaxAndTip());
        System.out.printf("Tax (10.5%%): $%.2f%n", order1.getTax(10.5));
        System.out.printf("Tip (18.5%%): $%.2f%n", order1.getTip(18.5));

        System.out.println("\nPrint Both Orders:\n");

        System.out.println(order1.toString());
        System.out.println();
        System.out.println(order2.toString());
    }
}
