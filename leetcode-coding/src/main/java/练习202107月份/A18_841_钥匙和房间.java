package 练习202107月份;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 模拟
 *
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A18_841_钥匙和房间 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Stream.of(1, 3).collect(Collectors.toList()));
        rooms.add(Stream.of(3, 0, 1).collect(Collectors.toList()));
        rooms.add(Stream.of(2).collect(Collectors.toList()));
        rooms.add(Stream.of(0).collect(Collectors.toList()));
        boolean res = new A18_841_钥匙和房间().canVisitAllRooms(rooms);
        System.out.println(res);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 0) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            map.put(rooms.get(0).get(i), true);
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean flg = true;
        do {
            boolean hasKey = false;
            for (int i = 1; i < rooms.size(); i++) {
                if (map.containsKey(i) && !set.contains(i)) {
                    for (int j = 0; j < rooms.get(i).size(); j++) {
                        map.put(rooms.get(i).get(j), true);
                    }
                    set.add(i);
                    hasKey = true;
                }
            }
            if (hasKey) {
                continue;
            }
            flg = false;
        } while (flg);

        return set.size() == rooms.size();
    }
}
