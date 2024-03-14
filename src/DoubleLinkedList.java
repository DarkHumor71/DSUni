public class DoubleLinkedList<E> {
    private final Node<E> head;
    private final Node<E> tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node<>();
        tail = new Node<>(head, null, null);
        head.next = tail;
    }

    public void addFirst(E e) {
        Node<E> n = new Node<>(head, head.next, e);
        head.next = n;
        n.next.prev = n;
        size++;
    }

    public void addLast(E e) {
        Node<E> n = new Node<>(tail.prev, tail, e);
        tail.prev = n;
        n.prev.next = n;
        size++;
    }

    public void add(E e, int indx) {
        if (indx < 0 || indx > size) return;
        if (indx == 0) {
            addFirst(e);
        } else if (indx == size) {
            addLast(e);
        }

        Node<E> curr = head.next;
        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }
        Node<E> n = new Node<>(curr, curr.next, e);
        curr.next = n;
        n.next.prev = n;
        size++;
    }

    public void show() {
        Node<E> n = head.next;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public E removeFirst() {
        if (size == 0) return null;
        if (size == 1) {
            head.next = tail;
            tail.prev = head;
        }
        Node<E> c = head.next;
        E temp = c.val;
        head.next = c.next;
        c.next.prev = head;
        size--;
        return temp;
    }

    public E removeLast() {
        if (size == 0) return null;
        if (size == 1) {
            head.next = tail;
            tail.prev = head;
        }
        Node<E> c = tail.prev;
        E temp = c.val;
        tail.prev = c.prev;
        c.prev.next = tail;
        size--;
        return temp;
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
        Node<E> c = getnode(indx);
        c.prev.next = c.next;
        c.next.prev = c.prev;
        c.next = null;
        c.prev = null;
    }

    public E set(int indx, E e) {
        if (indx > size || indx < 0) return null;
        //cases
        Node<E> curr = head.next;
        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }
        E temp = curr.val;
        curr.val = e;
        return temp;
    }

    public E get(int indx) {
        if (indx > size || indx < 0) return null;
        Node<E> curr = head.next;
        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    private Node<E> getnode(int indx) {
        if (indx > size || indx < 0) return null;
        Node<E> curr = head.next;
        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> curr = head.next;
        while (curr != tail) {
            if (curr == tail.prev) s.append(curr.val);
            else s.append(curr.val).append(",");
            curr = curr.next;
        }
        return s.toString();
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
