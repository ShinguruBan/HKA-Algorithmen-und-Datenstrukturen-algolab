package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;
import de.hska.iwi.ads.dictionary.AbstractDictionary.DictionaryFullException;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {
    public Hashtable(int capacity) {
        super(capacity);
    }

    public V get(Object o) {
        K key = (K) o;
        int i = 0;

        while (hashtable[(Math.abs(key.hashCode()) + i * i) % hashtable.length] != null
                && i < hashtable.length) {
            int index = (Math.abs(key.hashCode()) + i * i) % hashtable.length;

            if (hashtable[index] != null && hashtable[index].getKey().equals(key)) {    //key found
                return hashtable[index].getValue();
            }
            i++;
        }
        return null;                    //key not found
    }

    public V put(K key, V value) {
        int i = 0;
        while (i < hashtable.length) {
            int index = (Math.abs(key.hashCode()) + i * i) % hashtable.length;

            if (hashtable[index] == null) {        //available space
                hashtable[index] = new SimpleEntry<>(key, value);
                size++;
                return null;
            }

            if (hashtable[index].getKey().equals(key)) {            //no space available
                V oldValue = hashtable[index].getValue();           //store old value
                hashtable[index].setValue(value);                   //overwrite old value
                return oldValue;                                    //return old value
            }
            i++;
        }
        throw new DictionaryFullException();        //hashtable full
    }
}
