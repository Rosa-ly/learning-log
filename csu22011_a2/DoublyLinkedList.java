package csu22011_a2;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 13/10/25
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated string of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; 
        public DLLNode next;
        public DLLNode prev;
    
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    private DLLNode head, tail;
    private int size = 0;

    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
      size = 0;
    }

    public boolean isEmpty()
    {
      return size == 0;
    }

    public void insertBefore( int pos, T data ) 
    {
      if (data == null) return;

      DLLNode newNode;

      // Empty list
      if (isEmpty()) {
        newNode = new DLLNode(data, null, null);
        head = tail = newNode;
        size++;
        return;
      }

      // Insert at head
      if (pos <= 0) {
        newNode = new DLLNode(data, null, head);
        head.prev = newNode;
        head = newNode;
        size++;
        return;
      }

      // Insert at end
      if (pos >= size) {
        newNode = new DLLNode(data, tail, null);
        tail.next = newNode;
        tail = newNode;
        size++;
        return;
      }

      // Insert in middle
      DLLNode current = head;
      for (int i = 0; i < pos; i++) {
        current = current.next;
      }
      newNode = new DLLNode(data, current.prev, current);
      current.prev.next = newNode;
      current.prev = newNode;
      size++;
    }

    public T get(int pos) 
    {
      if (pos < 0 || pos >= size) return null;

      DLLNode current = head;
      for (int i = 0; i < pos; i++) {
        current = current.next;
      }
      return current.data;
    }

    public boolean deleteAt(int pos) 
    {
      if (pos < 0 || pos >= size) return false;

      DLLNode current = head;
      for (int i = 0; i < pos; i++) {
        current = current.next;
      }

      // Single element
      if (size == 1) {
        head = tail = null;
      }
      // Delete head
      else if (current == head) {
        head = head.next;
        head.prev = null;
      }
      // Delete tail
      else if (current == tail) {
        tail = tail.prev;
        tail.next = null;
      }
      // Delete middle
      else {
        current.prev.next = current.next;
        current.next.prev = current.prev;
      }

      size--;
      return true;
    }

    public int size()
    {
      return size;
    }

    public boolean isSet()
    {
      if (isEmpty()) return true;

      for (DLLNode outer = head; outer != null; outer = outer.next) {
        for (DLLNode inner = outer.next; inner != null; inner = inner.next) {
          if (outer.data.compareTo(inner.data) == 0) {
            return false;
          }
        }
      }
      return true;
    }

    public boolean contains(T element)
    {
      for (DLLNode current = head; current != null; current = current.next) {
        if (current.data.compareTo(element) == 0)
          return true;
      }
      return false;
    }

    public DoublyLinkedList<T> intersection(DoublyLinkedList<T> other)
    {
      DoublyLinkedList<T> result = new DoublyLinkedList<>();

      if (other == null || this.isEmpty() || other.isEmpty())
        return result;

      for (DLLNode current = head; current != null; current = current.next) {
        if (other.contains(current.data) && !result.contains(current.data)) {
          result.insertBefore(result.size(), current.data);
        }
      }
      return result;
    }

    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }

}
