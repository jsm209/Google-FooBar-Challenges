/*

Minion Task Scheduling (Google Foobar Level 1 Problem)

Commander Lambda's minions are upset! They're given the worst jobs on the whole space station, and some of them are 
starting to complain that even those worst jobs are being allocated unfairly. If you can fix this problem, it'll prove your chops 
to Commander Lambda so you can get promoted!

Minion's tasks are assigned by putting their ID numbers into a list, one time for each day they'll work on that task. As shifts 
are planned well in advance, the lists for each task will contain up to 99 integers. When a minion is scheduled for the same 
task too many times, they'll complain about it until they're taken off the task completely. Some tasks are worse than others, so 
the number of scheduled assignments before a minion will refuse to do a task varies depending on the task. You figure you 
can speed things up by automating the removal of the minions who have been assigned a task too many times before they 
even get a chance to start complaining.

Write a function called answer(data, n) that takes in a list of less than 100 integers and a number n, and returns that same list 
but with all of the numbers that occur more than n times removed entirely. The returned list should retain the same ordering 
as the original list - you don't want to mix up those carefully planned shift rotations! For instance, if data was [5, 10, 15, 10, 7] 
and n was 1, answer(data, n ) would return the list [5, 15, 7] because 10 occurs twice, and was thus removed from the list entirely.

*/

import java.util.*;

public class scheduling {
   
   public static void main(String[] args) {
      int[] list1 = answer(new int[]{1, 2, 3}, 0);
      int[] list2 = answer(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5}, 1);
      int[] list3 = answer(new int[]{1, 2, 3}, 6);
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
   
   // Pre: Given an array of integers and a value "num" of type integer,
   // Post: Will remove the values from the array that have a greater number
   // of occurences in the array than the given value "num", returning
   // a new array with these values removed. 
   public static int[] answer(int[] data, int num) {
      int i = 0;
      while(i < data.length) {
         if (count(data, data[i]) > num) {
            data = removeValue(data, data[i]);
         } else {
            i++;   
         }
      }
      return data;
   }
   
   // Pre: Given an array of integers and a value "num" of type integer,
   // Post: Returns an integer that represents the amount of occurences
   // the given "num" was found in the array.
   public static int count(int[] data, int num) {
      int count = 0;
      for (int i = 0; i < data.length; i++) {
         if (data[i] == num) {
            count++;
         }
      }
      return count;
   }
   
   // Pre: Given an array of integers and a value "num" of type integer,
   // Post: Will return a new array that maintains the same order and content
   // of the original given array, except any value that matches the given "num"
   // will be removed.
   public static int[] removeValue(int[] data, int num) {
      int newSize = data.length - count(data, num);
      int[] newArray = new int[newSize];
      int current = 0;
      for (int i = 0; i < data.length; i++) {
         if (data[i] != num) {
            newArray[current] = data[i];
            current++;
         }
      }
      return newArray;
   }
}