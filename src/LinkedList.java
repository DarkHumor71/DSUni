public class LinkedList<E> {
    private Node<E> head, tail;
    private int size;

    public int size() {
        return size;
    }

    public void add(E val) {
        addLast(val);
    }

    public void addfirst(E val) {
        Node<E> n = new Node<>(val, head);
        head = n;
        if (size == 0) tail = head;
        size++;
    }

    public void addLast(E val) {
        if (size == 0) {
            addfirst(val);
            return;
        }
        Node<E> n = new Node<E>(val);
        tail.next = n;
        tail = n;
        size++;
    }

    public void show() {
        Node n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    //    public void add(E val,int indx){
//        if (indx>size || indx<0)return;
//        Node n=new Node<E>(val);
//        if (indx==0){
//            addfirst(val);
//            return;
//        }
//        if (indx==size-1) {
//            addLast(val);return;
//        }
//        Node prev=head;
//        int counter=0;
//        while(prev.next!=null){
//            if (counter==indx){
//                n.next=prev.next;
//                prev.next=n;
//                size++;
//                break;
//            }
//            prev=prev.next;
//            counter++;
//
//        }
    public void add(E val, int indx) {
        if (indx < 0 || indx > size) return;
        if (indx == 0) {
            addfirst(val);
        } else if (indx == size) {
            addLast(val);
        }
        Node<E> p = head;
        for (int i = 0; i < indx - 1; i++) {
            p = p.next;
        }
        Node<E> q = p.next;
        Node<E> n = new Node<>(val, q);
        p.next = n;
        size++;
    }

    public E removeFirst() {
        if (size == 0) return null;
        E temp = head.val;
        head = head.next;
        if (size == 1) tail = null;
        size--;
        return temp;
    }

    public E removeLast() {
        if (size == 0) return null;
        if (size == 1) removeFirst();
        E temo = tail.val;
        Node<E> curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
        size--;
        return temo;
    }

    public void remove(int indx) {
        //check
        if (indx > size || indx < 0) return;
        if (indx == 0) {
            removeFirst();
            return;
        }
        if (indx == size - 1) {
            removeLast();
            return;
        }
        Node prev = head;
        Node curr = head.next;
        Node next = head.next.next;
        int counter = 0;
        while (next != null) {
            if (counter == indx) {
                curr = next;
                size--;
                break;
            }
            next = next.next;
            curr = curr.next;
            prev = prev.next;
            counter++;

        }
    }
//    public E removeLast(){
//        if (size==0)return null;
//        if (size==1) removeFirst();
//        E temo= tail.val;
//        Node<E> curr=head;
//        for (int i=0;i<size-2;i++){
//            curr=curr.next;
//        }
//        curr.next=null;
//        tail=curr;
//        size--;
//        return temo;
//    }

    public E set(int indx, E e) {
        //cases
        Node<E> curr = head;
        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }
        E temp = curr.val;
        curr.val = e;
        return temp;
    }

    public E get(int indx) {
        Node<E> curr = head;
        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> curr = head;
        while (curr != null) {
            if (curr == tail) s.append(curr.val);
            else s.append(curr.val).append(",");
            curr = curr.next;
        }
        return s.toString();
    }

    private class Node<E> {
        E val;
        Node<E> next;

        Node() {
            val = null;
            next = null;
        }

        Node(E val) {
            this.val = val;
            next = null;
        }

        Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }


}
