//Remove Dups: Write code to remove duplicates from an unsorted linked list.
//FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?

//ex: a -> b -> c ->a -> c->e  ===>> a -> b -> c -> e.   h=a, S{a, b,c,e} p=e n=null
//ex: a -> b -> d -> p -> o - > a  ====> a -> b-> d -> p -> o.
//idea 1: create a Set and check if currrent value of Node exists in Set,
// if exists delete current node, otherwise go to next node.
//if Set is not allowed, then we have to iteratively check if current Node is present is all subsequent nodes
// until all nodes are investigated.

public class RemoveDups {
    //idea-1;
    public static Node removeDupsFromLL1(Node head){
        if(head == null) return;
        Set<Character> valueSet = new HashSet<>();
        Node node = head;
        Node previous = head;
        while(node != null){
            if(valueSet.contains(node.value)){
                node = removeNode(node, previous);
            } else {
                valueSet.add(node.value);
                previous = node;
                node = node.next;
            }
        }
        return head;
    }

    public static Node removeNode(Node current, Node previous){
        previous.next = node.next;
        node = previous.next;
        return node;
    }

    //idea-2;
    public static Node removeDupsLL2(Node head){
        if(head == null) return;
        Node previous = head, current = head, future = head.next;
        while(current != null){
            while(future !=null){
                if(future.value == current.value){
                    future =removeNode(future,previous);
                } else {
                    previous = future;
                }
                future = future.next;
            }
            current = current.next;
        }
        return head;
    }


}