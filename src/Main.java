public class Main {
    public static void main(String[] args) {
        System.out.println("Counter game:");

        String[] arr = {"Lera", "Masha", "Nastya", "Oleg", "Nikita"};
        int countForExclude = 10;

        CircularLinkedList clr = new CircularLinkedList(arr);
        clr.deleteNodeByGameIndex(countForExclude);
        System.out.println("Winner:");
        clr.traverseList();
    }
}
