/*

Numbers Station Coded Messages (Google Foobar Level 2 Problem)

When you went undercover in Commander Lambda's organization, you set up a coded messaging system with Bunny 
Headquarters to allow them to send you important mission updates. Now that you're here and promoted to Henchman, you 
need to make sure you can receive those messages - but since you need to sneak them past Commander Lambda's spies, it 
won't be easy!

Bunny HQ has secretly taken control of two of the galaxy's more obscure numbers stations, and will use them to broadcast 
lists of numbers. They've given you a numerical key, and their messages will be encrypted within the first sequence of 
numbers that adds up to that key within any given list of numbers.

Given a non-empty list of positive integers l and a target positive integer t, write a function answer(l, t) which verifies if there is 
at least one consecutive sequence of positive integers within the list l (i.e. a contiguous sub-list) that can be summed up to 
the given target positive integer t (the key) and returns the lexicographically smallest list containing the smallest start and end 
indexes where this sequence can be found, or returns the array [-1, -1] in the case that there is no such sequence (to throw off 
Lambda's spies, not all number broadcasts will contain a coded message).

For example, given the broadcast list l as [4, 3, 5, 7, 8] and the key t as 12, the function answer(l, t) would return the list [0, 2] 
because the list l contains the sub-list [4, 3, 5] starting at index 0 and ending at index 2, for which 4 + 3 + 5 = 12, even though 
there is a shorter sequence that happens later in the list (5 + 7). On the other hand, given the list l as [1, 2, 3, 4] and the key t 
as 15, the function answer(l, t) would return [-1, -1] because there is no sub-list of list l that can be summed up to the given 
target value t = 15.

To help you identify the coded broadcasts, Bunny HQ has agreed to the following standards:

- Each list l will contain at least 1 element but never more than 100.
- Each element of l will be between 1 and 100.
- t will be a positive integer, not exceeding 250.
- The first element of the list l has index 0.
- For the list returned by answer(l, t), the start index must be equal or smaller than the end index.

Remember, to throw off Lambda's spies, Bunny HQ might include more than one contiguous sublist of a number broadcast 
that can be summed up to the key. You know that the message will always be hidden in the first sublist that sums up to the 
key, so answer(l, t) should only return that sublist.

*/

// Get two pointers, start them at the same index of the array.

// If the total of the values in the subArray of the array where the two pointers are 
// endpoints is less than the key, then move the front endpoint forward.

// Check subArray again, if the total of the values in the subArray exceeds the key,
// then move the first pointer forward one index.

// if the pointers both end up at the end of the array (they both equal the array length-1)
// then return {-1, -1}

// if the array is empty to begin with, return {-1, -1}


import java.util.*;

public class Decode {

   public static void main(String[] args) {
      int[] list1 = answer(new int[]{4, 3, 10, 2, 8}, 12);
      int[] list2 = answer(new int[]{1, 2, 3, 4}, 15);
      int[] list3 = answer(new int[]{1}, 1);
      printArray(list1);
      printArray(list2);
      printArray(list3);
   }
   
   private static void printArray(int[] data) {
      System.out.print("[");
      for (int i = 0; i < data.length; i++) {
         System.out.print(data[i] + " ");
      }
      System.out.println("]");
   } 


   ////////////
   //SOLUTION//
   ////////////

   // Pre: Given an array of integers and a value "key" of type integer,
   // Post: Will check the given array for a section of the array whose consecutive values
   // add up to the given key. It will return an array of two values, where the first
   // value is the start index (inclusive) and the second value is the end index (inclusive)
   // of the valid section of the array. If no valid section of the array is found, then
   // an array where both indexes are -1 will be returned.
   // NTFS: The two pointers "inchworm" across the data, adjusting itself accordingly.
   // If what the pointers contain are less than the key, the front move forward. If it is
   // less then the back moves forwards. It will stop when it reaches the key or none at all.
   public static int[] answer(int[] data, int key) {
      int front = 0;
      int back = 0;
      int[] currentArray = Arrays.copyOfRange(data, front, back);
      int total = totalArray(currentArray);
      while (total != key) {
         if (data.length == 0 || back == data.length) {
            return new int[]{-1, -1};
         } else if (total < key) {
            back++;
         } else {
            front++;   
         }
         currentArray = Arrays.copyOfRange(data, front, back);
         total = totalArray(currentArray);
      }
      return new int[]{front, back - 1};  // The -1 is because the last index is exclusive.
   }
   
   // Pre: Given an array of integers,
   // Post: Will find the sum of the integers in the given array.
   public static int totalArray(int[] data) {
      int total = 0;
      for (int i = 0; i < data.length; i++) {
         total += data[i];
      }
      return total;
   }
}