
//package usaco.mar14;

import java.util.*;
import java.io.*;

public class Cowart implements Runnable {
public static final String IN_FILE = "cowart.in";
public static final String OUT_FILE = "cowart.out";

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        public void dfs(int i, int j, char color){
                was[i][j] = true;
                for(int k = 0; k < 4; k++){
                        int ii = i + dx[k];
                        int jj = j + dy[k];
                        if(ii >= 0 && ii < N && jj >= 0 && jj < N && graph[ii][jj] == color && !was[ii][jj]){
                                dfs(ii, jj, color);
                        }
                }
        }
        
        
        char[][] graph;
        boolean[][] was;
        int N;
	public void solve() throws IOException {
		N = nextInt();
                graph = new char[N][N];
                was = new boolean[N][N];
                
                for(int i = 0; i < N; i++) graph[i] = nextToken().toCharArray();
                
                int man = 0, cow = 0;
                //flood fill
                for(int i = 0; i  < N; i++){
                        for(int j = 0; j < N; j++){
                                if(!was[i][j]){
                                        man++;
                                        dfs(i, j, graph[i][j]);
                                }
                        }
                }
                
                
                ///////////////////////////
                
                for(int i  = 0; i < N; i++) Arrays.fill(was[i], false);
                //convert the G to R
                for(int i = 0; i < N; i++)
                        for(int j = 0; j < N; j++)
                                if(graph[i][j] == 'G') graph[i][j] = 'R';
                
                //now flood fill
                for(int i = 0; i < N; i++){
                        for(int j = 0; j < N; j++){
                                if(!was[i][j]){
                                        cow++;
                                        dfs(i, j, graph[i][j]);
                                }
                        }
                }
                
                
                out.println(man + " " +  cow);
                
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Cowart().run();
	}

        public void print1Int(int[] a){
                for(int i = 0; i < a.length; i++)
                        System.out.print(a[i] + " ");
                System.out.println();
        }
        
        public void print2Int(int[][] a){
                for(int i = 0; i < a.length; i++){
                        for(int j = 0; j < a[0].length; j++){
                                System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                }
        }
        
	public void run() {
		try {
			in = new BufferedReader(new FileReader(IN_FILE));
                        out = new PrintWriter(new BufferedWriter(new FileWriter(new File(OUT_FILE))));
			tok = null;
			solve();
                        out.close();
			in.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

        PrintWriter out;
	BufferedReader in;
	StringTokenizer tok;
}