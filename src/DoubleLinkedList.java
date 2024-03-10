public class DoubleLinkedList<E> {
    private Node<E> head, tail;
    private int size;

    public void addFirst(E e) {
        Node<E> n=new Node<>(head,head.next,e);
        head.next=n;
        n.next.prev=n;
        size++;
    }

    public void addLast(E e) {
        Node<E> n=new Node<>(tail.prev,tail,e);
        tail.prev=n;
        n.prev.next=n;
        size++;
    }

    public void add(E e,int indx){
        if (indx < 0 || indx > size) return;
        if (indx == 0) {
            addFirst(e);
        } else if (indx == size) {
            addLast(e);
        }

        Node<E> curr=head.next;
        for (int i = 0; i <indx ; i++) {
            curr=curr.next;
        }
        Node<E> n=new Node<>(curr,curr.next,e);
        curr.next=n;
        n.next.prev=n;
        size++;
    }

    private class Node<E> {
        Node<E> next, prev;
        E val;

        public Node() {
        }

        public Node(Node<E> prev, Node<E> next, E val) {
            this.next = next;
            this.prev = prev;
            this.val = val;
        }

        public Node(E val) {
            this.val = val;
        }

    }
}
