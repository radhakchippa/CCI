public class LinkedList<T>{
    private Class Node<T>{
        T data;
        Node next;
    }

    Node(T data){
        this.data=data;
        this.next=null;
    }

    public Node addHeadNode(T data, Node head){
        Node newhead = new Node(data);
        if(head!=null){
            newhead.next = head;
        }   
        head = newhead;
        return head;
    }

    public Node addTailNode(T data, Node head){
        if(head == null){
            return addHeadNode(data,head);
        }
        Node newNode = new Node(data);
        Node runner = head;
        while(runner.next!=null) runner = runner.next;
        runner.next = newNode;
        return head;
    }

    public Node addNodeAtPos(T data, Node head, int pos){
        if(pos<0) return head;
        if(pos == 0) addHeadNode(data, head);
        Node runner = head;
        int count = 0;
        while(runner.next!=null && count = (pos-1)){
            runner = runner.next;
            count++;
        }
        Node newNode = Node(data);
        newNode.next = runner.next;
        runner.next = newNode;
        return head;
    }

    public Node removeNode(T data, Node head){
        if(head.data == data){
            head = head.next;
            return head;
        }
        Node runner = head.next;
        Node previous = head;

        while(runner!=null ){
            if(runner.data != data){
                previous = runner;
                runner = runner.next;
            } else {
                previous.next = runner.next;
                break;
            }
           
        }
        return head;
    }

    public static void main(String...args){
        LinkedList singlyLinkedList = new LinkedList<Integer>();
    }

}