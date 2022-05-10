public class Main {
    public static void main(String[] args) {
        System.out.println("Counter game:");

        String[] arr = {"Lera", "Masha", "Nastya", "Oleg", "Nikita", "Petya"};
        int countForExclude = 10;

        CounterGame cg = new CounterGame(arr);
        cg.deleteNodeByGameIndex(countForExclude);
        System.out.println("Winner:");
        cg.getGameWinner();

    }
}







//
//        CircularLinkedList clr = new CircularLinkedList(arr);
//        clr.deleteNodeByGameIndex(countForExclude);
//        System.out.println("Winner:");
//        clr.traverseList();
