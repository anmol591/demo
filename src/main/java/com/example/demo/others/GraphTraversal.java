package com.example.demo.others;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversal {
    private int noOfVertices;
    private LinkedList<Integer> adjList[];
    private static final Integer DEFAULT_NO_OF_VERTICES = 5;

    public GraphTraversal(){
        this(DEFAULT_NO_OF_VERTICES);
    }

    public GraphTraversal(int v){
        this.noOfVertices = v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++)
            adjList[i] = new LinkedList<>();
    }

    private void addEdge(int s,int d){
        adjList[s].add(d);
    }

    public void bfs(int source){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[noOfVertices];
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()){
            int temp  = queue.poll();
            System.out.println(temp + " ");

            for (int value : adjList[temp]) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }

    private void dfsUtil(int source,boolean visited[]){
       visited[source] = true;
        System.out.println(source + " ");
        Iterator<Integer> it = adjList[source].listIterator();
        while(it.hasNext()){
            int value = it.next();
            if(!visited[value]){
                dfsUtil(value,visited);
            }
        }
    }

    public void dfs(int source){
       boolean visited[] = new boolean[noOfVertices];
       dfsUtil(source,visited);
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adjList[i];

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    //detect cycle in a directed graph
    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[noOfVertices];
        boolean[] recStack = new boolean[noOfVertices];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < noOfVertices; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String args[]){
        GraphTraversal g = new GraphTraversal(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);

        g.addEdge(3,1);
        if(g.isCyclic())
        System.out.println("Cycle exists");
        else
        System.out.println("cycle does not exist");
    }
}
