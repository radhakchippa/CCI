//Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
//A palindrome is a word or phrase that is the same forwards and backwards. A permutation
//is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
//EXAMPLE
//Input: Tact Coa
//Output: True (permutations: "taco cat". "atco cta". etc.)

public class PalindromePermutation {
    //hints: word or phrase -- spaces are allowed and can be ignored in determining palindrome.
    //palindorme means the word is same even if reversed.[first half of characters match with second half of characters]
    // idea-1: count the number of times word occurs, we can have atmost 1 word with odd occurrences and reamining
    //all will be even occurrences. // ignoring case for this example.
    // Can use HashMap and keep counter. check for single odd frequency or all even frequencies then palindrome,
    // otherwise not possible. solution Time O(n), solution Space O(n)
    // idea-2 : use BitVector/ BitSet api in Java, could be done in time: O(n), space: O(1).
    public static boolean checkPermutationOfPalindrome(String string){
        if(string == null || string.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        char ch;
        for(int i=0;i<string.length();i++){
            ch = Character.toLowerCase(string.charAt(i));
            //if space continue;
            if(ch == ' ')
                continue;

            if(map.cotainsKey(ch)){
                map.put( ch , map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }

        int odds = 0;
        for(Character x:map.keySet()){
            if( (map.get(x)%2) == 1){
                odds++;
            }
        }
        if(odds >= 2)   return false;

        return true;
    }

    //Use bitVector, assume a-z characters only  -- how many bits we have to set ? do you ask what is the character set ?
    public static boolean isPermutationOfPalindrome(String phrase){
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }
    /*
    Create a bit vector for the string, For each letter with value i, toggle the ith bit.
     */
    public static int createBitVector(String phrase){
        int bitVector = 0;
        for(char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }
    /*
    Toggle the ith bit in the integer.
     */
    public static int toggle(int bitVector, int index){
        if(index <0) return bitVector;
        int mask = 1 << index;
        if((bitVector & mask) == 0){
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }
    // check that exactly one bit is set by subtracting one from the interger and
    // AND'ing it with the original Integer.
    /*
    Picture an integer like 00010000. We could of course shift the integer repeatedly to check that there's only
    a single 1. Alternatively, if we subtract 1 from the number, we'll get 00001111. What's notable about this
    is that there is no overlap between the numbers (as opposed to say 00101000, which, when we subtract 1
    from, we get 00100111.) So, we can check to see that a number has exactly one 1 because if we subtract 1
    from it and then AND it with the new number, we should get 0.
    00010000 - 1 = 00001111
    00010000 & 00001111 = 0
     */
    public static boolean checkExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println("Tact Coa" + checkPermutationOfPalindrome("Tact Coa "));
        System.out.println("This is Thee" + checkPermutationOfPalindrome("This is Thee"));
        System.out.println("this is three"+ checkPermutationOfPalindrome("this is three"));
        System.out.println(" "+checkPermutationOfPalindrome(" "));
        System.out.println(null + checkPermutationOfPalindrome(null));

        System.out.println("Tact Coa" + isPermutationOfPalindrome("Tact Coa "));
        System.out.println("This is Thee" + isPermutationOfPalindrome("This is Thee"));
        System.out.println("this is three"+ isPermutationOfPalindrome("this is three"));
    }
}