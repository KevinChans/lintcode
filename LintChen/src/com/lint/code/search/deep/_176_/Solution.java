package com.lint.code.search.deep._176_;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/15/16.
 * <p>
 * 图中两个点之间的路线
 * 给出一张有向图，设计一个算法判断两个点 s 与 t 之间是否存在路线
 * 样例
 * 如下图:
 * A----->B----->C
 * \     |
 * \    |
 * \   |
 * \  v
 * ->D----->E
 * for s = B and t = E, return true
 * for s = D and t = C, return false
 * @author Kevin
 */
public class Solution {

    public static void main(String[] args){
        new Solution();
    }

    private boolean result = false;

    public Solution(){
        DirectedGraphNode graphA = new DirectedGraphNode(0);
        DirectedGraphNode graphB = new DirectedGraphNode(1);
        DirectedGraphNode graphC = new DirectedGraphNode(2);
        DirectedGraphNode graphD = new DirectedGraphNode(3);
        DirectedGraphNode graphE = new DirectedGraphNode(4);

        ArrayList<DirectedGraphNode> nodes = new ArrayList<>();
        nodes.add(graphA);
        nodes.add(graphB);
        nodes.add(graphC);
        nodes.add(graphD);
        nodes.add(graphE);

        ArrayList<DirectedGraphNode> neighborsA = new ArrayList<>();
        neighborsA.add(graphB);
        neighborsA.add(graphD);
        graphA.neighbors = neighborsA;

        ArrayList<DirectedGraphNode> neighborsB = new ArrayList<>();
        neighborsB.add(graphC);
        neighborsB.add(graphD);
        graphB.neighbors = neighborsB;

        ArrayList<DirectedGraphNode> neighborsD = new ArrayList<>();
        neighborsD.add(graphE);
        graphD.neighbors = neighborsD;

        boolean result = hasRoute(nodes,graphB,graphE);
        System.out.println("result="+result);

    }
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        dfs(graph,s,t);
        dfs(graph,t,s);
        return result;
    }


    public void dfs(ArrayList<DirectedGraphNode> graph,
                       DirectedGraphNode s, DirectedGraphNode t){
        ArrayList<DirectedGraphNode> sNodes = s.neighbors;
        for(DirectedGraphNode node:sNodes){
            if(graph.contains(node)){
                if(node == t){
                    result = true;
                }
                ArrayList<DirectedGraphNode> newGraph = new ArrayList<>();
                newGraph.addAll(graph);
                newGraph.remove(node);
                dfs(newGraph,node,t);
            }
        }
    }

    //Definition for Directed graph.
    class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<DirectedGraphNode>();
      }
    }

}
