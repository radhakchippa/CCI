# LinkedLists Concepts
## OutLine
1. Discussion about Single & Doubly linked lists
   - What is a linked List ?
     - A Linked list is a sequential list of nodes that hold
       data which point to other nodes also containing data.

       node  -->   node  -->  node  -->  node  -->  node  --> null
       
   - Where are Linked Lists used ?
     - Used in many List, Queue & stack implementations.
     - Great for creating circular lists, polygon vertices, round robin scheduling.
     - Can easily model real world objects such as trains.
     - Used in separate chaining, which is present certain Hashtable implementations to deal with hasing collisions.
     - Often used in the implementation of adjacency lists for graphs.

   - Terminology
     - **Head:** The first node in a linked list
     - **Tail:** The last node in a linked list
     - **Pointer:** Reference to another node
     - **Node:** An Object containing data and pointers

   - Singly Linked vs. Doubly Linked
     - Singly linked lists only hold a reference to the next node. In the implementation you always maintain a reference to the **head** to the linked list and a reference to the **tail** node for quick additions/removals. 
       - Pros: Uses Less memory, Simpler to implement.
       - cons: Cannot easlily access previous elements.

     - Doubly Linked Lists each node holds a reference to the next and previous node. In the implementation you always maintain a reference to the **head** and the tail of the doubly linked list to do quick additions/removals from both ends of your list.
       - Pros: Can be traversed backwards.
       - Cons: Takes 2x memory

2. Implementation Details
   - How to insert new elements
     - Have a traversal pointer to maintain current node and previous node for Singly linked lists. 
     - Create a new node and link this new node to previous node and link the new node to the current node for insertion.
     - For a doubly Linked list, maintain single traversal pointer to maintain current node.
     - Create a new node and link this new node to current nodes previous pointer and link the new node next pointer to current node, Now link the previous node's next pointer to new node and current node's previous pointer to new node.
   - How to remove elements
3. Complexity analysis

    |type|singly linked list|doubly linked list|
    |----|------------------|------------------|
    |Insert/delete at head|O(1)|O(1)|
    |Insert/delete at tail|O(n)|O(1)|
    |Insert/delete in middle|O(n)|O(n)|

4. Code Implementation in Java.
