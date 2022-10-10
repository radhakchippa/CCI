package cci;

//URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
//has sufficient space at the end to hold the additional characters, and that you are given the "true"
//length of the string.  (Note: If implementing in java, please use a character array so that you can
//perform this operation in place.)

public class UrlifyClass {
    public static void moveToRight(char[] chars, int startIndex, int spaces){
        for(int i=0;i<spaces;i++){
            startIndex = startIndex + i;
            for(int las = chars.length -2; last > startIndex; last--){
                chars[last+1] = chars[last];
            }
        }
    }

    public static int replaceSpaces(char[] chars, int current){
        chars[current] = '%';
        chars[current+1] = '2';
        chars[current+2] = '0';
        return current+2;
    }

    public static string urlify(String string){
        if(string == null || string.length() <2)
            return "Invalid Input";
        //find first space, move the remianing characters after space to the right and create two spaces
        //replace the 3 spaces created in the string with '%20' and continue replacing for next space.
        char[] chars = string.toCharArray();
        for(int i=0; i<chars.length;i++){
            if(chars[i] == ' ') { // check for space, otherwise continue.
                moveToRight(chars, i, 2);
                i = replaceSpaces(chars, i);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(urlify("   "));
        System.out.println(urlify("This is awesome    "));
        System.out.println(urlify(""));
        System.out.println(urlify(null));
        System.out.println(urlify(" Hello  "));
    }
}