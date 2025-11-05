import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClothingStackQueueDriver {
    /**
     * This is the class that makes stacks and queues to show that the methods work
     *
     * @author Charles Sandahl
     * @version 0.1
     * @see Clothing
     * @see Pants
     * @see Shirt
     */
    public static int stackToInt(Stack<Clothing> s) {
        /**
         * Converts a stack of Clothing objects to an integer by concatenating
         * the stock values of all items in the stack.
         *
         * @param s the stack of Clothing objects to convert
         * @return an integer formed by concatenating all stock values in stack order
         */
        StringBuilder intString = new StringBuilder();
        Stack<Clothing> temp = new Stack<Clothing>();

        while (!s.isEmpty()) {
            Clothing c = s.pop();
            String stock = String.valueOf(c.getStock());
            intString.insert(0, c.getStock());
            temp.push(c);
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
        if (intString.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(intString.toString());
        }
    }

    public static int popSome(Stack<Clothing> s, int count) {
        /**
         * Removes a specified number of items from the top of the stack and
         * returns the sum of their stock values.
         *
         * @param s the stack to pop items from
         * @param count the number of items to pop
         * @return the sum of stock values of the popped items
         * or -1 if count is less than the stack size
         */
        int result = 0;

        if (count > s.size()) {
            while (!s.isEmpty()) {
                s.pop();
            }
            return -1;
        } else {
            for (int i = 0; i < count; i++) {
                Clothing c = s.pop();
                result += c.getStock();
            }
            return result;
        }
    }

    public static int extractFromStack(Stack<Clothing> s, Clothing c) {
        /**
         * Removes all occurrences of a specified Clothing item from the stack
         * and returns the count of items that remained in the stack.
         *
         * @param s the stack to extract from
         * @param c the Clothing item to remove from the stack
         * @return the number of items remaining in the stack after extraction
         */
        int result = 0;
        Stack<Clothing> temp = new Stack<Clothing>();

        while (!s.isEmpty()) {
            Clothing garment = s.pop();
            if (!garment.equals(c)) {
                temp.push(garment);
            }else{
                result++;
            }
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return result;
    }

    public static boolean equalStacks(Stack<Clothing> s1, Stack<Clothing> s2) {
        /**
         * Compares two stacks for equality. Two stacks are considered equal if they
         * contain the same Clothing items in the same order.
         *
         * @param s1 the first stack to compare
         * @param s2 the second stack to compare
         * @return true if the stacks are equal, or false otherwise
         */
        Stack<Clothing> temp1 = new Stack<Clothing>();
        Stack<Clothing> temp2 = new Stack<Clothing>();

        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }

        if (s1.size() != s2.size()){return false;}

        while (!s1.isEmpty()) {
            Clothing c1 = s1.pop();
            Clothing c2 = s2.pop();
            if (!c1.equals(c2)) {
                return false;
            }
            temp1.push(c1);
            temp2.push(c2);
        }

        while (!temp1.isEmpty()) {
            s1.push(temp1.pop());
            s2.push(temp2.pop());
        }
        return true;
    }

    public static int replace(Queue<Clothing> q, Clothing oldVal, Clothing newVal) {
        /**
         * Replaces all occurrences of a specified Clothing item with a new Clothing item
         * in the queue.
         *
         * @param q the queue in which to perform replacements
         * @param oldVal the Clothing item to be replaced
         * @param newVal the Clothing item to replace with
         * @return the number of replacements made
         */
        Queue<Clothing> tempQ = new LinkedList<Clothing>();

        int result = 0;
        Clothing tempClothing;
        while (!q.isEmpty()) {
            tempClothing = q.poll();
            if (tempClothing.equals(oldVal)) {
                tempQ.offer(newVal);
                result++;
            } else {
                tempQ.offer(tempClothing);
            }
        }
        while (!tempQ.isEmpty()) {
            q.offer(tempQ.poll());
        }
        return result;
    }

    public static void swap(Stack<Clothing> s, Queue<Clothing> q) {
        /**
         * Swaps the contents between a stack and a queue. After the swap,
         * the stack will contain the queue's elements (in reversed order)
         * and the queue will contain the stack's original elements.
         *
         * @param s the stack to swap
         * @param q the queue to swap
         */
        Queue<Clothing> tempQ = new LinkedList<Clothing>();
        Stack<Clothing> tempS = new Stack<Clothing>();

        while (!s.isEmpty()) {
            tempQ.offer(s.pop());
        }

        while (!q.isEmpty()) {
            tempS.push(q.poll());
        }

        while (!tempS.isEmpty()) {
            s.push(tempS.pop());
        }

        while (!tempQ.isEmpty()) {
            q.offer(tempQ.poll());
        }
    }

    public static Queue<Clothing>[] split(Queue<Clothing> q) {
        /**
         * Splits a queue of Clothing items into separate queues based on their type.
         * Creates one queue for Pants items and another for Shirt items.
         * Any Clothing that is not Pants or Shirts are returned to the
         * original queue.
         *
         * @param q the queue of Clothing items to split. After execution, this queue
         *          will only contain Clothing that is not Pants or Shirts
         * @return an array of queues where index 0 contains Pants and index 1 contains Shirts
         */
        LinkedList<Clothing> PantsQ = new LinkedList<Clothing>();
        LinkedList<Clothing> ShirtQ = new LinkedList<Clothing>();
        Queue<Clothing> tempQ = new LinkedList<Clothing>();

        Clothing tempClothing;
        while (!q.isEmpty()) {
            tempClothing = q.remove();
            if (tempClothing instanceof Pants) {
                PantsQ.offer(tempClothing);
            } else if (tempClothing instanceof Shirt) {
                ShirtQ.offer(tempClothing);
            } else {
                tempQ.offer(tempClothing);
            }
        }
        while (!tempQ.isEmpty()) {
            q.offer(tempQ.remove());
        }

        Queue<Clothing>[] result = new Queue[2];
        result[0] = PantsQ;
        return result;
    }

    public static void main(String[] args) {
        Stack<Clothing> empty = new Stack<Clothing>();
        Stack<Clothing> empty2 = new Stack<Clothing>();
        Queue<Clothing> emptyQ= new LinkedList<>();




        System.out.println("--------------------------------------------------------");
        System.out.println("TEST stackToInt()");
        Stack<Clothing> four = new Stack<Clothing>();
        four.push(new Clothing("Socks", 15));
        four.push(new Clothing("Pants", 12));
        four.push(new Clothing("Jacket", 8));
        four.push(new Clothing("Hat", 13));
        System.out.println("Stack with four items:");
        System.out.println("input:");
        System.out.println(four);
        System.out.println("output:");
        System.out.println(stackToInt(four));
        System.out.println();
        System.out.println("Stack with one items:");
        Stack<Clothing> one = new Stack<Clothing>();
        one.push(new Clothing("Shirt", 25));
        System.out.println("input:");
        System.out.println(one);
        System.out.println("output:");
        System.out.println(stackToInt(one));
        System.out.println();
        System.out.println("Empty stack:");
        System.out.println("input:");
        System.out.println(empty);
        System.out.println("output:");
        System.out.println(stackToInt(empty));
        System.out.println("--------------------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------------------------");
        System.out.println("TEST popSome()");
        Stack<Clothing> fourPop1 = new Stack<Clothing>();
        fourPop1.push(new Clothing("Socks", 15));
        fourPop1.push(new Clothing("Pants", 12));
        fourPop1.push(new Clothing("Jacket", 8));
        fourPop1.push(new Clothing("Hat", 13));
        System.out.println("Stack has count items");
        System.out.println("input:");
        System.out.println(fourPop1);
        System.out.println("output (count 4):");
        System.out.println(popSome(four, 4));
        System.out.println(fourPop1);
        System.out.println();
        System.out.println("Stack has multiple items and count < number of items");
        Stack<Clothing> fourPop2 = new Stack<Clothing>();
        fourPop2.push(new Clothing("Socks", 15));
        fourPop2.push(new Clothing("Pants", 12));
        fourPop2.push(new Clothing("Jacket", 8));
        fourPop2.push(new Clothing("Hat", 13));;
        System.out.println("input:");
        System.out.println(fourPop2);
        System.out.println("output (count 2):");
        System.out.println(popSome(fourPop2, 2));
        System.out.println(fourPop2);
        System.out.println();
        System.out.println("Stack has multiple items and count > number of items");
        Stack<Clothing> fourPop3 = new Stack<Clothing>();
        fourPop3.push(new Clothing("Socks", 15));
        fourPop3.push(new Clothing("Pants", 12));
        fourPop3.push(new Clothing("Jacket", 8));
        fourPop3.push(new Clothing("Hat", 13));
        System.out.println("input:");
        System.out.println(fourPop3);
        System.out.println("output (count 6):");
        System.out.println(popSome(fourPop3, 6));
        System.out.println(fourPop3);
        System.out.println("Empty stack and count > 1");
        System.out.println("input:");
        System.out.println(empty);
        System.out.println("output (count 2):");
        System.out.println(popSome(empty, 2));
        System.out.println(empty);
        System.out.println();
        System.out.println("Non-empty stack and count = 0.");
        System.out.println("input:");
        System.out.println(fourPop2);
        System.out.println("output (count 0):");
        System.out.println(popSome(fourPop2, 0));
        System.out.println(fourPop2);
        System.out.println();
        System.out.println("Non-empty stack and count is negative");
        System.out.println("input:");
        System.out.println(fourPop2);
        System.out.println("output (count -1):");
        System.out.println(popSome(fourPop2, -1));
        System.out.println(fourPop2);
        System.out.println("--------------------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------------------------");
        System.out.println("TEST extractFromStack()");
        Stack<Clothing> fourExtract = new Stack<Clothing>();
        fourExtract.push(new Clothing("Socks", 15));
        fourExtract.push(new Clothing("Pants", 12));
        fourExtract.push(new Clothing("Jacket", 8));
        fourExtract.push(new Clothing("Hat", 13));
        System.out.println("Non-empty stack with one item matching the input item. ");
        System.out.println("input:");
        System.out.println(fourExtract);
        System.out.println("output extract Clothing(\"Socks\", 15):");
        System.out.println(extractFromStack(fourExtract, new Clothing("Socks", 15)));
        System.out.println(fourExtract);
        System.out.println();
        System.out.println("Non-empty stack with several items matching the input item. ");
        Stack<Clothing> eightExtract = new Stack<Clothing>();
        eightExtract.push(new Clothing("Jacket", 8));
        eightExtract.push(new Clothing("Socks", 15));
        eightExtract.push(new Clothing("Jacket", 8));
        eightExtract.push(new Clothing("Pants", 12));
        eightExtract.push(new Clothing("Jacket", 8));
        eightExtract.push(new Clothing("Hat", 13));
        eightExtract.push(new Clothing("Jacket", 8));
        System.out.println("input:");
        System.out.println(eightExtract);
        System.out.println("output extract Clothing(\"Jacket\", 8):");
        System.out.println(extractFromStack(eightExtract, new Clothing("Jacket", 8)));
        System.out.println(eightExtract);
        System.out.println();
        System.out.println("Non-empty stack with no items matching the input item.");
        System.out.println("input:");
        System.out.println(eightExtract);
        System.out.println("output extract Clothing(\"Raincoat\", 1):");
        System.out.println(extractFromStack(eightExtract, new Clothing("Raincoat", 1)));
        System.out.println(eightExtract);
        System.out.println();
        System.out.println("Empty stack");
        System.out.println("input:");
        System.out.println(empty);
        System.out.println("output extract Clothing(\"Jacket\", 8):");
        System.out.println(extractFromStack(empty, new Clothing("Jacket", 8)));
        System.out.println(empty);
        System.out.println("--------------------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------------------------");
        System.out.println("TEST equalStacks()");
        Stack<Clothing> fourEqual = new Stack<Clothing>();
        fourEqual.push(new Clothing("Socks", 15));
        fourEqual.push(new Clothing("Pants", 12));
        fourEqual.push(new Clothing("Jacket", 8));
        fourEqual.push(new Clothing("Hat", 13));
        Stack<Clothing> fourEqual2 = new Stack<Clothing>();
        fourEqual2.push(new Clothing("Socks", 15));
        fourEqual2.push(new Clothing("Pants", 12));
        fourEqual2.push(new Clothing("Jacket", 8));
        fourEqual2.push(new Clothing("Hat", 13));
        System.out.println("Non-empty stacks and equal");
        System.out.println("input 1:");
        System.out.println(fourEqual);
        System.out.println("input 2:");
        System.out.println(fourEqual2);
        System.out.println("output:");
        System.out.println(equalStacks(fourEqual,fourEqual2));
        System.out.println();
        System.out.println("Non-empty stacks and not equal");
        System.out.println("input 1:");
        System.out.println(fourEqual);
        System.out.println("input 2:");
        System.out.println(eightExtract);
        System.out.println("output:");
        System.out.println(equalStacks(fourEqual, eightExtract));
        System.out.println();
        System.out.println("One of the input stacks is empty (returns false)");
        System.out.println("input 1:");
        System.out.println(fourEqual);
        System.out.println("input 2:");
        System.out.println(empty);
        System.out.println("output:");
        System.out.println(equalStacks(fourEqual, empty));
        System.out.println();
        System.out.println("Both input stacks are empty (returns true)");
        System.out.println("input 1:");
        System.out.println(empty);
        System.out.println("input 2:");
        System.out.println(empty2);
        System.out.println("output:");
        System.out.println(equalStacks(empty, empty2));
        System.out.println("--------------------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------------------------");
        System.out.println("TEST replace()");
        Queue<Clothing> fourQ = new LinkedList<>();
        fourQ.offer(new Clothing("Socks", 15));
        fourQ.offer(new Clothing("Pants", 12));
        fourQ.offer(new Clothing("Jacket", 8));
        fourQ.offer(new Clothing("Hat", 13));
        System.out.println("Queue has multiple entries, including one oldVal.");
        System.out.println("input:");
        System.out.println(fourQ);
        System.out.println("output Hat 15 to Beanie 4:");
        System.out.println(replace(fourQ, new Clothing("Hat", 15), new Clothing("Beanie", 4)));
        System.out.println(fourQ);
        System.out.println();
        System.out.println("Queue has multiple entries, including multiple oldVal.");
        Queue<Clothing> eightQ = new LinkedList<>();
        eightQ.offer(new Clothing("Pants", 12));
        eightQ.offer(new Clothing("Socks", 15));
        eightQ.offer(new Clothing("Pants", 12));
        eightQ.offer(new Clothing("Jacket", 8));
        eightQ.offer(new Clothing("Pants", 12));
        eightQ.offer(new Clothing("Hat", 13));
        eightQ.offer(new Clothing("Pants", 12));
        eightQ.offer(new Clothing("Pants", 12));
        System.out.println("input:");
        System.out.println(eightQ);
        System.out.println("output Pants 12 to Jeans 20:");
        System.out.println(replace(eightQ, new Clothing("Pants", 12), new Clothing("Jeans", 20)));
        System.out.println(eightQ);
        System.out.println();
        System.out.println("oldVal is first in the queue.");
        System.out.println("input:");
        System.out.println(fourQ);
        System.out.println("output replace q.peek() with Toe Socks 2:");
        System.out.println(replace(fourQ, fourQ.peek(), new Clothing("Toe Socks", 2)));
        System.out.println(fourQ);
        System.out.println();
        System.out.println("oldVal is last in the queue.");
        System.out.println("input:");
        System.out.println(fourQ);
        System.out.println("output replace ((LinkedList<Clothing>) q).getLast():");
        System.out.println(replace(fourQ, ((LinkedList<Clothing>) fourQ).getLast(), new Clothing("Cap", 5)));
        System.out.println(fourQ);
        System.out.println();
        System.out.println("Queue has multiple entries, not including oldVal.");
        Queue<Clothing> eightQ2 = new LinkedList<>();
        eightQ2.offer(new Clothing("Pants", 12));
        eightQ2.offer(new Clothing("Socks", 15));
        eightQ2.offer(new Clothing("Pants", 12));
        eightQ2.offer(new Clothing("Jacket", 8));
        eightQ2.offer(new Clothing("Pants", 12));
        eightQ2.offer(new Clothing("Hat", 13));
        eightQ2.offer(new Clothing("Pants", 12));
        eightQ2.offer(new Clothing("Pants", 12));
        System.out.println("input:");
        System.out.println(eightQ2);
        System.out.println("output replace Raincoat 2 with Puffer Coat 43:");
        System.out.println(replace(eightQ2, new Clothing("Raincoat", 2), new Clothing("Puffer Coat", 23)));
        System.out.println(eightQ2);
        System.out.println();
        System.out.println("Queue is empty");
        System.out.println("input:");
        System.out.println(empty);
        System.out.println("output replace Raincoat 2 with Puffer Coat 43::");
        System.out.println(replace(emptyQ, new Clothing("Raincoat", 2), new Clothing("Puffer Coat", 23)));
        System.out.println("--------------------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------------------------");
        Queue<Clothing> fourQSwap = new LinkedList<>();
        fourQSwap.offer(new Clothing("Shirt", 30));
        fourQSwap.offer(new Clothing("Sweater", 3));
        fourQSwap.offer(new Clothing("Hoodie", 14));
        fourQSwap.offer(new Clothing("Stockings", 9));
        System.out.println("TEST swap()");
        System.out.println("Non-empty stack and queue, both the same length.");
        System.out.println("input stack:");
        System.out.println(fourEqual);
        System.out.println("input queue:");
        System.out.println(fourQSwap);
        System.out.println("output:");
        swap(fourEqual, fourQSwap);
        System.out.println("output stack:");
        System.out.println(fourEqual);
        System.out.println("output queue:");
        System.out.println(fourQSwap);
        System.out.println();
        System.out.println("Non-empty stack and queue not of the same length.");
        Queue<Clothing> eightQSwap = new LinkedList<>();
        eightQSwap.offer(new Clothing("Socks", 15));
        eightQSwap.offer(new Clothing("Pants", 12));
        eightQSwap.offer(new Clothing("Jacket", 8));
        eightQSwap.offer(new Clothing("Hat", 13));
        eightQSwap.offer(new Clothing("Shirt", 30));
        eightQSwap.offer(new Clothing("Sweater", 3));
        eightQSwap.offer(new Clothing("Hoodie", 14));
        eightQSwap.offer(new Clothing("Stockings", 9));
        System.out.println("input stack:");
        System.out.println(fourEqual);
        System.out.println("input queue:");
        System.out.println(eightQSwap);
        System.out.println("output:");
        swap(fourEqual, eightQSwap);
        System.out.println("output stack:");
        System.out.println(fourEqual);
        System.out.println("output queue:");
        System.out.println(eightQSwap);
        System.out.println();
        System.out.println("Empty stack and non-empty queue.");
        System.out.println("input stack:");
        System.out.println(empty);
        System.out.println("input queue:");
        System.out.println(eightQSwap);
        System.out.println("output:");
        swap(empty, eightQSwap);
        System.out.println("output stack:");
        System.out.println(empty);
        System.out.println("output queue:");
        System.out.println(eightQSwap);
        System.out.println();
        System.out.println("Empty queue and non-empty stack.");
        System.out.println("input stack:");
        System.out.println(fourEqual);
        System.out.println("input queue:");
        System.out.println(emptyQ);
        System.out.println("output:");
        swap(fourEqual, emptyQ);
        System.out.println("output stack:");
        System.out.println(fourEqual);
        System.out.println("output queue:");
        System.out.println(emptyQ);
        System.out.println("--------------------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------------------------");
        System.out.println("TEST split()");

        System.out.println();
        System.out.println("Input queue has a mix of Item, ItemA and ItemB items.");
        System.out.println("input:");
        System.out.println();
        System.out.println("output:");
        System.out.println();
        System.out.println();
        System.out.println("Input queue has only Pants items.");
        System.out.println("input:");
        System.out.println();
        System.out.println("output:");
        System.out.println();
        System.out.println();
        System.out.println("Input queue has only Shirt items.");
        System.out.println("input:");
        System.out.println();
        System.out.println("output:");
        System.out.println();
        System.out.println();
        System.out.println("Input queue has only Clothing items.");
        System.out.println("input:");
        System.out.println();
        System.out.println("output:");
        System.out.println();
        System.out.println();
        System.out.println("Input queue is empty.");
        System.out.println("input:");
        System.out.println();
        System.out.println("output:");
        System.out.println();
        System.out.println("--------------------------------------------------------");

    }
}