/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.feb14;
import java.util.*;
import java.io.*;

public class Mirror implements Runnable {
public static final String IN_FILE = "mirror.in";
public static final String OUT_FILE = "mirror.out";

        int[] dr = {+1, 0, -1, 0}; //down, right, up, left
        int[] dc = {0, +1, 0, -1};
        int[] slash1 = {3, 2, 1, 0}; // ./. 
        int[] slash2 = {1, 0, 3, 2}; // .\.
        int N, M;
        char[][] graph;
        
        
        public int solve(int r, int c, int dir){
                int result = 0;
                
                while(r >= 0 && r < N && c >= 0 && c < M){
                        if(graph[r][c] == '/')
                                dir = slash1[dir];
                        else
                                dir = slash2[dir];
                        result++;
                        r = r + dr[dir];
                        c = c + dc[dir];
                }
                
                return result;
        }
	public void solve() throws IOException {
                N = nextInt(); M = nextInt();
                graph = new char[N][M];
                for(int i = 0; i < N; i++) graph[i] = nextToken().toCharArray();
                
                int answer = 0;
                for(int i = 0; i < N; i++){
                        answer = Math.max(answer, solve(i, 0, 1));
                        answer = Math.max(answer, solve(i, M-1, 3));
                }
                for(int j = 0; j < M; j++){
                        answer = Math.max(answer, solve(0, j, 0));
                        answer = Math.max(answer, solve(N-1, j, 2));
                }
                
                out.println(answer);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Mirror().run();
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