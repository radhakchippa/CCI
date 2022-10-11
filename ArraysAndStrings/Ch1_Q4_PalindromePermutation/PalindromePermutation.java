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


    public static void main(String[] args) {
        System.out.println("Tact Coa" + checkPermutationOfPalindrome("Tact Coa "));
        System.out.println("This is Thee" + checkPermutationOfPalindrome("This is Thee"));
        System.out.println("this is three"+ checkPermutationOfPalindrome("this is three"));
        System.out.println(" "+checkPermutationOfPalindrome(" "));
        System.out.println(null + checkPermutationOfPalindrome(null));
    }
}