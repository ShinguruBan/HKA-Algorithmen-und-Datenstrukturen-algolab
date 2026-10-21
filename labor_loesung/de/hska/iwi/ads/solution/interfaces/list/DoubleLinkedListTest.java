package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.AbstractMap;

public class DoubleLinkedListTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> DoubleLinkedList<K, V> createMap() {
        return new DoubleLinkedList<>();
    }

    @Test
    public void testDoubleLinkedList() {
        DoubleLinkedList<Integer, String> test = new DoubleLinkedList<>();
        Assert.assertEquals(null, test.getHead());
        test.put(1, "Apple");
        test.put(2, "Banana");
        test.put(3, "Worm");
        test.put(4, "Giraffe");
        test.put(5, "Monkey");
        test.put(6, "Sechs");
        test.put(7, "Drei");
        Assert.assertEquals("Drei", test.getHead().getValue());
        Assert.assertEquals(7, test.size());
        Assert.assertEquals("Giraffe", test.get(4));
        Assert.assertEquals("Apple", test.get(1));
        test.put(8, "Banana");
        Assert.assertEquals("Banana", test.getHead().getValue());
    }

    @Test
    public void testDoubleLinkedListHeader() {
        DoubleLinkedList<Integer, String> test = new DoubleLinkedList<>();
        Assert.assertEquals(null, test.getHead());
        test.put(1, "Apple");
        Assert.assertEquals("Apple", test.getHead().getValue());
        Assert.assertEquals(1, test.size());
        test.put(2, "Banana");
        Assert.assertEquals("Banana", test.getHead().getValue());
        Assert.assertEquals(2, test.size());
        test.put(3, "Worm");
        Assert.assertEquals("Worm", test.getHead().getValue());
        Assert.assertEquals(3, test.size());
        test.put(4, "Giraffe");
        Assert.assertEquals("Giraffe", test.getHead().getValue());
        Assert.assertEquals(4, test.size());
    }

    @Test
    public void testDoubleLinkedListPutExistingValue() {
        DoubleLinkedList<Integer, String> test = new DoubleLinkedList<>();
        test.put(1, "Apple");
        Assert.assertEquals(1, test.size());
        Assert.assertEquals("Apple", test.put(1, "Banana"));
        Assert.assertEquals(1, test.size());
        Assert.assertEquals("Banana", test.get(1));
    }

    @Test
    public void testDoubleLinkedListSearchNonExistentValue() {
        DoubleLinkedList<Integer, String> test = new DoubleLinkedList<>();
        test.put(1, "Apple");
        Assert.assertEquals(null, test.get(2));
    }
}
