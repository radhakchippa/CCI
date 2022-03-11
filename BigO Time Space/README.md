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

6. Recursive Runtimes **Tricky Business**
