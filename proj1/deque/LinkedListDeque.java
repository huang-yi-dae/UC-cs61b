package deque;

public class LinkedListDeque<PlaceHolder> {
    private IntNode sentinel;
    private int size;

    public class IntNode{
        public PlaceHolder item;
        public IntNode prev;
        public IntNode next;
        /**This contructor instantize a  node
         * whose prev and next are both itself*/
        public IntNode( PlaceHolder x){
           item = x;
           prev = this;
           next = this;
        }
    }
    public LinkedListDeque(PlaceHolder x){
        sentinel = new IntNode(null);
        IntNode first = new IntNode(x);
        sentinel.next = first;
        sentinel.prev = first;
        first.prev = sentinel;
        first.next = sentinel;
        size = 1;
    }
    public LinkedListDeque(){
        sentinel = new IntNode(null);
        size = 0;
    }

    /** Add value to the beginning of the list*/
    public void addFirst(PlaceHolder value){
        IntNode temp = new IntNode(value);
        addAfter(sentinel,temp);
    }


    /** Add value to the end of the list*/
    public void addLast(PlaceHolder value){
        IntNode temp = new IntNode(value);
        addAfter(sentinel.prev,temp);
    }
    private void addAfter(IntNode front,IntNode after){
        front.next.prev = after;
        after.next = front.next;
        front.next = after;
        after.prev = front;
        size+=1;
    }
    /** Return true if the list is empty*/
    public boolean isEmpty(){
        return size==0;
    }

    /** Return the number of items in the deque*/
    public int size(){
       return size;
    }

    /** Prints the items in the deque from first to last,
     * seperated by a space.
     * Once all the items hava been printed,
     * print out a new line.
     */
    public void printDeque(){
        int curLeft = size;
        IntNode temp = sentinel.next;
        while (curLeft>0){
            System.out.print(temp.item+" ");
            temp = temp.next;
            curLeft-=1;
        }
        System.out.print("\n");
    }

    /**Removes the first element of the list
     * and return the element if exists otherwise return null*/

    public PlaceHolder removeFirst(){
        return removeAfter(sentinel,sentinel.next);
    }
    /**
     * Remove the last element of the list
     * and return the element if exists otherwise return null
     * @return
     */

    public PlaceHolder removeLast(){
        return removeAfter(sentinel.prev.prev,sentinel.prev);
    }

    /**
     * Remove the after Intnode which is actually in the
     * after place of the front IIF size is larger than 0.
     * and return the item of the after if exists otherwise return null
     *
     * @param front the front Intnode.
     * @param after the after one Intnode.
     */
    private PlaceHolder removeAfter(IntNode front, IntNode after){
        PlaceHolder result = null;
        if (size!=0) {
            front.next = after.next;
            after.next.prev = front;
            size -=1;
            result = after.item;
        }
        return result;
    }
    /**
     * Get the item at the given index,
     * starting at 0.
     * If no such item exits, return null
     *
     * @return  return the item if it exists
     * otherwise return null.
     */
    public PlaceHolder get(int index){
       IntNode temp = sentinel.next;
       PlaceHolder result = null;
       int curIndex = 0;
       while (curIndex !=index && curIndex<size){
          curIndex+=1;
          temp=temp.next;
       }
       boolean b = temp.item == null;
       if (!b){
           result = temp.item;
       }
       return result;
    }

}
