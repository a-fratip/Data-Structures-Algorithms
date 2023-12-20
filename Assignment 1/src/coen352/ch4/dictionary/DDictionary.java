package coen352.ch4.dictionary;

import org.junit.jupiter.api.Test;

import coen352.ch4.list.ADTList;
import coen352.ch4.list.*;

/** Dictionary implemented by double linked list */
public class DDictionary<Key, E> implements ADTDictionary<Key, E> {
    private static final int defaultSize = 10; // default size
    private DList<KVpair<Key,E>> list; // To store dictionary

    /** constructors */
    DDictionary() { this(defaultSize); }
    DDictionary(int sz)
        { list = new DList<KVpair<Key, E>>(sz); }

    /** Reinitialize */
    @Override
    public void clear() { list.clear(); }

    /** Insert an element: append to list */
    @Override
    public void insert(Key k, E e) {
        if (find(k) != null) // key already exists in dictionary
            return;
        KVpair<Key,E> temp = new KVpair<Key,E>(k, e);
        list.append(temp);
    }

    /** Use sequential search to find the element to remove */
    @Override
    public E remove(Key k) {
        E temp = find(k);
        if (temp != null) list .remove();
        return temp;
    }

    /** Remove the last element */
    @Override
    public E removeAny() {
        if (size() != 0) {
            list.moveToEnd();
            list.prev();
            KVpair<Key,E> e = list.remove();
            return e.value();
        }
        else return null;
    }

    /** Find k using sequential search
     *
     * @param k The key of the record to find
     * @return Record with key value k */
    @Override
    public E find(Key k) {
        for(list.moveToStart(); list.currPos() < list.length(); list.next()) {
            KVpair<Key,E> temp = list.getValue();
            if (k == temp.key())
                return temp.value();
        }
        return null; // k does not appear in dictionary
    }

    @Override
    public int size()
    { return list.length(); }

    // define function for access to keys
    public ADTList<Key> getKeyList() {
        DList<Key> keyList = new DList<>();
        for (int i = 0; i < list.length(); i++) {
            keyList.append(list.getValue().key());
        }
        return keyList;
    }


    public String toString() {
        StringBuffer out = new StringBuffer();

        for(int i=0; i < list.length(); i++) {
            out.append(list.getValue().toString());
        }

        return out.toString().trim();
    }
}
