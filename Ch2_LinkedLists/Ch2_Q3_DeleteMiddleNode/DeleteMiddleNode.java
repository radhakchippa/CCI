//Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
//the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
//that node.
//EXAMPLE
//Input: the node c from the linked list a - >b- >c - >d - >e- >f
//Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f

public class DeleteMiddleNode {

    public static void deleteMiddleNode(Node current){
        if(current.next != null || current != head){
            return;
        }
        // idea is to copy the value and the next pointer to mimic deletion.
        current.value = current.next.value;
        current.next = current.next.next;
    }

}