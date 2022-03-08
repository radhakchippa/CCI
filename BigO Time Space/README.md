### Big O 
BigO notation is to get the tightest description of the runtime. In otherwords we try to provide and closest possible runtime estimate not an upperbound or a lowerbound.
We always use BigO to define the runtime close to upperbound.

##Best/Worst/Expected case and Big O/theta/Omega mean?
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
        ```for(... N times) {... all done!! ... }
        then, do next step 
        for(...M times) {.... all done second step..}```
        Big O will be sum of both steps. as O(N + M).
  - **Multiply** If your algorithm is in the form "do this for each time you do that" then you multiple the runtimes.
        ```for(....N times) {
            for(...M times) { for each time in N, we do M times this work }```
        Big O will be Multiply both steps, as O(N * M ).
4. Amortized Time
   - 
