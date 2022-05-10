/**
 * Вспомогательный клас Node , который хранит значения string и указатель на следующий узел
 * */

class Node {
    String value;
    Node nextNode;

    public Node(String value) {
        this.value = value;
    }
}

/**
 * Класс игры в считалочку, надстройка над классом списка
 * */
class CounterGame {

    private CircularLinkedList CLL = null;

    CounterGame(String[] args) {
        this.CLL = new CircularLinkedList(args);
    }

    public boolean searchForWinner(String searchValue) {
        return this.CLL.containsNode(searchValue);
    }

    public void getGameWinner() {
        this.CLL.traverseList();
    }

    /**
     * Метод игры в считалочку
     * @param index - индекс элемента, который нужно удалить
     * */
    public void deleteNodeByGameIndex(int index) {
        if (CLL.getHead() == null || index < 0) {
            return;
        }
        if (CLL.size() == 1) {
            return;
        }
        int indexForExclude = 0;
        for (Node node = CLL.getHead(); CLL.size() > 0; node = node.nextNode) {
            if (indexForExclude == index) {
                CLL.deleteNodeByValue(node.value);
                indexForExclude = 0;
            } else {
                indexForExclude++;
            }
        }
    }
}

/**
 * Класс - круговой связный список
 * @author Никита Аверочкин
 * @version 1.0
 * */
public class CircularLinkedList {
    /**
     * Первый и последний узел списка
     * */
    private Node head = null;
    private Node tail = null;

    CircularLinkedList() {}
    CircularLinkedList(String[] args) {
        for (int i=0;i<args.length;i++) {
            addNode(args[i]);
        }
    }

    /**
     * Методы геттеры первого и последнего узла списка
     * @return head, tail - первый и последний узлы
     * */
    public Node getHead() {
        return this.head;
    }
    public Node getTail() {
        return this.tail;
    }

    /**
     * Метод нахождения размера списка
     * */
    public int size() {
        int count = 0;
        for (Node node = head; node != tail; node = node.nextNode) {
            count++;
        }
        return count;
    }

    /**
     * Метод добавления узла в список
     * @param value - значение нового узла
     * */
    public void addNode(String value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Метод поиска элемента в списке
     * @param searchValue - значение элемента, который нужно найти
     * @return true - элемент есть в списке, false - нету
     * */
    public boolean containsNode(String searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Метод поиска элемента в списке
     * @param valueToDelete - значение элемента, который нужно удалить
     * */
    public void deleteNodeByValue(String valueToDelete) {
        Node currentNode = head;
        // the list is empty
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                // the list has only one single element
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    //we're deleting the head
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    //we're deleting the tail
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Метод обхода списка
     * */
    public void traverseList() {
        Node currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.value + " ");
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
        }
    }
}
