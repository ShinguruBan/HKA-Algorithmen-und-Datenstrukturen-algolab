package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDictionary;
import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class HashtableTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> Hashtable<K, V> createMap() {
        return new Hashtable<>(9);
    }

    @Test
    public void testHashtablePutExistingValue() {
        DoubleLinkedList<Integer, String> test = new DoubleLinkedList<>();
        test.put(1, "Apple");
        Assert.assertEquals(1, test.size());
        Assert.assertEquals("Apple", test.put(1, "Banana"));
        Assert.assertEquals(1, test.size());
        Assert.assertEquals("Banana", test.get(1));
    }

    @Test
    public void testHashtableNonExistentValue() {
        DoubleLinkedList<Integer, String> test = new DoubleLinkedList<>();
        test.put(1, "Apple");
        Assert.assertEquals(null, test.get(2));
    }

    @Test
    public void testHashtableFull() {
        Hashtable<Integer, String> test = new Hashtable<>(1);
        test.put(1, "Apple");
        Assert.assertThrows(AbstractDictionary.DictionaryFullException.class, () -> test.put(2, "Banana"));
    }
}
