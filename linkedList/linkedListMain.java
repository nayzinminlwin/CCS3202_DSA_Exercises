package linkedList;

public class linkedListMain {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();

        myLL.addFirst("ArrLuu Puri");
        myLL.addFirst("Samusa");
        myLL.add(0, "MontLinMayr");
        myLL.add(2, "MontHinGrr");
        myLL.addLast("ToShay");

        System.out.println(myLL.first.next.next.element);
        System.out.println(myLL);

        System.out.println(myLL.contain("ToShay"));
        // myLL.removeLast();
        // System.out.println(myLL);
        // myLL.removeFirst();
        // System.out.println(myLL);
    }
}
