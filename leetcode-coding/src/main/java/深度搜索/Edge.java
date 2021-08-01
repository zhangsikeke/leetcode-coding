package 深度搜索;

/**
 * 边
 *
 * @author: keke
 * @date: 2021/8/1 15:35
 */
public class Edge {
    // 起始点
    private String start;
    // 结束点
    private String end;
    // 距离
    private int distance;

    public Edge() {
        super();
    }

    public Edge(String start, String end, int distance) {
        super();
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
