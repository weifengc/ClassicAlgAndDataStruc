package com.weifengcui.core.API;

/**
 * Created by weifengc on 7/3/16.
 */
public interface SymbolTable <K, V>  {
    void put(K key, V value);
    V get(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    void delete(K key);

}
