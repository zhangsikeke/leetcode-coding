package 练级202109月份;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: keke
 * @date: 2021/8/27 23:41
 */
public class A12_面试题_03_01_三合一 {
    public static void main(String[] args) {
        A12_面试题_03_01_三合一 test = new A12_面试题_03_01_三合一(2);
        test.push(0, 1);
        test.push(0, 2);
        test.push(0, 3);
        System.out.println(test.pop(0));
        System.out.println(test.pop(0));
        System.out.println(test.pop(0));
        System.out.println(test.peek(0));
        test.push(0, 1);
        test.push(0, 2);

    }

    private Map<Integer, Integer> mapPos = new HashMap<>();
    private int stackSize;
    private int[] data;

    public A12_面试题_03_01_三合一(int stackSize) {
        mapPos.put(0, -1);
        mapPos.put(1, -1);
        mapPos.put(2, -1);
        this.stackSize = stackSize;
        data = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        if (mapPos.get(stackNum) == stackSize - 1) {
            return;
        }
        int pos = mapPos.get(stackNum) + 1;
        mapPos.put(stackNum, pos);
        data[pos + stackNum * stackSize] = value;
        System.out.println(pos + ":" + Arrays.toString(data));
    }

    public int pop(int stackNum) {
        int pos = mapPos.get(stackNum);
        if (pos == -1) {
            return -1;
        }
        mapPos.put(stackNum, pos - 1);
        return data[pos + stackNum * stackSize];
    }

    public int peek(int stackNum) {
        int pos = mapPos.get(stackNum);
        if (pos == -1) {
            return -1;
        }
        return data[pos+stackNum * stackSize];
    }

    public boolean isEmpty(int stackNum) {
        int pos = mapPos.get(stackNum);
        if (pos == -1) {
            return true;
        }
        return false;
    }
}