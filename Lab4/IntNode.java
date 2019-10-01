

/**
 * @author Junyong Lee
 * This program is lab4 linked list.
 */
public class IntNode {

    
    // 1.1 instance variables
    private int data;
    private IntNode link;
    /**
     * Constructor for initializing data and link
     */

    // 1.2 Constructor
    public IntNode() {
        
        data = 0;
        link = null;
    }

    /**
     * Initialize data and link with parameters         
     * */
    
     // 1.3 Constructor with parameters
    public IntNode(int _data, IntNode _node) {

        data = _data;
        link = _node;
    

    }

    // 1.4 Get & Set
    /**
     * This method is to get data
     * @return return the data
     */
    public int getData() {
        return data;
    }
    /**
     * This method is to initialize data with given value
     * @param d is initialize the data
     */
    public void setData(int d) {
        data = d;
    }
    /**
     * This method is to get link
     * @return return the link
     */
    public IntNode getLink() {
        return link;
    }
    /**
     * This method is to initialize link with given value
     * @param l is initialize the link
     */
    public void setLink(IntNode l) {
        link = l;
    }

    /**
    /* This method moves cursor and accumulate the data and arrow until the cursor is not null
    */
    // 1.5 toString returns current node->node-> ... -> last node
    public String toString() {

        String result = "";
        IntNode cursor = null;
        // Activated by head

        result += Integer.toString(this.getData());
        // When activated by head
        for (cursor = link; cursor != null; cursor = cursor.link) {

            result += "->";
            result += Integer.toString(cursor.getData());

        }

        return result;

    }

    /**
     * makes new node and make it point to what current link was pointing to.
    */
    // 1.6 
    public void addNodeAfterThis(int newdata) {
        link = new IntNode(newdata, link);
 
    }

    /**
    * pointing to node after node that I am pointing at now.
    */
    // 1.7 
    public void removeNodeAfterThis() {
        link = link.link;

    }

    /**
    * Travers linked list and count 'answer'         
    */
    // 1.8 
    public static int listLength(IntNode head) {

        int answer;

        answer = 0;
        for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
            answer++;
        }

        return answer;

    }

            /**
         * Traverse linked list until it finds the target data. Parameter 'head' should not be null
         */
    // 1.9 
    public static boolean search(IntNode head, int data) {

        if(head == null){
            throw new IllegalArgumentException("head must not be null");
        }
        IntNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link) {
            if (data == cursor.data) {
                return true;
            }
        }
        return false;


    }
    /**
     * This main method is to test through all methods
     * @param args
     */
    public static void main(String[] args) {

        IntNode head = new IntNode(42, null); // head -> (42,null)
       
        //IntNode nulltest = null;
        //System.out.println(search(nulltest, 25));
        
        System.out.println(head.getData()); // 42

        System.out.println(head.getLink()); // null

        head.addNodeAfterThis(75); // head -> (42) -> (75, null)
        head.addNodeAfterThis(83); // head -> (42) -> (83) -> (75,null)
        System.out.println(head.link.getData());
        System.out.println(head.toString());
        System.out.println(head.link.toString());
        System.out.println(head.link.link.toString());

        System.out.println(search(head, 83));
        System.out.println(search(head, 24));

        System.out.println(listLength(head)); // 3

        head.removeNodeAfterThis(); // remove (83)
        System.out.println(head.toString()); // head -> (42) -> (75)

        System.out.println(listLength(head)); // 2

    }

}