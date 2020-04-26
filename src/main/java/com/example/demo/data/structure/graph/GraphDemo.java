package com.example.demo.data.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphDemo {

    //节点
    private List<String> list;

    //存储边
    private int[][] edges;

    //边的数目
    private int numOfEdges;

    //记录某个节点是否被访问过
    private boolean[] isVisited;

    public GraphDemo(int n) {
        list = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //添加节点
    public void addNode(String string) {
        list.add(string);
    }

    /**
     * 添加边  ，肯定有两个节点才能组成一条边
     * @param i  表示第一个节点的下标
     * @param j  表示第二个节点的下标
     * @param weight  边的值，1 或者 0 ，0 表示不可达
     */
    public void addEdge(int i,int j,int weight) {
        edges[i][j] = weight;
        edges[j][i] = weight;
        numOfEdges ++;
    }

    public int getNodeCount() { return list.size(); }

    public int getEdgesCount() { return numOfEdges; }

    public String getValueByIndex(int index) { return list.get(index); }

    public int getWeight(int i,int j) { return edges[i][j]; }

    public void print() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 得到 下标为 index 的第一个邻接节点的下标，没有返回-1
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < list.size(); j++) {
            if (edges[index][j] == 1)
                return j;
        }
        return -1;
    }

    /**
     * 根据前一个连接节点的下标来获取下一个连接节点
     * @param i1
     * @param i2
     * @return
     */
    public int getNextNeighbor(int i1,int i2) {
        for (int j = i2 + 1; j < list.size(); j++) {
            if (edges[i1][j] == 1)
                return j;
        }
        return -1;
    }

    public void dfs(boolean[] isVisited,int index) {
        if (index == getNodeCount() - 1) {
            System.out.println(getValueByIndex(index));
        } else {
            System.out.print(getValueByIndex(index) + " -> ");
        }

        isVisited[index] = true;
        /*System.out.print(getValueByIndex(index) + " -> ");*/

        int firstNeighbor = getFirstNeighbor(index);
        /*if (firstNeighbor != -1 && isVisited[firstNeighbor])
            dfs(isVisited,firstNeighbor);*/
        while (firstNeighbor != -1) {
            if (!isVisited[firstNeighbor])
                dfs(isVisited,firstNeighbor);
            //若节点被访问过
            firstNeighbor = getNextNeighbor(index,firstNeighbor);
        }
    }
    
    public void dfs() {
        for (int i = 0; i < getNodeCount(); i++) {
            if (!isVisited[i])
                dfs(isVisited,i);
        }
    }


    public void myDFS(int index) {

        isVisited[index] = true;
        System.out.print(list.get(index) + "\t");

        for (int j = index + 1; j < list.size(); j++)

            if (edges[index][j] == 1 && !isVisited[j])
                myDFS(j);

    }

    public void myBFS(int index) {
        LinkedList<Integer> queue = new LinkedList<>();

        //首先将该节点添加到队列中
        queue.addLast(index);

        //只要队列不为空
        while (!queue.isEmpty()) {

            Integer first = queue.getFirst();

            if (!isVisited[first]) {
                isVisited[first] = true;
                System.out.print(list.get(first) + "\t");
            }

            for (int j = first + 1; j < list.size(); j++) {
                if (edges[first][j] == 1 && !isVisited[j]) {
                    isVisited[j] = true;
                    System.out.print(list.get(j) + "\t");
                    queue.addLast(j);
                }
            }

            queue.removeFirst();
        }

    }


    public static void main(String[] args) {

        //String[] value = {"A","B","C","D","E"};
        String[] value = "12345678".split("");

        GraphDemo graph = new GraphDemo(value.length);

        for (String s : value) graph.addNode(s);

        /*graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);*/
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.addEdge(3,7,1);
        graph.addEdge(4,7,1);
        graph.addEdge(2,5,1);
        graph.addEdge(2,6,1);
        graph.addEdge(5,6,1);

        graph.print();

        graph.myBFS(0);
        System.out.println();

    }


}
