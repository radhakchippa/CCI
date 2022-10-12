package cci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class PermutationsClass{
    public static boolean compare(String st1, String st2){
        if(st1== null || st2 == null) return false;
        if(st1.length() != st2.length()) return false;
        char[] stchr1 = st1.toCharArray();
        char[] stchr2 = st2.toCharArray();
        Arrays.sort(stchr1);
        Arrays.sort(stchr2);
        if((new String(stchr1)).equalsIgnoreCase(new String(stchr2))){
            return true;
        }
        return false;
    }

    public static Map<Character, Integer> freqMap(String string){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<string.length();i++){
            if(map.containsKey(String.charAt(i))){
                map.put(string.charAt(i), map.get(string.charAt(i))+1);
            } else {
                map.put(string.charAt(i), 1);
            }
        }
        return map;
    }

    public static boolean comparePermutations(String st1, String st2){
        if(st1 == null || st2 == null) return false;
        if(st1.length() != st2.length()) return false;
         Map<Character, Integer> map1 = freqMap(st1);
         Map<Character, Integer> map2 = freqMap(st2);
         for(Character x: map1.keySet()){
             if(map2.get(x) != map1.get(x))
                 return false;
         }
         return true;
    }

    public static void main(String[] args){
        System.out.println(compare(null, "null"));
        System.out.println(comparePermutations("p1qdefag", new String()));
    }
}