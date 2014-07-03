package HackerRank.weekly_2014july.CosecSubSeq;
//O(N + K)
import java.util.*;
import java.io.*;
public class Solution implements Runnable {
	public void solve() throws IOException {
		int T = nextInt();
                for(int t  = 0; t < T; t++){
                    int N = nextInt(); int K = nextInt();
                    
                    int[] a = new int[N];
                    for(int i = 0; i < N; i++) a[i] = nextInt();
                    long[] sum = new long[N+1];
                    for(int i = 1; i <= N; i++) sum[i] = sum[i-1] + a[i-1];
                    
                    int[] cnt = new int[K];
                    for(int i = 0; i <= N; i++) cnt[(int)(sum[i] % K)]++;
                    
                    long answer = 0;
                    for(int i = 0; i < K; i++){
                        answer += (cnt[i] * (long)(cnt[i] - 1)) / 2;
                    }
                    
                    
                    System.out.println(answer);
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