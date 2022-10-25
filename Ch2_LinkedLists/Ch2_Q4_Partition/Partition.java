//Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
//before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
//to be after the elements less than x (see below). The partition element x can appear anywhere in the
//"right partition"; it does not need to appear between the left and right partitions.
//EXAMPLE
//Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
//Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

//ideas: create two linked lists one less than X and other greater than or equal to X.
//ideas: have two pointers, one pointing to lowest element than X, move any element lower than X to that pointer and
//update pointer, till all Nodes are inspected.

public class Partition {
    //idea1: have two LLs one greater and another lesser.
    //using JAVA built in Queues.
    public void PartitionLL(Node head, Integer x){
        if(head == null) return;
        LinkedList<Integer> lowerList = new LinkedList<>();
        LinkedList<Integer> greaterList = new LinkedList<>();
        Node current = head;
        while(current != null){
            if(current.value >= x){
                greaterList.add(current.value);
            } else {
                lowerList.add(current.value);
            }
        }
        while(greaterList.size() > 0){
            lowerList.add(greaterList.pop());
        }
        System.out.println(lowerList.toString());
    }

    //idea 2. Have two pointers...
    public void partition(Node head, Integer x){

    }
}