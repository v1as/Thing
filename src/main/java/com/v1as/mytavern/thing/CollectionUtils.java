package com.v1as.mytavern.thing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils {

    public static <T> T random(Collection<T> collection) {
        List<T> list = new ArrayList<T>(collection);
        Collections.shuffle(list);
        return list.size() > 0 ? list.get(0) : null;
    }

    public static  <T> T first(Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }

}
