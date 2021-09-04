package 周赛.第60周;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: keke
 * @date: 2021/9/5 0:16
 */
public class A3_树上的操作 {
    Map<Integer, Integer> nodeUserMap = new HashMap<>();

    // 父子节点
    Map<Integer, List<Integer>> listP = new HashMap<>();

    // 子父节点
    Map<Integer, List<Integer>> listS = new HashMap<>();

    public A3_树上的操作(int[] parent) {
        int len = parent.length;
        //其中 parent[i] 是第 i 个节点的父节点
        for (int i = 0; i < parent.length; i++) {
            List<Integer> p = listP.getOrDefault(parent[i], new ArrayList<>());
            p.add(i);
            listP.put(parent[i], p);

            List<Integer> s = listS.getOrDefault(i, new ArrayList<>());
            s.add(parent[i]);
            listS.put(i, s);
        }
    }

    public boolean lock(int num, int user) {
        if (nodeUserMap.containsKey(num)) {
            return false;
        }
        nodeUserMap.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (nodeUserMap.containsKey(num) && nodeUserMap.get(num) == user) {
            nodeUserMap.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        //指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁
        //指定节点当前状态为未上锁
        if (nodeUserMap.containsKey(num)) {
            return false;
        }
        //指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
        if (!isSonLocked(num)) {
            return false;
        }
        //指定节点没有任何上锁的祖先节点。
        if (isParentLocked(num)) {
            return false;
        }

        // 解锁所有子孙节点
        releaseAllSonLock(num);
        lock(num, user);
        return true;
    }

    private boolean isParentLocked(int node) {
        if (nodeUserMap.containsKey(node)) {
            return true;
        }
        List<Integer> parent = listS.get(node);
        if (parent != null) {
            for (Integer integer : parent) {
                if (isParentLocked(integer)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSonLocked(int node) {
        if (nodeUserMap.containsKey(node)) {
            return true;
        }
        List<Integer> son = listP.get(node);
        if (son != null) {
            for (Integer integer : son) {
                if (isSonLocked(integer)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void releaseAllSonLock(int node) {
        if (nodeUserMap.containsKey(node)) {
            nodeUserMap.remove(node);
        }
        List<Integer> son = listP.get(node);
        if (son != null) {
            for (Integer integer : son) {
                releaseAllSonLock(integer);
            }
        }
    }

    public static void main(String[] args) {
        A3_树上的操作 test = new A3_树上的操作(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.print("null ");
        System.out.print(test.lock(2, 2) + " ");
        System.out.print(test.unlock(2, 3) + " ");
        System.out.print(test.unlock(2, 2) + " ");
        System.out.print(test.lock(4, 5) + " ");
        System.out.print(test.upgrade(0, 1) + " ");
        System.out.print(test.lock(0, 1) + " ");
    }
}
