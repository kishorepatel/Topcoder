
package Arrays_and_strings.SherlockMinimax;

import java.util.*;
import java.io.*;

public class Solution implements Runnable {
        
        int answer;
        int best;
	public void solve() throws IOException {
		int N = nextInt();
                int[] a = new int[N];
                for(int i = 0; i < N; i++) a[i] = nextInt();
                int P = nextInt(); int Q = nextInt();
                
                best = 0;
                answer = P;
                check(P, a);
                for(int i = 0; i < N; i++){
                    for(int j = i + 1; j < N; j++){
                        int mid = (a[j] + a[i]) / 2;
                        if(mid >= P && mid <= Q)
                            check(mid, a);
                    }
                }
                check(Q, a);
                
                System.out.println(answer);
	}

	void check(int x, int[] a){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < a.length; i++)
                min = Math.min(min, Math.abs(a[i] - x));
            
            if(best < min){
                best = min;
                answer = x;
            }
            
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