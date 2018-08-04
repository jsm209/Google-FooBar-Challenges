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

// Take the string, and delete all the "-"
// For loop over the length of the string.
// The equation is "<" added up, then times two for every ">" counted.
// So go through, and look at each symbol.
// Front case of starting line with "<", since they will never salute anyone, so ignore them.
// If you run into "<", increment a counter.
// If you run into ">" increment a counter.
// If you run into "<" again, stop and add to the total salute count by doing above calculation, then set "<" counter
// to zero, but keep ">" counter the same.
// <--<-->-->--<--<-->---->---<--->---<
// Actually retrospect this doesn't work when loop encounters ">" then "<", ending after one sign change.

public class enRouteSalute {

    public static void main(String[] args) {
        System.out.println(totalSalutes("<--<-->-->--<--<-->---->---<--->---<"));
        System.out.println(totalSalutes("-<->><-->>-<<->->"));



    }

    public static String format(String s) {
        s = s.replace("-", "");
        int i = 0;
        while (s.charAt(i) == '<') {
            i++;
        }
        return s.substring(i);
    }

    public static int calculateSalutes(int right, int left) {
        return right * left * 2;
    }

    public static int totalSalutes(String saluteLine) {
        saluteLine = format(saluteLine);
        int right = 0;
        int left = 0;
        int totalSalutes = 0;
        boolean encounteredLeft = false;
        for (int i = 0; i < saluteLine.length(); i++) {
            if (saluteLine.charAt(i) == '>') {
                right++;
                if (encounteredLeft) {
                    totalSalutes += calculateSalutes(right, left);
                    left = 0;
                    encounteredLeft = false;
                }
            } else { // ran into <
                left++;
                encounteredLeft = true;
            }

        }
        //totalSalutes += calculateSalutes(right, left);
        return totalSalutes;
    }
}