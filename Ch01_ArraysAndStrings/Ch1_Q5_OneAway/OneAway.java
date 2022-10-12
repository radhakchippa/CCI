//One Away: There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character. Given two strings, write a function to check if they are
//one edit (or zero edits) away.
//EXAMPLE
//pale, ple -> true
//pales. pale -> true
//pale. bale -> true
//pale. bake -> false

//one edit means only one character will differ and the rest characters will match.
//zero edit means both strings are same. no changes.
//Strings will either have same size or one String is 1 character more or 1 character less than the second string.

public class OneAway {

    public static int checkStrings(String big, String small){
        int edits = 0;
        for(int i = 0, j = 0; (i < big.length()) || (j < small.length()); /*no auto increments of i,j */){
            if(big.charAt(i) != small.charAt(j)) {  // need to do biggest String lenth of comparisions.
                edits++; i++;
            } else {
                i++; j++;
            }
        }
        return edits;
    } // pikeo pkio i=4 j=2 e=3

    public static int checkEqualStrings(String big, String small){
        int edits = 0;
        for(int i = 0; i<big.length();i++){   // order of n, need to do n comparisions.
            if(big.charAt(i) != small.charAt(i)) {
                edits++;
            }
        }
        return edits;
    } //bake pale  i=3, edits=2

    public static boolean checkOneEditAway{String first, String second}{
        if(first == null || second == null) return false;
        if(fist.length()==0 || second.length()==0) return false;
        if(first.length() - second.length() >= 2 ) return false;
        int edits = 0;
        if(first.length()==second.length()){
            edits = checkEqualStrings(first, second);
        }
        if(first.legth() > second.length()){
            edits = checkStrings(first, second);
        } else {
            edits = checkStrings(second, first);
        }
        return edits <= 1;
    }

    public static void main(String[] args) {
        System.out.println(checkOneEditAway("pale", "ple"));
        System.out.println(checkOneEditAway("pales","pale"));
        System.out.println(checkOneEditAway("pale","bale"));
        System.out.println(checkOneEditAway("pale","bake"));
    }
}
//Time Complexity: O(b)   Space Complexity O(1).