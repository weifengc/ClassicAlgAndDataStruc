package com.weifengcui.core.ds.ST;

import com.weifengcui.core.API.SymbolTalbe;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by weifengc on 7/3/16.
 * Move to ArrayST.java
 */
@Deprecated
public class ArrayListST<K, V> implements SymbolTalbe<K, V> {
    //a key array and a value arr
    List<K> kList = new ArrayList<K>();
    List<V> vList = new ArrayList<V>();

    int sizeOfNull = 0;


    public ArrayListST() {
    }

    private int getPos(K key) {
        for (int i = 0; i < kList.size(); i++) {
            if (kList.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void put(K key, V value) {
        int pos = getPos(key);
        //check null
        if (value == null) {
            if (pos == -1) {
                //nothing return
                return;
            } else {
                vList.set(pos, null);
                sizeOfNull++;
                return;
            }
        } else {
            if (pos == -1) {
                kList.add(key);
                vList.add(value);
            } else {
                vList.set(pos, value);
            }
        }
    }

    @Override
    public V get(K key) {
        int pos = getPos(key);
        if (pos == -1) {
            return null;
        } else {
            return vList.get(pos);
        }
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return (kList.size() - sizeOfNull) == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void delete(K key) {
        put(key, null);
    }
}
