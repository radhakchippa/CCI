### Big O 
BigO notation is to get the tightest description of the runtime. In otherwords we try to provide and closest possible runtime estimate not an upperbound or a lowerbound.
We always use BigO to define the runtime close to upperbound.

## Best/Worst/Expected case and Big O/theta/Omega mean?
Actually there is no defined relation between the concepts. 
Best, Worst, and expected cases describe the big O (or big theta) time for particular inputs or scenarios.
Big O, big omega and big theta describe the upper, lower and tight bounds for the runtime.

## Rules for BigO calculations.
1. Drop the constants.
   - It is very possible for O(N) code to run faster than O(1) code for specific inputs. 
   - Big O just describes the rate of increase.  For this reason, we drop the constants in runtime. 
   - An algorithm that one might have described as O(2N) is actually O(N).
   - Big O allows us to express how the runtime scales. We just need to accept that it doesn't mena that O(N) is always better than O(N^2)

2. Drop the Non-Dominant Terms.
   - What do you do about an expression such as O(N^2 + N) ?  That second N isn't exactly a constant. But it's not especially important.
   - We already said that we drop constants. Therefore O(N^2 + N^2) would be O(N^2). If we don't care about that latter N^2 term, why would we care about N? **We don't.**
   - You should drop the non-dominant terms.
      - O(N^2 +N) becomes O(N^2).
      - O(N + logN) becomes O(N).
      - O(5*2^N)+1000N^100) becomes O(2^N).
      - We might still have a sum in a runtime. For example, experssion O(B^2+A) cannot be reduced without special knowledge of A and B.

3. Multi-part Algorithms: Add vz Multiply.
   - **ADD** If your algorithm is in the form, " do this, then, When you're all done, do that" then you add the runtimes.
        ``` for(... N times) {... all done!! ... }
        then, do next step 
        for(...M times) {.... all done second step..} ``` 
        Big O will be sum of both steps. as O(N + M).
        
   - **Multiply** If your algorithm is in the form "do this for each time you do that" then you multiple the runtimes.
        ``` for(....N times) {
            for(...M times) { for each time in N, we do M times this work } ``` 
        Big O will be Multiply both steps, as O(N * M ).
        
4. Amortized Time
   - An arrayList is implemented with an array. When the array hits capacity, the ArrayList class will create a new array with double the capacity and copy all the elements over to the new array. How do you describe the runtime of insertion?
   - The array could be full. if the array contains N elements, then inserting a new element will take O(N) time. You will have to create a new array of size 2N and then copy N elements over. This insertion will take O(N) time.
   - However, we also know that this doesn't happen very often. The vast majority of the time insertion will be O(1) time.  We need a concept that takes both inot accoutn. This is what amortized time does. It allows us to describe that. Yes, this worst case happens every once in a while. But once it happens, it won't happen again for so long that the cost is `amortized`.  
   - As we insert elements, we double the capacity when the size of the array is a power of 2. So after X elements, we double the capacity at array sizes 1,2,4,8,16,...,X. That doubling takes respectively, 1, 2, 4, 8, 16, 32, 64, ..., X copies.  What is the sum of 1+2+4+8+16+ ...+X ? if you reda this sum left to right, it starts with 1 and doubles untils it gets to X. If you read right to left, it starts with X and halves until it gets to 1.
   - What then is the sum of X + X/2 + X/4 + X/8 + ... + 1 ? This is roughly 2X. Therefore X insertions take O(2X) time. The amortized time for each insertion is O(1).

5. Log N Runtimes
   - We start off with an N-element array to search. Then after a single step, we are down to N/2 elements. one more step, and we are down to N/4 elements. We stop when we either find the value or we're down to just one element. ( OOHHH!!! this is **BINARY SEARCH** ).
   - The total runtime is then a matter of how many steps (dividing N by 2 each time) we can take until N becomes 1. 
   - What is K in the expression 2^k = N ?  This is exactly what log expresses.  2^4 = 16 --> log16 = 4.   Log N = k --> 2^k = N.
   - **This is a good takeway. When you see a problem where the number of elements in the problem space gets halved each time, that will be a O(log N) runtime.**
   - **HINT: if you are cutting the problem set in half each time, then your Time complexity will be in the O(log N).**
   - **_What's the base of the log?  That's an excellent question!  The short answer is that it doesn't matter for the purposes of big O._**

6. Recursive Runtimes **Always Tricky, need to be careful otherwise they bite you in the Back**
   - When you have a recursive function that makes multiple calls, the runtime will oftern **(but not always)** look like )(branches^depth), where branches is the number of times ech recursive call branches. For example consider below code.
   ```
      int f(int n){     
         if(n <=1)
            return 1;
            
         return f(n-1) + f(n-1);    
         // Number of branches each recursive call branches.. in this example it is _2_
         // depth is number of times recursive call is made... in this example it is ~n.
         // So Time complexity BigO = O(2 ^ N).
         // The Space complexity of this algorith will be O(N). Althought we have O(2^N) nodes in the tree total, only O(N) exist at any give time. Therefore, we would only need to have O(N) memory available.
      }
   ```
   **_NOTE_**
   **The base of the log doesn't matter for big O since logs of different bases are only different by a constant factory. However, this does not apply to exponents. The base of an exponent does matter.  Compare 2^n and 8^n.  If you expand 8^n, you get (2^3)^n, which equals 2^3n, which equals 2^2n * 2^n.  As you can see, 8^n and 2^n are different by a factor of 2^2n. That is very much not a constant factor!!**

## GOTCHAS
*Suppose we had an algorithm that took in an array of strings, sorted each string, and then sorted the full array. What would the runtime be ?*
 - Most people will reason the following: Sorting each string is O(N log N) and we have to do this for each string, so that's O( N * N log N ).  We also have to sort this array, so that's an additional O(N log N ) work, Therefore, the total runtime os O(N^2 log N + N log N ) , which is just O ( N^2 log N). This is completely incorrect. The problem is that we used N in two different ways. In one case, it's the length of the string (which string ?). And in another case, it's the length of the array.
 - You can prevent this type of errors y either not using the variable "N" at all, or by only using it when there is no **ambiguity** as to what N could represent.  
 - In this runtime calcualtion, i will not even use a and b here, or m and n. It's too easy to forget which is which and mix them up. an O(a^2) runtime is completley different from and O(a*B) runtime.
 - Let's define new terms -- and use names that are logical.
   - Let 's' be the length of the longest string.
   - Let 'a' be the length of the array.
   - Now we can work through this in parts:
   - Sorting each string is O(s log s).
   - we have to do this for every string ( and there are 'a' strings), so that's O(a * s log s).
   - **Now we have to sort all the strings. There are 'a' strings, so you all may be inclined to say that this takes O(a log a) time. This is what most people would say. _You should also take into account that you need to compare the strings. Each string comparison takes O(s) time. There are o(a log a ) comparisions,therefore this will take O(a * s log a) time._**
   - Since these are two parts in the algorithm, Sorting all individual Strings first. And then Sorting the entire array second, we have to add the run times of these two parts, you get O(a * s log s) + O(s * a log a) = O(a * s log s) + O(a * s log a) = O(a * s (log s + log a)).
