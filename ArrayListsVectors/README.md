## Arrays
- String questions and Arrays questions can be interchanged
- Length of array: array.length **|** Length of string: string.length();
    ```
    int[] intAry = new int[10];
    System.out.println("size of array",+intAry.length);  
    // Notice no parenthesis in array length.
    //There is **no size() method** available with the array. 
    //But there is a length field available in the array that can be used to find the length or size of the array.
    //array.length: length is a final variable applicable for arrays. With the help of the length variable, 
    //we can obtain the size of the array.

    String sample="hello World";
    System.out.println("size of String",+ sample.length());
    //Notice parenthesis in String length function.
    //string.length() : length() method is a final variable which is applicable for string objects. 
    //The length() method returns the number of characters present in the string.
    ```
## ArrayList / Resizeable Array
In some languages, arrays (often called lists in this case) are automatically resizable. The array or list will
grow as you append items. In other languages, like Java, arrays are fixed length. The size is defined when
you create the array.
When you need an array-like data structure that offers dynamic resizing, you would usually use an ArrayList.
An ArrayList is an array that resizes itself as needed while still providing O( 1) access. A typical implementation
is that when the array is full, the array doubles in size. Each doubling takes 0 (n) time, but happens so
rarely that its amortized insertion time is still 0 (1).
 ```
  ArrayList<String> merge(String[] words , String[] more) {
     ArrayList<String> sentence = new ArrayList<String>();
     for (String w : words) sentence.add(w);
     for (String w : more) sentence.add(w);
     return sentence;
   }
 ```
This is an essential data structure for interviews. Be sure you are comfortable with dynamically resizable
arrays/lists in whatever language you will be working with. Note that the name of the data structure as well
as the "resizing factor" (which is 2 in Java) can vary.

## Why is the amortized insertion runtime 0(1)?
Suppose you have an array of size N. We can work backwards to compute how many elements we copied
at each capacity increase. Observe that when we increase the array to K elements, the array was previously
half that size. Therefore, we needed to copy K/2 elements.
  final capacity increase : n/2 elements to copy
  previous capacity increase: n/4 elements to copy
  previous capacity increase : n/8 elements to copy
  previous capacity increase: n/16 elements to copy
  ...
  ...
  ...
  second capacity increase 2 elements to copy
  first capacity increase 1 element to copy
Therefore, the total number of copies to insert N elements is roughly ~ + X +X/2 + X/4 + ..  + 2 +1, 
which is just less than N. If the sum of this series isn't obvious to you, 
imagine this: Suppose you have a kilometer-long walk to the store. You walk 0.5 kilometers, and then 0.25 kilometers, and then 0.125 kilometers,
and so on. You will never exceed one kilometer (although you'll get very close to it).
Therefore, inserting N elements takes O(N) work total. Each insertion is 0(1) on average, even though
some insertions take 0 (N) time in the worst case.
