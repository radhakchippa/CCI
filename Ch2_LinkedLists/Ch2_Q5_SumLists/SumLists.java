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

    public static int nodesInLL(Node head){
        int count = 0;
        while(head!= null){
            count++;
            head = head.next;
        }
        return count;
    }

    public class PartialSum{
        Node node=new Node();
        int carry=0;
    }
    public static PartialSum recursiveSum(Node n1, Node n2){
        int total =0, carry = 0;
        PartialSum partialsum = new PartialSum();
        if(n1.next == null && n2.next == null){
            total = n1.value + n2.value;
            PartialSum.carry = total /10;
            PartialSum.node = new Node( total %10 );
            insertBefore(PartialSum.node, PartialSum.carry);
        } else {
            total = n1.value + n2.value;
            PartialSum.carry = total /10;
            PartialSum.node = insertBefore(recursiveSum(n1.next, n2.next), (total %10 + recursiveSum(n1.next, n2.next).carry) );
        }
        return partialsum;
    }
    public static Node sumList(Node first, Node second){
        //to add units, we have to traverse end of linked list and extract the digit in units place.
        //to add tens , we have to traverse last but one position in the linked list and extract and sum.
        // this is very inefficient, so we use stacks or nested calls. but problem with nested calls is we don't know size,
        // so we have to first find out size of the linked lists and them match the samller list head node with 0's to bring them same size.
        Node head, sum;
        int firstCount=0, secondCount=0;
        firstCount = nodesInLL(first);
        secondCount = nodesInLL(second);
        if(firstCount > secondCount){
            second = fillZeroes(second, firstCount-secondCount);
        } else {
            first = fillZeroes(first, secondCount-firstCount);
        }
        head = recursiveSum(first, second);
        return  head;
    }

}