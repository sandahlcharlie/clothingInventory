import java.util.Stack;

public class ClothingStackQueueDriver {
    /**
     * This is the class that makes stacks and queues to show that the methods work
     *
     * @param parameterName description of parameter
     * @return description of return value
     * @throws ExceptionType description of when this exception is thrown
     * @author Charles Sandahl
     * @version 0.1
     * @author Your Name
     * @version version-number
     * @see Clothing
     * @see Pants
     * @see Shirt
     * @see ReferenceClass
     * @since version
     */
    public static int stackToInt(Stack<Clothing> s) {
        int result = 0;
        Stack<Clothing> temp = new Stack<Clothing>();

        while (!s.isEmpty()) {
            Clothing c = s.pop();
            result += c.getStock();
            temp.push(c);
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return result;
    }

    public static int popSome(Stack<Clothing> s, int count) {
        int result = 0;

        if (count < s.size()) {
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
}