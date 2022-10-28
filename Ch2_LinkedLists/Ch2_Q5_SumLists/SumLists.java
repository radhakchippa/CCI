// Sum Lists: You have two numbers represented by a linked list, where each node contains a single
//digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
//function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
//Output: 2 -> 1 -> 9. That is, 912.
//FOLLOW UP
//Suppose the digits are stored in forward order. Repeat the above problem.
//EXAMPLE
//Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
//Output: 9 -> 1 -> 2. That is, 912.

public class SumLists {
    public static Node sumListReverse(Node first, Node second){
        if(first == null && second == null) return;
        int carry = 0; int total = 0;
        Node sum, head;
        while(first != null || second != null){
            if(first != null && second != null){
                total = first.value + second.value + carry;
                if(sum == null) {
                    sum = new Node(total % 10);
                    head = sum;
                } else {
                    sum.next = new Node(total%10);
                    sum = sum.next;
                }
                carry = total/10;
                first = first.next;
                second = second.next;
            } else if(first == null && second!= null){
                total = second.value + carry;
                sum.next = new Node(total %10);
                sum = sum.next;
                carry = total/10;
                second = second.next;
            } else if(first != null && second == null) {
                total = first.value + carry;
                sum.next = new Node(total % 10);
                sum = sum.next;
                carry = total / 10;
                first = first.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}