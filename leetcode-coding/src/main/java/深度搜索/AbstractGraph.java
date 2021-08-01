package 深度搜索;


import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author: keke
 * @date: 2021/8/1 15:34
 */
public abstract class AbstractGraph {
    // 顶点数组
    protected String[] vertexs;
    // 邻接矩阵的二维数组
    protected int[][] edges;
    // 是否有向图
    protected boolean directed;
    // 顶点数
    protected int size;
    // 方向标识
    public final static String SPLIT = "->";

    AbstractGraph(String[] vertexs, Edge[] edgeList, boolean directed) {
    }

    /**
     * 初始化图
     *
     * @param vertexs
     * @param edgeList
     * @param directed
     */
    public abstract void init(String[] vertexs, Edge[] edgeList, boolean directed);

    /**
     * 获取顶点位子索引
     *
     * @param name
     * @return
     */
    public abstract int indexOf(String name);

    /**
     * 显示边或弧
     */
    public abstract void show();

    /**
     * 深度优先<br/>
     * 1.访问初始结点v，并标记结点v为已访问。<br/>
     * 2.查找结点v的第一个邻接结点w。<br/>
     * 3.若w存在，则继续执行,否则算法结束。<br/>
     * 4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。<br/>
     * 5.查找结点v的下一个邻接结点w，转到步骤3。<br/>
     *
     * @param name
     * @param visited
     */
    public abstract void dfsSearch(String name, int[] visited, String tmpPath, List<String> paths);

    /**
     * 广度优先，一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点。 <br/>
     * 1.访问初始结点v并标记结点v为已访问。 <br/>
     * 2 .结点v入队列 <br/>
     * 3.当队列非空时，继续执行，否则算法结束。 <br/>
     * 4.出队列，取得队头结点u。 <br/>
     * 5.查找结点u的第一个邻接结点w。 <br/>
     * 6.若结点u的邻接结点w不存在，则转到步骤 3； 否则循环执行以下三个步骤： <br/>
     * (1). 若结点w尚未被访问，则访问结点w并标记为已访问。 <br/>
     * (2). 结点w入队列 <br/>
     * (3). 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6
     *
     * @param name
     */
    public abstract void bfsSearch(String name);

    /**
     * 获取路径长度
     *
     * @param path A->B->C
     * @return
     */
    public abstract String getDistance(String path);

    /**
     * 获取两个顶点之间的所有路径
     *
     * @param fromName
     * @param toName
     * @return
     */
    public abstract Map<String, String> getPaths(String fromName, String toName);

    /**
     * 获取两个顶点之间的所有路径，分层搜索
     *
     * @param fromName
     * @param toName
     * @param visited  标记已访问节点
     * @param stack    存放当前层节点
     * @param pathMap  k 存放路径，v存放距离
     */
    public abstract void getPaths(String fromName, String toName, boolean visited[], Stack<Integer> stack,
                                  Map<String, String> pathMap);

    /**
     * 最短路径
     *
     * @param fromName
     * @param toName
     * @return
     */
    public abstract String getMinDistance(String fromName, String toName);

    /**
     * 最长路径
     *
     * @param fromName
     * @param toName
     * @return
     */
    public abstract String getMaxDistance(String fromName, String toName);

}
