

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
     * This method is to get the number of even element
     * @param head - head reference
     * @return evencount - the number of even element
     */
    public static int listEvenNumber(IntNode head) {
    	
   		IntNode cursor;
		int evencount = 0;
		
    	if(head == null) {
    		return 0;
    	}
    	else {
    			for(cursor = head; cursor != null; cursor = cursor.link) {
    			if( (cursor.data) % 2 == 0) {
    				evencount++;
    			}
    			
    		}
    	}
    	return evencount;
    }
    
    /**
     * This method is to add the given data to the end of the linked likst
     * @param newdata  - the data we want to add
     */
    public void addToEnd(int newdata) {
       
        IntNode cursor = link;
		while (cursor.link != null) {
			cursor = cursor.link;
		}
		cursor.link = new IntNode(newdata, null);


    	
    	
    }
    
    /**
     * This method is to calculate the summation of elements in the last num nodes in a given linked list
     * @precondition The head should not be null and num should be positive number
     */
    public static int sumLast(IntNode head, int num){

            IntNode cursor;
            int summation = 0;
            int cursorStopPoint = 0;
            // The case when num is bigger then whole number of linked list
            if((head != null) && (num > 0) ) // Precondition
            {
                if(num > listLength(head)) {
                    for(cursor = head; cursor != null; cursor = cursor.link){
                        
                        summation += cursor.data;

                    }
                    return summation;
                }
                else{

                    cursor = head;
                    cursorStopPoint = listLength(head) - num;
                    int loopCounter = 0;

                    // After this loop, cursor stops at the point we start doing suummation.
                    while(loopCounter != cursorStopPoint){
                        
                        cursor = cursor.link;
                        loopCounter++;
                    }

                    for(; cursor != null; cursor = cursor.link){
                        summation += cursor.data;
                    }
                    
                }
            }
            return summation;
    }

    /**
     * Tis methos is to copy odd number in linked list
     * @param args
     */
    public static IntNode copyOdd(IntNode head){

        IntNode copyHead;
        IntNode copyTail;
        
        if(head == null){
            return null;
        }
        
        else{
            while ((head.data%2) != 1) { //while is not odd, keep looking
                head = head.link;
                if (head == null) { //return null if there is not any odd
                    return null;
                }
            }

            copyHead = new IntNode(head.data, null);
            copyTail = copyHead;

            while(head.link != null){
                head = head.link;
                
                if(head.data % 2 == 1)
                {
                    copyTail.addNodeAfterThis(head.data);
                    copyTail = copyTail.link;
                }
            }


        }
        return copyHead;
    }

    /**
     * This methos is to remove all the nodes that have the data value e from te linked list starting 
     * from the given head.
     * @return linked list with the new head.
     */
    public static IntNode removeAll(IntNode head, int e){
        
        IntNode copyHead;
	    IntNode copyTail;
	    
	    if (head == null) {
	       return null;
	    }
             
        // After the while loop, the head starts with element haveing not e
	    while (head.data == e) { 
	    	head = head.link;
	    	if (head == null) {
	    		return null;
	    	}
	    }
	    
	    // Make the first node for the new linked list.
	    copyHead = new IntNode(head.data, null);
	    copyTail = copyHead;
	      
	    // Make the rest of the nodes for the new linked list.
	    while (head.link != null) {
	       head = head.link;
	       if ((head.data) != e) { //if it's not e, then copy it.
	    	   copyTail.addNodeAfterThis(head.data);
	    	   copyTail = copyTail.link;
	       }
	    }
	 
        return copyHead;

    }



    /**
     * This method should return the linked list with the new head.
     * @param args
     */
    public static IntNode reverse (IntNode head){

        IntNode prev = null; 
        IntNode current = head; 
        IntNode next = null; 
        while (current != null) { 
            next = current.link; 
            current.link = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
        return head; 
    
    }

    /**
    * This method is to test whether a linked list starting from the given head is cyclic or acyclic.
    */
    // public static boolean hasCycle(IntNode head) {
        
    // }
    
    /**
     * This main method is to test through all methods
     * @param args
     */
    public static void main(String[] args) {

        IntNode head = new IntNode(42, null); // head -> (42,null)
        IntNode head2 = new IntNode(1, null);
        //IntNode nulltest = null;
        //System.out.println(search(nulltest, 25));
        
        System.out.println(head.getData()); // 42

        System.out.println(head.getLink()); // null

        head.addNodeAfterThis(75); // head -> (42) -> (75, null)
        head.addNodeAfterThis(83); // head -> (42) -> (83) -> (75,null)
        // System.out.println(head.link.getData());
        // System.out.println(head.toString());
        // System.out.println(head.link.toString());
        // System.out.println(head.link.link.toString());

        // System.out.println(search(head, 83));
        // System.out.println(search(head, 24));

        // System.out.println(listLength(head)); // 3

        // head.removeNodeAfterThis(); // remove (83)
        // System.out.println(head.toString()); // head -> (42) -> (75)

        // System.out.println(listLength(head)); // 2
        
        // System.out.println("Make another test case");
        // head.addNodeAfterThis(24);
        // head.addNodeAfterThis(68);
        // head.addNodeAfterThis(13);
        // head.addNodeAfterThis(45);
        // // Test listEvenNumber()
        // //System.out.println(listEvenNumber(head));
        // System.out.println(head);
        
        // // Test listEvenNumber()
        // System.out.println(listEvenNumber(head));
        System.out.println(head);
        head.addToEnd(100);
        System.out.println(head);
        System.out.println(sumLast(head, 3));
        System.out.println(sumLast(head, 7));

        head.addNodeAfterThis(22);
        head.addNodeAfterThis(22);
        System.out.println(head);
        System.out.println(copyOdd(head));
        System.out.println("----------------removeAll Test: remove 22");
        
        System.out.println(removeAll(head, 22));
        System.out.println("----------------reverse Test");
        System.out.println(reverse(head));

        head2.addNodeAfterThis(2);
        System.out.println(head2);
        System.out.println(reverse(head2));

    }

}