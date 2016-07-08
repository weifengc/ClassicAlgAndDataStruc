package com.weifengcui.core.ds.ST;

import com.weifengcui.core.API.SymbolTable;

import java.util.HashMap;

/**
 * Created by weifengc on 7/8/16.
 * 1. the idea is to use hash table to implement this methods.
 * 2. You must have a hash function
 * 3. An object array is needed to contain the key-value
 * 4. create a new class, K and V should be its attributes.
 * 5. Assume we use a big array, not a array list.
 * FIXME: This is not tested and may have bugs. I should do more research in Functional Programming. Or the code will be very confusing when its logic is complicated.
 */
public class HashTableST<K, V> implements SymbolTable<K, V> {

    class Combo<K, V> {
        private K key;
        private V value;

        public Combo(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private boolean equalsKey(K key) {
            return this.key.equals(key);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


    }

    //******************** variables *******************

    private static int DEFAULT_OBJECT_LENGTH = 10;
    private Combo<K, V>[] arr;
    private int realSize;

    //************************helper method ************

    public HashTableST(int len) {
        arr = new Combo[len];
        realSize = 0;
    }

    public HashTableST() {
        this(DEFAULT_OBJECT_LENGTH);
    }


    /**
     * This is needed, when array is too large.
     */
    private void resizeArr() {
        if (realSize * 5 > arr.length) {
            //if realSize is more than 1/5 of the array size, double it.
            Combo[] newArr = new Combo[2 * arr.length];
            for (int i = 0; i < arr.length; i++) {
                //re insert every key-value to the new one.
                Combo combo = arr[i];
                if (combo == null) {
                    continue;
                } else {
                    //real insert.
                    realInsert(combo, newArr);
                }
            }


        } else {
            // do nothing,
            return;
        }
    }


    /**
     * Insert an combo to a array.
     *
     * @param combo
     * @param array
     */
    private void realInsert(Combo combo, Combo[] array) {
        int insertPos = combo.key.hashCode() % array.length;
        while (true) {
            if (array[insertPos] == null) {
                array[insertPos] = combo;
                break;
            }
            insertPos = (insertPos + 1) % array.length;
        }
    }

    /**
     * This is the real method, put the combo to the array.
     *
     * @param combo
     */
    private void put(Combo combo) {
        //check whether this is a update
        K key = (K) combo.getKey();
        int pos = indexOf(key);
        if (pos > -1) {
            //this is not an update
            //find out its position
            //check wether need to double arr
            resizeArr();
            realInsert(combo, arr);
            realSize++;
        } else {
            //this is an update
            arr[pos] = combo;
        }

    }


    /**
     * Return the postiion of the key.
     *
     * @param key
     * @return
     */
    private int indexOf(K key) {
        if (key == null) {
            return -1;
        }

        final int insertPos = key.hashCode() % arr.length;
        int var = insertPos;
        while (true) {
            if (arr[var].equalsKey(key)) {
                return var;
            } else if ((var + 1) % arr.length == insertPos) {
                return -1; // I already go through a loop
            } else {
                var++;
            }
        }
    }


    //************************** implement the methods ****************
    @Override
    public void put(K key, V value) {
        if (key == null) {
            return; // key should never be null;
        }

        //key will not be null, then

        //check if value is null
        if (value == null) {
            delete(key);
            return;
        }

        //then key is not null and value is not null
        Combo combo = new Combo(key, value);
        //put combo to the arr
        put(combo);
    }

    @Override
    public V get(K key) {

        int pos = indexOf(key);
        if (pos == -1) {
            return null;
        }
        return arr[pos].getValue();
    }

    @Override
    public boolean contains(K key) {
        return indexOf(key) == -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return realSize;
    }

    @Override
    public void delete(K key) {
        int pos = indexOf(key);
        if (pos == -1) {
            // no such key, just return
            return;
        } else {
            arr[pos] = null;
            realSize--;
        }
    }
}
