
package HackerRank.weekly_2014july.BestSpot;
// sure to timeout:  R^2 * C^2
import java.util.*;
import java.io.*;

public class Solution implements Runnable {
		
	public void solve() throws IOException {
		int R = nextInt(); int C = nextInt();
                int[][] land = new int[R][C];
                for(int i = 0; i < R; i++)
                    for(int j = 0; j < C; j++)
                        land[i][j] = nextInt() + 20;
                
                int M = nextInt(); int N = nextInt();
                
                int shopSum = 0;
                int[][] shop = new int[M][N];
                for(int i = 0; i < M; i++)
                    for(int j = 0; j < N; j++){
                        shop[i][j] = nextInt() + 20;
                        shopSum += shop[i][j];
                    }
//                
//                int[][] sum = new int[R + 1][C + 1];
//                for(int i = 1; i <= R; i++)
//                    for(int j = 1; j <= C; j++){
//                        sum[i][j] = land[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
//                    }
//                
                
                
               int mincost = Integer.MAX_VALUE;
               int absDiff = Integer.MAX_VALUE;
               int indexi = -1, indexj = -1;
             for(int i = 0; i <= R - M; i++)
    outer:          for(int j =0; j <= C - N; j++){
                        //int diff = Math.abs(shopSum - sum[i+M][j+N]);
                        //if(diff > absDiff) continue;
                        //System.out.println(diff + " " + i + " " + j + " " + sum[i+M][j+M]);
                       int curCost = 0;
                       for(int ii = 0; ii < M; ii++)
                           for(int jj = 0; jj < N; jj++){
                               int cur = land[i + ii][j+jj] - shop[ii][jj];
                               curCost += cur * cur;
                               if(curCost >= mincost) continue outer; // no need to loop again
                           }
                       
                       if(curCost < mincost){
                          // absDiff = diff;
                           mincost = curCost;
                           indexi = i;
                           indexj = j;
                       }
                   }
               
               System.out.println(mincost);
               System.out.println((indexi + 1) +" " + (indexj + 1));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Solution().run();
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
			in = new BufferedReader(new InputStreamReader(System.in));
			tok = null;
			solve();
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

	BufferedReader in;
	StringTokenizer tok;
}