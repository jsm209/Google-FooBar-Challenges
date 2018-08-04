/*

En Route Salute (Google Foobar Level 3 Problem)

Commander Lambda loves efficiency and hates anything that wastes time. She's a busy lamb, after
all! She generously rewards henchmen who identify sources of inefficiency and come up with ways
to remove them. You've spotted one such source, and you think solving it will help you build the
reputation you need to get promoted.

Every time the Commander's employees pass each other in the hall, each of them must stop and salute
each other - one at a time - before resuming their path. A salute is five seconds long, so each
exchange of salutes takes a full ten seconds (Commander Lambda's salute is a bit, er, involved).
You think that by removing the salute requirement, you could save several collective hours of
employee time per day. But first, you need to show her how bad the problem really is.

Write a program that counts how many salutes are exchanged during a typical walk along a hallway.
The hall is represented by a string. For example: "--->-><-><-->-"

Each hallway string will contain three different types of characters: '>', an employee walking
to the right; '<', an employee walking to the left; and '-', an empty space. Every employee walks
at the same speed either to right or to the left, according to their direction. Whenever two
employees cross, each of them salutes the other. They then continue walking until they reach the
end, finally leaving the hallway. In the above example, they salute 10 times.

Write a function answer(s) which takes a string representing employees walking along a hallway
and returns the number of times the employees will salute. s will contain at least 1 and at most
100 characters, each one of -, >, or <.

 */

// INITIAL THOUGHT PROCESS:
// Take the string, and delete all the "-"
// For loop over the length of the string.
// The equation is "<" added up, then times two for every ">" counted.
// So go through, and look at each symbol.
// Front case of starting line with "<", since they will never salute anyone, so ignore them.
// If you run into "<", increment a counter.
// If you run into ">" increment a counter.
// If you run into "<" again, stop and add to the total salute count by doing above calculation, 
// then set "<" counter
// to zero, but keep ">" counter the same.
// <--<-->-->--<--<-->---->---<--->---<
// Actually retrospect this doesn't work when loop encounters ">" then "<", ending after one sign 
// change.
// Now deciding to take simple route to actually finish the program, by simply counting the amount
// of salutes per worker facing a certain direction... I will start from the left side.


// enRouteSalute will count the amount of salutes between workers, represented by the direction
// they're walking, or "<" and ">". It is assumed that they all travel at the same speed at the
// same time, with empty spaces in the hallway represented by "-". A salute occurs when two
// workers have to cross paths, where they both will do one salute each.

public class enRouteSalute {
   
   public static void main(String[] args) {
      System.out.println(totalSalutes("<--<-->-->--<--<-->---->---<--->---<"));
      System.out.println(totalSalutes("-<->><-->>-<<->->"));
      System.out.println(totalSalutes("-<-><-->-"));
      System.out.println(totalSalutes("--->-><-><-->-"));
   }
   
   // Pre: Given a String "saluteLine" that contains only the characters "<, >, -"
   // Post: Will return an integer representing the amount of salutes, which occurs whenever
   // two opposing arrows will cross each other.
   public static int totalSalutes(String saluteLine) {
      int count = 0;
      for (int i = 0; i < saluteLine.length(); i++) {
         if (saluteLine.charAt(i) == '>') {
            for (int j = i; j < saluteLine.length(); j++) {
               if (saluteLine.charAt(j) == '<') {
                  count += 1;
               }
            }
         }     
      }
      return count;
   }
}