package com.example.demo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTest {
    private int v;
    private List<List<Integer>> adjList = new ArrayList<>();

    public GraphTest(int v){
        this.v = v;
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
    }

    private void addEdge(int src,int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    private boolean isCyclic(int src,boolean visited[],int parent){
        visited[src] = true;
        for(int neigh : adjList.get(src)){
            if(!visited[neigh]){
                if(isCyclic(neigh,visited,src))
                    return true;
            } else if(neigh != parent){
                return true;
            }
        }
        return false;
    }

    private void dfs(int src,boolean visited[]){
        visited[src] = true;
        System.out.println(src);
        for(int n:adjList.get(src)){
            if(!visited[n])
                dfs(n,visited);
        }
    }

    private boolean isTree(){
        boolean[] visited = new boolean[this.v];
        if(isCyclic(0,visited,-1))
            return false;
        for(int i=0;i<this.v;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }

    public boolean isDirectedGraphCyclicUtil(int curr,boolean[] visited){
        if(visited[curr])
            return true;
        visited[curr] = true;
        for(int j: adjList.get(curr)){
            if(isDirectedGraphCyclicUtil(j,visited)){
                return true;
            }
        }
        visited[curr] = false;
        return false;
    }

    //test cyclic for directed graph
    public boolean isDirectedGraphCyclic(){
        boolean[] visited = new boolean[this.v];
        for (int i=0;i<v;i++){
            visited[i] = true;
            for(int j : adjList.get(i)){
                if(isDirectedGraphCyclicUtil(j,visited))
                    return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public boolean isUndirectedGraphCyclic(){
        int[] visited = new int[this.v];
        Arrays.fill(visited,0);
        for (int i=0;i<v;i++){
            visited[i] = 1;
            for(int j : adjList.get(i)){
                if(isUndirectedGraphCyclicUtil(j,visited)) //giving wrong output, need to check
                    return true;
            }
            visited[i] = 0;
        }
        return false;
    }

    public boolean isUndirectedGraphCyclicUtil(int curr, int[] visited){
        if(visited[curr] == 2)
            return true;
        visited[curr] = 1;

        for(int j : adjList.get(curr)){
            if(visited[j] == 1)
                visited[j] = 2;
            else {
                if(isUndirectedGraphCyclicUtil(j,visited))
                    return true;
            }
        }
        visited[curr] = 0;
        return false;
    }

    public static void main(String args[]){
//        GraphTest graphTest = new GraphTest(5);
//        graphTest.addEdge(1,0);
//        graphTest.addEdge(0,2);
//        graphTest.addEdge(0,3);
//        graphTest.addEdge(3,4);


        GraphTest g2 = new GraphTest(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
//        g2.addEdge(1,2);
//        g2.addEdge(2,3);
////        g2.addEdge(2,4);
//        g2.addEdge(3,4);


        System.out.println(g2.isUndirectedGraphCyclic());

    }
}
