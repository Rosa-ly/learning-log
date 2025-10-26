package csu22011_a2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @author
 * @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0,1);
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(10,1);
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(-10,1);
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }

    // ----------------------------------------------------------
    /**
     * Check if isEmpty works
     */
    @Test
    public void testIsEmpty()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        assertTrue("Checking isEmpty on empty list", testDLL.isEmpty());

        testDLL.insertBefore(0, 1);
        assertFalse("Checking isEmpty on non-empty list", testDLL.isEmpty());

        testDLL.deleteAt(0);
        assertTrue("Checking isEmpty after deleting all elements", testDLL.isEmpty());
    }

    // ----------------------------------------------------------
    /**
     * Check if get works
     */
    @Test
    public void testGet()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        // test empty list
        assertNull("Checking get on empty list", testDLL.get(0));

        // build list: 1,2,3,4,5
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(3, 4);
        testDLL.insertBefore(4, 5);

        // test valid positions
        assertEquals("Checking get at position 0", Integer.valueOf(1), testDLL.get(0));
        assertEquals("Checking get at position 2", Integer.valueOf(3), testDLL.get(2));
        assertEquals("Checking get at position 4", Integer.valueOf(5), testDLL.get(4));

        // test invalid positions
        assertNull("Checking get at negative position", testDLL.get(-1));
        assertNull("Checking get at position beyond list size", testDLL.get(10));
    }

    // ----------------------------------------------------------
    /**
     * Check if deleteAt works
     */
    @Test
    public void testDeleteAt()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        // test empty list
        assertFalse("Checking deleteAt on empty list", testDLL.deleteAt(0));

        // build list: 1,2,3,4,5
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(3, 4);
        testDLL.insertBefore(4, 5);

        // test delete at head
        assertTrue("Checking deleteAt position 0", testDLL.deleteAt(0));
        assertEquals("Checking list after deleting head", "2,3,4,5", testDLL.toString());

        // test delete in middle
        assertTrue("Checking deleteAt position 1", testDLL.deleteAt(1));
        assertEquals("Checking list after deleting middle element", "2,4,5", testDLL.toString());

        // test delete at tail
        assertTrue("Checking deleteAt last position", testDLL.deleteAt(2));
        assertEquals("Checking list after deleting tail", "2,4", testDLL.toString());

        // test delete invalid positions
        assertFalse("Checking deleteAt negative position", testDLL.deleteAt(-1));
        assertFalse("Checking deleteAt position beyond list size", testDLL.deleteAt(10));

        // delete remaining elements
        testDLL.deleteAt(0);
        testDLL.deleteAt(0);
        assertTrue("Checking list is empty after deleting all elements", testDLL.isEmpty());
    }

    // ----------------------------------------------------------
    /**
     * Check if size works
     */
    @Test
    public void testSize()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        // test empty list
        assertEquals("Checking size of empty list", 0, testDLL.size());

        // add elements
        testDLL.insertBefore(0, 1);
        assertEquals("Checking size after adding 1 element", 1, testDLL.size());

        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        assertEquals("Checking size after adding 3 elements total", 3, testDLL.size());

        // delete element
        testDLL.deleteAt(1);
        assertEquals("Checking size after deleting 1 element", 2, testDLL.size());

        // delete all
        testDLL.deleteAt(0);
        testDLL.deleteAt(0);
        assertEquals("Checking size after deleting all elements", 0, testDLL.size());
    }

    // ----------------------------------------------------------
    /**
     * Check if isSet works
     */
    @Test
    public void testIsSet()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        // test empty list
        assertTrue("Checking isSet on empty list", testDLL.isSet());

        // test list with unique elements
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        assertTrue("Checking isSet on list with unique elements", testDLL.isSet());

        // test list with duplicates
        testDLL.insertBefore(3, 2);  // duplicate 2
        assertFalse("Checking isSet on list with duplicate elements", testDLL.isSet());

        // test single element
        testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0, 1);
        assertTrue("Checking isSet on single element list", testDLL.isSet());
    }

    // ----------------------------------------------------------
    /**
     * Check if contains works
     */
    @Test
    public void testContains()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        // test empty list
        assertFalse("Checking contains on empty list", testDLL.contains(1));

        // build list: 1,2,3,4,5
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(3, 4);
        testDLL.insertBefore(4, 5);

        // test elements in list
        assertTrue("Checking contains for element at head", testDLL.contains(1));
        assertTrue("Checking contains for element in middle", testDLL.contains(3));
        assertTrue("Checking contains for element at tail", testDLL.contains(5));

        // test elements not in list
        assertFalse("Checking contains for element not in list", testDLL.contains(10));
        assertFalse("Checking contains for negative element", testDLL.contains(-1));


    }
    

    // ----------------------------------------------------------
    /**
     * Check if intersection works
     */
    @Test
    public void testIntersection()
    {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

        // test two empty lists
        DoublyLinkedList<Integer> result = list1.intersection(list2);
        assertEquals("Checking intersection of two empty lists", "", result.toString());

        // test first list empty
        list2.insertBefore(0, 1);
        list2.insertBefore(1, 2);
        result = list1.intersection(list2);
        assertEquals("Checking intersection with first list empty", "", result.toString());

        // test second list empty
        list1.insertBefore(0, 1);
        list1.insertBefore(1, 2);
        list2 = new DoublyLinkedList<>();
        result = list1.intersection(list2);
        assertEquals("Checking intersection with second list empty", "", result.toString());

        // test with null
        result = list1.intersection(null);
        assertEquals("Checking intersection with null list", "", result.toString());

        // test normal intersection
        // list1: 1,2,3,4,5
        // list2: 2,4,6
        list1 = new DoublyLinkedList<>();
        list2 = new DoublyLinkedList<>();
        list1.insertBefore(0, 1);
        list1.insertBefore(1, 2);
        list1.insertBefore(2, 3);
        list1.insertBefore(3, 4);
        list1.insertBefore(4, 5);

        list2.insertBefore(0, 2);
        list2.insertBefore(1, 4);
        list2.insertBefore(2, 6);

        result = list1.intersection(list2);
        assertEquals("Checking intersection of [1,2,3,4,5] and [2,4,6]", "2,4", result.toString());

        // test no common elements
        list1 = new DoublyLinkedList<>();
        list2 = new DoublyLinkedList<>();
        list1.insertBefore(0, 1);
        list1.insertBefore(1, 2);
        list2.insertBefore(0, 3);
        list2.insertBefore(1, 4);

        result = list1.intersection(list2);
        assertEquals("Checking intersection with no common elements", "", result.toString());

        // test with duplicates in first list
        // list1: 1,2,3,2,4 (2 appears twice)
        // list2: 2,4,5
        // result should be: 2,4 (each appearing once)
        list1 = new DoublyLinkedList<>();
        list2 = new DoublyLinkedList<>();
        list1.insertBefore(0, 1);
        list1.insertBefore(1, 2);
        list1.insertBefore(2, 3);
        list1.insertBefore(3, 2);  // duplicate
        list1.insertBefore(4, 4);

        list2.insertBefore(0, 2);
        list2.insertBefore(1, 4);
        list2.insertBefore(2, 5);

        result = list1.intersection(list2);
        assertEquals("Checking intersection preserves set property (no duplicates)", "2,4", result.toString());
        assertTrue("Checking result is a set", result.isSet());

        // test all elements common
        list1 = new DoublyLinkedList<>();
        list2 = new DoublyLinkedList<>();
        list1.insertBefore(0, 1);
        list1.insertBefore(1, 2);
        list1.insertBefore(2, 3);

        list2.insertBefore(0, 1);
        list2.insertBefore(1, 2);
        list2.insertBefore(2, 3);

        result = list1.intersection(list2);
        assertEquals("Checking intersection when all elements are common", "1,2,3", result.toString());
    }

    // ----------------------------------------------------------
    /**
     * Check if toString works
     */
    @Test
    public void testToString()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        // test empty list
        assertEquals("Checking toString on empty list", "", testDLL.toString());

        // test single element
        testDLL.insertBefore(0, 1);
        assertEquals("Checking toString on single element list", "1", testDLL.toString());

        // test multiple elements
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        assertEquals("Checking toString on multiple element list", "1,2,3", testDLL.toString());
    }

    // ----------------------------------------------------------
    /**
     * Additional edge case tests
     */
    @Test
    public void testEdgeCases()
    {
        DoublyLinkedList<String> testDLL = new DoublyLinkedList<>();

        // test with String type
        testDLL.insertBefore(0, "A");
        testDLL.insertBefore(1, "B");
        testDLL.insertBefore(2, "C");
        assertEquals("Checking DoublyLinkedList with String type", "A,B,C", testDLL.toString());

        // test multiple deletions
        testDLL.deleteAt(1);
        assertEquals("After deleting middle element", "A,C", testDLL.toString());

        // test get on String list
        assertEquals("Checking get on String list", "A", testDLL.get(0));
        assertEquals("Checking get on String list", "C", testDLL.get(1));
    }
}