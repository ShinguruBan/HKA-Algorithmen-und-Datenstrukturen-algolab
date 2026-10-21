package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class BinarySearchTreeTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> BinarySearchTree<K, V> createMap() {
        return new BinarySearchTree<>();
    }

    @Test
    public void testBinarySearchTree() {
        BinarySearchTree<Integer, String> test = new BinarySearchTree<>();
        Assert.assertEquals(null, test.getRoot());
        test.put(1, "Apple");
        test.put(2, "Banana");
        test.put(3, "Worm");
        test.put(4, "Giraffe");
        test.put(5, "Monkey");
        test.put(6, "Sechs");
        test.put(7, "Drei");
        Assert.assertEquals(7, test.size());
        Assert.assertEquals("Giraffe", test.get(4));
        Assert.assertEquals("Apple", test.get(1));
        Assert.assertEquals("Apple", test.getRoot().getValue());
    }

    @Test
    public void testBinarySearchTreeSearchNonExistentValue() {
        BinarySearchTree<Integer, String> test = new BinarySearchTree<>();
        test.put(1, "Apple");
        Assert.assertEquals(null, test.get(2));
    }

    @Test
    public void testBinarySearchTreePutExistingValue() {
        BinarySearchTree<Integer, String> test = new BinarySearchTree<>();
        test.put(1, "Apple");
        Assert.assertEquals(1, test.size());
        Assert.assertEquals("Apple", test.put(1, "Banana"));
        Assert.assertEquals(1, test.size());
        Assert.assertEquals("Banana", test.get(1));
    }
}
