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
        adjList[d].add(s);
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
        System.out.print(source + " ");
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

    //count no of connected components when graph is represented as adjList
    public int countNoOfConnectedComponents(){
         boolean[] visited = new boolean[noOfVertices];
         int count = 0;
         for(int i=0;i<noOfVertices;i++){
             if(!visited[i]){
                 dfsUtil(i,visited);
                 ++count;
             }

         }
         return count;
    }

    public static int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        if(M.length == 0)
            return 0;
        int ROW = M.length;
        int COL = M[0].length;
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS2(M, i, j, visited,ROW,COL);
                    ++count;
                }

        return count;
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    public static void DFS(int M[][], int row, int col, boolean visited[][], int ROW, int COL)
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited,ROW,COL))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited,ROW,COL);
    }

    public static void DFS2(int M[][], int row, int col, boolean visited[][], int ROW, int COL)
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
//        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
//        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        int k = 0;
        if (isSafe(M, row + 1, col, visited,ROW,COL))
            DFS2(M, row + 1, col, visited,ROW,COL);

        if (isSafe(M, row, col+1, visited,ROW,COL))
            DFS2(M, row, col+1, visited,ROW,COL);

        if (isSafe(M, row-1, col, visited,ROW,COL))
            DFS2(M, row-1, col, visited,ROW,COL);

        if (isSafe(M, row, col-1, visited,ROW,COL))
            DFS2(M, row, col-1, visited,ROW,COL);
    }

    public static boolean isSafe(int M[][], int row, int col,
                   boolean visited[][],int ROW,int COL)
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    public static void main(String args[]){
//        GraphTraversal g = new GraphTraversal(6);
//        g.addEdge(1,5);
//        g.addEdge(0,2);
//
//        g.addEdge(2,4);
//
//        System.out.println(g.countNoOfConnectedComponents());
//        if(g.isCyclic())
//        System.out.println("Cycle exists");
//        else
//        System.out.println("cycle does not exist");


        int M[][] = new int[][] { { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 1 } };
        System.out.println(countIslands(M));
    }
}
