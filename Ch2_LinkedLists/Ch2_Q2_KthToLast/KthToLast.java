//Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
//assumptions: K is within the size limits of singly linked List.
//will return Node of the Kth to last element.
//idea is to use two pointers separated by K elements, then move points till one of the pointer reaches end of the list.
//return second pointer which is at the Kth to Last element.
//ex: 2nd to Last element. a>e>b>g>c>n  should return g.
// ex: 1 to last element.  a>e>b>g>c>n  should return c.

public class KthToLast {
    public static Node returnKthToLastNode(Node head, int k){
        if(head == null) return null;
        Node first = head, second = head;
        int count = 0;
        while(count < k){
            first = first.next;
            count++;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }   // first = n, second = g k = 2 count =2;
}