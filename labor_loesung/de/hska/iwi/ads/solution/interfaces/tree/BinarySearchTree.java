package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {
    public V get(Object o) {
        K wantedObject = (K) o;
        return search(root, wantedObject);
    }

    public V put(K key, V value) {
        Node previousNode = null;
        Node currentNode = root;
        Node addingNode = new Node(key, value);

        while (currentNode != null) {
            if (key.compareTo(currentNode.entry.getKey()) == 0) {   //if key already exists
                V previousValue = currentNode.entry.getValue();     //store previous value
                currentNode.entry.setValue(value);              //update with new value
                return previousValue;
            }

            previousNode = currentNode;             //remember last node visited
            if (key.compareTo(currentNode.entry.getKey()) < 0) {    //when wanted key is smaller than current
                currentNode = currentNode.left;     //search in left subtree
            }
            else {
                currentNode = currentNode.right;    //search in right subtree
            }
        }

        if (previousNode == null) {     //when tree is empty
            root = addingNode;      //add as root
        }
        else if (key.compareTo(previousNode.entry.getKey()) < 0) {      //when key is smaller than parent node
            previousNode.left = addingNode;     //attach to left sid
        }
        else {
            previousNode.right = addingNode;    //attach to right side
        }

        size++;
        return null;
    }

    private V search(Node currentNode, K key) {
        if (currentNode == null) {
            return null;
        }
        else if (currentNode.entry.getKey() == key) {   //if node is found
            return currentNode.entry.getValue();
        }
        else  if (key.compareTo(currentNode.entry.getKey()) < 0) {  //if wanted key is smaller than current key
            return search(currentNode.left, key);       //search left subtree
        }
        else {                              //if wanted key is bigger than current key
            return search(currentNode.right, key);      //search right subtree
        }
    }

    public Entry getRoot() {
        if (root == null) {
            return null;
        }
        return root.entry;
    }
}
