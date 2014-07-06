
package WarmUP.AngryChildren;

import java.util.*;
import java.io.*;

public class Solution implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt();
                int K = nextInt();
                int[] a = new int[N];
                for(int i = 0; i < N; i++) a[i] = nextInt();
                
                shuffle(a);
                Arrays.sort(a);
                
                int answer = Integer.MAX_VALUE;
                for(int i = 0; i <= N - K; i++) answer = Math.min(answer, a[i + K - 1] - a[i]);
                
                System.out.println(answer);
	}
        
        private void shuffle(int[] a){
            int i = 0, j = a.length;
            Random rnd = new Random();
            while(i < j){
                int index = rnd.nextInt(a.length);
                int t = a[index];
                a[index] = a[i];
                a[i] = t;
                i++; j--;
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