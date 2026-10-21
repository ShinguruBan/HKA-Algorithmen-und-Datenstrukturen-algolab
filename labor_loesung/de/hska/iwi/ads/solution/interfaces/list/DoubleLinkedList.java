package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {
    public V get(Object o) {
        if (o == null) {
            throw new NullPointerException();       //required for specific test
        }
        K wantedObject = (K) o;
        return search(wantedObject);
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();       //required for specific test
        }

        if (search(key) != null) {          //when the key already exist
            ListElement currentElement = head;
            while (currentElement != null && currentElement.entry.getKey() != key) {
                currentElement = currentElement.next;   //go through the sequence until the wanted entry is found
            }
            V previousValue = currentElement.entry.getValue();  //store previous value
            currentElement.entry.setValue(value);               //update value with new value
            return previousValue;
        }

        SimpleEntry<K, V> addingEntry = new SimpleEntry<>(key, value);      //create new entry with new value
        ListElement addingElement = new ListElement(addingEntry, null, head);
        if(head != null) {      //when the list isn't empty
            head.previous = addingElement;      //current first entry points at to be added entry as predecessor
        }
        head = addingElement;       //to be added entry becomes the first entry
        size++;
        return null;
    }

    private V search(K key) {
        ListElement currentElement = head;      //start at the beginning
        while (currentElement != null && currentElement.entry.getKey() != key) {
            currentElement = currentElement.next;   //go through the sequence until the wanted entry is found
        }
        if (currentElement == null) {       //if nothing is found
            return null;
        }
        return currentElement.entry.getValue();
    }

    public Entry<K, V> getHead() {          //for test purposes
        if (head == null) {
            return null;
        }
        return head.entry;
    }
}
