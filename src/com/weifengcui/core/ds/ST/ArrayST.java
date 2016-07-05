package com.weifengcui.core.ds.ST;

import com.weifengcui.core.API.SymbolTable;

/**
 * Created by weifengc on 7/4/16.
 * This one use array of objects to contain key and values.
 * 
 */
public class ArrayST<K, V> implements SymbolTable<K, V> {
    private static final int DEFAULT_SIZE = 10;

    Object[] elements_key;
    Object[] elements_value;
    private int num_ele = 0;


    public ArrayST() {
        this(DEFAULT_SIZE);
    }

    public ArrayST(int size) {
        elements_key = new Object[size];
    }





    /**
     * check the size of the arr and the real size of the num.
     */
    private void resizeArr() {
        //if real size == array size, double
        //if readl size == 1/4 arry size, half

        if (num_ele == elements_key.length) {
            Object[] newKeys = new Object[elements_key.length * 2];
            Object[] newValues = new Object[elements_value.length * 2];
            System.arraycopy(elements_key, 0, newKeys, 0, num_ele);
            System.arraycopy(elements_value,0, newValues, 0, num_ele);
        }

        if (num_ele <= elements_key.length / 4) {
            Object[] newKeys = new Object[elements_key.length /2];
            Object[] newValues = new Object[elements_value.length /2];
            System.arraycopy(elements_key, 0, newKeys, 0, num_ele);
            System.arraycopy(elements_value,0, newValues, 0, num_ele);
        }
    }

    private int indexOf(K key) {
        if (key == null) {
            return -1;
        }

        for (int i = 0; i < elements_key.length; i++) {
            if (key.equals((K) elements_key[i])) {
                return i;
            }
        }
        return -1;
    }


    //**********************************************************************
    @Override
    public void put(K key, V value) {
        //key can not be null, value can be null.
        //when value is null, it is the same with delete.
        if (key == null) {
            return;
        }

        int pos = indexOf(key);


        if (value == null) {
            //if this is a delete option
            if (pos == -1) {
                //deleting something not exists. do nothing
                return;
            } else {
                //delete something exits, making sure there is no value with null key.
                elements_key[pos] = elements_key[num_ele - 1];
                elements_value[pos] = elements_value[num_ele - 1];
                elements_key[num_ele - 1] =null;
                elements_value[num_ele - 1] = null;
                num_ele--;
            }
        } else {
            //this is a real insertion.
            if (pos == -1) {
                resizeArr();
                elements_key[num_ele] = key;
                elements_value[num_ele] = value;
                num_ele++;
            } else {
                //this is an update.
                elements_value[pos] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        int pos = indexOf(key);
        if (pos == -1) {
            return null;
        } else {
            return (V) elements_value[pos];
        }
    }

    @Override
    public boolean contains(K key) {
        return indexOf(key) > -1;
    }

    @Override
    public boolean isEmpty() {
        return num_ele == 0;
    }

    @Override
    public int size() {
        return num_ele;
    }

    @Override
    public void delete(K key) {
        put(key, null);
    }
}
