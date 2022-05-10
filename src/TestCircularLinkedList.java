import org.junit.Assert;
import org.junit.Test;

public class TestCircularLinkedList {
    @Test
    public void containsNodeTest() {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode("8");
        cll.addNode("37");

        Assert.assertTrue(cll.containsNode("8"));
        Assert.assertTrue(cll.containsNode("37"));
    }

    @Test
    public void nonContainsNodeTest() {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode("11");
        cll.deleteNodeByValue("11");

        Assert.assertFalse(cll.containsNode("11"));
    }


    @Test
    public void deleteDifferentNodesByValueTest() {
        CircularLinkedList cll = new CircularLinkedList(new String[]{"46", "1", "13"});

        Assert.assertTrue(cll.containsNode("46"));
        cll.deleteNodeByValue("46");
        Assert.assertFalse(cll.containsNode("46"));

        Assert.assertTrue(cll.containsNode("1"));
        cll.deleteNodeByValue("1");
        Assert.assertFalse(cll.containsNode("1"));

        Assert.assertTrue(cll.containsNode("13"));
        cll.deleteNodeByValue("13");
        Assert.assertFalse(cll.containsNode("13"));
    }

    @Test
    public void givenACircularLinkedListWithOneNode_WhenDeletingElement_ThenListDoesNotContainTheElement() {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode("1");
        cll.deleteNodeByValue("1");
        Assert.assertFalse(cll.containsNode("1"));
    }

    @Test
    public void lengthOfCircularLinkedList() {
        CircularLinkedList cll = new CircularLinkedList(new String[]{"46", "1", "13"});
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, cll.size(), 10e5);
    }

    @Test
    public void counterGame() {
        CounterGame cg = new CounterGame(new String[]{"Ilya", "Pasha", "Andrew"});
        int countForExclude = 3;
        cg.deleteNodeByGameIndex(countForExclude);
        String expectedResult = "Pasha";

        cg.getGameWinner();
        Assert.assertFalse(cg.searchForWinner("Ilya"));
        Assert.assertFalse(cg.searchForWinner("Andrew"));
        Assert.assertTrue(cg.searchForWinner(expectedResult));
    }
}
