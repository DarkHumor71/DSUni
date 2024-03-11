public class Main {
    public static void main(String[] args) throws Exception {
ArrayList<Integer> a=new ArrayList<>();
a.add(1);
        a.add(1);
        a.add(1);
//        a.add(1);
        a.remove(a.size()-1);
        LinkedList<Integer> l=new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
//        l.show();
        l.add(5,1);
//        l.show();
        l.removeLast();
        l.show();

    }
}