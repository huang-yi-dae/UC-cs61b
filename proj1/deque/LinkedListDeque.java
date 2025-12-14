package deque;


import java.util.NoSuchElementException;
import java.util.Iterator;

public  class LinkedListDeque<T> implements deque.Deque<T>{
    private final Node sentinel;
    private int size;



    private class Node {
        public T item;
        public Node prev;
        public Node next;
        /**This constructor instantize a  node
         * whose prev and next are both itself*/
        public Node(T x){
           item = x;
           prev = this;
           next = this;
        }
    }
    public LinkedListDeque(){
        sentinel = new Node(null);
        size = 0;
    }

    @Override
    /* Add value to the beginning of the list*/
    public void addFirst(T value){
        Node temp = new Node(value);
        addAfter(sentinel,temp);
    }


    @Override
    /* Add value to the end of the list*/
    public void addLast(T value){
        Node temp = new Node(value);
        addAfter(sentinel.prev,temp);
    }

    private void addAfter(Node front, Node after){
        front.next.prev = after;
        after.next = front.next;
        front.next = after;
        after.prev = front;
        size+=1;
    }

    @Override
    /* Return true if the list is empty*/
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    /* Return the number of items in the deque*/
    public int size(){
       return size;
    }

    /** Prints the items in the deque from first to last,
     * separated by a space.
     * Once all the items hava been printed,
     * print out a new line.
     */

    public void printDeque(){
        int curLeft = size;
        Node temp = sentinel.next;
        while (curLeft>0){
            System.out.print(temp.item+" ");
            temp = temp.next;
            curLeft-=1;
        }
        System.out.print("\n");
    }

    @Override
    /*Removes the first element of the list
     * and return the element if exists otherwise return null*/
    public T removeFirst(){
        return removeAfter(sentinel,sentinel.next);
    }

    /**
     * Remove the last element of the list
     * and return the element if exists otherwise return null
     * @return return the last element or null if not existing.
     */
    public T removeLast(){
        return removeAfter(sentinel.prev.prev,sentinel.prev);
    }

    /**
     * Remove the after node which is actually in the
     * after place of the front IIF size is larger than 0.
     * and return the item of the after if exists otherwise return null
     *
     * @param front the front node.
     * @param after the after one node.
     */
    private T removeAfter(Node front, Node after){
        T result = null;
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
    public T get(int index){
       Node temp = sentinel.next;
       T result = null;
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


    /**
     * Get the item at the given index,
     * starting at 0.
     * If no such item exits, return null
     *
     * @return  return the item if it exists
     * otherwise return null.
     */
    public T getRecursive(int index){
        return getRecursivePrivate(index,sentinel);
    }

    private T getRecursivePrivate(int index, Node current){
           if (index == 0){
               return current.next.item;
           }
           current = current.next;
           return getRecursivePrivate(index-1,current);
    }
    @Override
    /* This method will return an iterator
     * which here is LinkedListed*/
    public Iterator<T> iterator(){
        return new DequeIterator();
    }

    @Override
    public boolean equals() {
        return false;
    }

    /** This class acts as iterator*/
    private class DequeIterator implements Iterator<T>{

        private Node current;

        public DequeIterator(){
            current = sentinel.next;
        }

        /** This method will return true if there exists next item*/
        @Override
        public boolean hasNext() {
            return current != sentinel;
        }

        @Override
        public T next() {
            if (! hasNext()){
                throw new NoSuchElementException();
            }
            T result = current.item;
            current = current.next;
            return result;
        }
    }


    @Override
    /* Return whether the parameter o is equal to the Deque.
     * @param o any type
     * @return return true only if o is Deque, and it contains the same content
     * in the same order.
     */
    public boolean equals(Object o){
        if (o == this) return true;
        if (o==null || (o.getClass() != this.getClass()) ) return false;

        LinkedListDeque<?> other = (LinkedListDeque<?>) o;
        if (other.size != this.size) return false;

        Iterator<?> it1 = other.iterator();
        Iterator<T> it2 = this.iterator();

        while (it1.hasNext()){
            Object elem1 =  it1.next();
            Object elem2 =  it2.next();

            if (elem1 != elem2) return false;
        }
        return true;
    }

}
