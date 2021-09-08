package 练级202109月份;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/9/6 22:04
 */
public class A6_284_顶端迭代器 implements Iterator<Integer> {

    private List<Integer> list;
    private int pos = 0;
    private int total = 0;

    public A6_284_顶端迭代器(Iterator<Integer> iterator) {
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        total = list.size();
    }

    public Integer peek() {
        return list.get(pos);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (pos < total) {
            int res = list.get(pos);
            pos++;
            return res;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean hasNext() {
        if (pos >= total) {
            return false;
        }
        return true;
    }
}
