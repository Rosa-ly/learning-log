package csu22011_a1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 03/10/22 22:33:19
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */

    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear with 3 empty arrays should return zero",     expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast with 3 empty arrays should return zero", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }
    @Test
    public void testCountCollinearSingleElement() {
        int[] a1 = {1};
        int[] a2 = {2};
        int[] a3 = {3};
      }
    
    @Test
    public void testCountCollinearWithCollinearPoints() {

        int[] a1 = {1, 2, 3};
        int[] a2 = {2, 3, 4};
        int[] a3 = {3, 4, 5};
   }
    
    @Test
    public void testCountCollinearNoCollinearPoints() {
        int[] a1 = {1, 5, 9};
        int[] a2 = {2, 6, 10};
        int[] a3 = {4, 8, 12};
        assertEquals("Should find no collinear points", 0, Collinear.countCollinear(a1, a2, a3));
    }
    @Test
    public void testBinarySearchEmpty() {
        int[] a = {};
        assertFalse("Searching in empty array should return false", Collinear.binarySearch(a, 5));
    }
    
    @Test
    public void testBinarySearchSingleElementFound() {
        int[] a = {5};
        assertTrue("Should find element in single-element array", Collinear.binarySearch(a, 5));
    }
    
    @Test
    public void testBinarySearchSingleElementNotFound() {
        int[] a = {5};
        assertFalse("Should not find different element", Collinear.binarySearch(a, 3));
    }
    
    @Test
    public void testBinarySearchFoundAtBeginning() {
        int[] a = {1, 2, 3, 4, 5};
        assertTrue("Should find element at beginning", Collinear.binarySearch(a, 1));
    }
    
    @Test
    public void testBinarySearchFoundAtEnd() {
        int[] a = {1, 2, 3, 4, 5};
        assertTrue("Should find element at end", Collinear.binarySearch(a, 5));
    }
    
    @Test
    public void testBinarySearchFoundInMiddle() {
        int[] a = {1, 2, 3, 4, 5};
        assertTrue("Should find element in middle", Collinear.binarySearch(a, 3));
    }
    
    @Test
    public void testBinarySearchNotFoundLessThanAll() {
        int[] a = {1, 2, 3, 4, 5};
        assertFalse("Should not find element less than all", Collinear.binarySearch(a, 0));
    }
    
    @Test
    public void testBinarySearchNotFoundGreaterThanAll() {
        int[] a = {1, 2, 3, 4, 5};
        assertFalse("Should not find element greater than all", Collinear.binarySearch(a, 10));
    }
    
    @Test
    public void testBinarySearchNotFoundInMiddle() {
        int[] a = {1, 3, 5, 7, 9};
        assertFalse("Should not find element between others", Collinear.binarySearch(a, 4));
    }
    
    @Test
    public void testBinarySearchWithNegatives() {
        int[] a = {-5, -3, -1, 0, 2, 4};
        assertTrue("Should find negative number", Collinear.binarySearch(a, -3));
        assertFalse("Should not find missing negative number", Collinear.binarySearch(a, -2));
    }
    
    @Test
    public void testBinarySearchLargeArray() {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i * 2;
        }
        assertTrue("Should find element in large array", Collinear.binarySearch(a, 50));
        assertFalse("Should not find odd number in even array", Collinear.binarySearch(a, 51));
    }
    
    @Test
    public void testSortEmpty() {
        int[] a = {};
        Collinear.sort(a);
        assertArrayEquals("Empty array should remain empty", new int[]{}, a);
    }
    
    @Test
    public void testSortSingleElement() {
        int[] a = {5};
        Collinear.sort(a);
        assertArrayEquals("Single element array should remain unchanged", new int[]{5}, a);
    }
    
    @Test
    public void testSortAlreadySorted() {
        int[] a = {1, 2, 3, 4, 5};
        Collinear.sort(a);
        assertArrayEquals("Already sorted array", new int[]{1, 2, 3, 4, 5}, a);
    }
    
    @Test
    public void testSortReverseSorted() {
        int[] a = {5, 4, 3, 2, 1};
        Collinear.sort(a);
        assertArrayEquals("Reverse sorted array", new int[]{1, 2, 3, 4, 5}, a);
    }
    
    @Test
    public void testSortUnsorted() {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6};
        Collinear.sort(a);
        assertArrayEquals("Unsorted array", new int[]{1, 1, 2, 3, 4, 5, 6, 9}, a);
    }
    
    @Test
    public void testSortWithNegatives() {
        int[] a = {-5, 3, -1, 0, 2, -3};
        Collinear.sort(a);
        assertArrayEquals("Array with negative numbers", new int[]{-5, -3, -1, 0, 2, 3}, a);
    }
    
    @Test
    public void testSortWithDuplicates() {
        int[] a = {4, 2, 4, 1, 2, 3};
        Collinear.sort(a);
        assertArrayEquals("Array with duplicates", new int[]{1, 2, 2, 3, 4, 4}, a);
    }
    
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       
        int[] a2 = { 5 };       
        int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }

    @Test
    public void testMultipleTrue()
    {
    	int[] a1 = { 45, 49, 69, 112, 129, 136, 185, 186, 194, 196, 215, 226, 267, 268, 281, 307, 320, 339, 375, 386, 392, 443, 450, 504, 549, 639, 641, 679, 705, 760, 786, 792, 795, 823, 854, 913, 918, 931, 943, 959};
    	int[] a2 = { 66, 70, 75, 105, 111, 155, 181, 247, 260, 264, 289, 318, 334, 350, 384, 399, 407, 422, 495, 499, 538, 552, 557, 611, 621, 724, 747, 767, 799, 802, 813, 841, 853, 856, 868, 889, 905, 907, 943, 962};
        int[] a3 = { 1, 36, 91, 113, 165, 166, 193, 273, 286, 290, 306, 307, 371, 418, 430, 442, 469, 477, 481, 491, 528, 546, 558, 573, 595, 602, 614, 615, 644, 688, 778, 789, 883, 894, 895, 912, 926, 954, 978, 1000};

        int expectedResult = 27;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }
   

    // TODO: write more tests here to cover 100% of the instructions and the branches of Collinear.java

}
