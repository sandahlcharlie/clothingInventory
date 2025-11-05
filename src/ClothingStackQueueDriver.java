import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClothingStackQueueDriver {
    /**
     * This is the class that makes stacks and queues to show that the methods work
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
            intString.append(c.getStock());
            temp.push(c);
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return Integer.parseInt(intString.toString());
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

    public static int extractFromStack(Stack<Clothing> s, Clothing c){
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
            if(!garment.equals(c)){
                temp.push(garment);
                result++;
            }
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return result;
    }

    public static boolean equalStacks(Stack<Clothing> s1, Stack<Clothing> s2){
        /**
         * Compares two stacks for equality. Two stacks are considered equal if they
         * contain the same Clothing items in the same order.
         *
         * @param s1 the first stack to compare
         * @param s2 the second stack to compare
         * @return true if the stacks are equal, or false otherwise
         * @throws EmptyStackException if stacks have different sizes and one becomes empty during comparison
         */
        Stack<Clothing> temp1 = new Stack<Clothing>();
        Stack<Clothing> temp2 = new Stack<Clothing>();

        if (s1.isEmpty() && s2.isEmpty()){return true;}

        while (!s1.isEmpty()) {
            Clothing c1 = s1.pop();
            Clothing c2 = s2.pop();
            if (!c1.equals(c2)){return false;}
            temp1.push(c1);
            temp2.push(c2);
        }
        if(!s2.isEmpty()){return false;}

        while (!temp1.isEmpty()) {
            s1.push(temp1.pop());
            s2.push(temp2.pop());
        }
        return true;
    }

    public static int replace(Queue<Clothing> q, Clothing oldVal, Clothing newVal){
        /**
         * Replaces all occurrences of a specified Clothing item with a new Clothing item
         * in the queue.
         *
         * @param q the queue in which to perform replacements
         * @param oldVal the Clothing item to be replaced
         * @param newVal the Clothing item to replace with
         * @return the number of replacements made
         */
        Queue<Clothing> tempQ= new LinkedList<Clothing>();

        int result = 0;
        Clothing tempClothing;
        while (!q.isEmpty()){
            tempClothing = q.poll();
            if(tempClothing.equals(oldVal)){
                tempQ.offer(newVal);
                result++;
            }else {
                tempQ.offer(tempClothing);
            }
        }
        while(!tempQ.isEmpty()){
            q.offer(tempQ.poll());
        }
        return result;
    }

    public static void swap(Stack<Clothing> s, Queue<Clothing> q){
        /**
         * Swaps the contents between a stack and a queue. After the swap,
         * the stack will contain the queue's elements (in reversed order)
         * and the queue will contain the stack's original elements.
         *
         * @param s the stack to swap
         * @param q the queue to swap
         */
        Queue<Clothing> tempQ= new LinkedList<Clothing>();
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

    public static Queue<Clothing>[] split(Queue<Clothing> q){
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
        Queue<Clothing> tempQ= new LinkedList<Clothing>();

        Clothing tempClothing;
        while (!q.isEmpty()){
            tempClothing = q.remove();
            if(tempClothing instanceof Pants){
                PantsQ.offer(tempClothing);
            }else if (tempClothing instanceof Shirt) {
                ShirtQ.offer(tempClothing);
            }else {
                tempQ.offer(tempClothing);
            }
        }
        while(!tempQ.isEmpty()){
            q.offer(tempQ.remove());
        }

        Queue<Clothing>[] result = new Queue[2];
        result[0] = PantsQ;
        return result;

    }
}