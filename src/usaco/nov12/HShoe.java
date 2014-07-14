
package usaco.nov12;

import java.util.*;
import java.io.*;

public class HShoe implements Runnable {
public static final String IN_FILE = "hshoe.in";
public static final String OUT_FILE = "hshoe.out";
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        public void bkTrack(int x, int y, int left, int right, boolean close){
               if(left == right){
                       answer = Math.max(answer, left + right);
                       return;
               } 
               
               was[x][y] = true;
               
               for(int i = 0; i < 4; i++){
                       int nx = x + dx[i];
                       int ny = y + dy[i];
                       if(nx >= 0 && nx < N && ny >= 0&& ny < N && !was[nx][ny]){
                              if(!close && grid[nx][ny] == '(') bkTrack(nx, ny, left + 1, right, false);
                              if(grid[nx][ny] == ')') bkTrack(nx, ny, left, right + 1, true);
                       }
               }
               
               was[x][y] = false;
        }
        int N;
        char[][] grid;
        int answer;
        boolean[][] was;
	public void solve() throws IOException {
		N = nextInt();
                grid = new char[N][N];
                was = new boolean[N][N];
                for(int i = 0; i < N; i++) grid[i] = nextToken().toCharArray();
                
                answer = 0;
                if(grid[0][0] == '(')
                        bkTrack(0, 0, 1, 0, false); //x, y, ( , )
                
                out.println(answer);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new HShoe().run();
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
