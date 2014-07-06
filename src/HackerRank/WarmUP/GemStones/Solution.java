
package WarmUP.GemStones;

import java.util.*;
import java.io.*;

public class Solution implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt();
                boolean[] ok = new boolean[26];
                Arrays.fill(ok, true);
                for(int i = 0; i < N; i++){
                    boolean[] cur = new boolean[26];
                    String s  = nextToken();
                    for(char c : s.toCharArray()) cur[c - 'a'] = true;
                
                    for(int k = 0; k < 26; k++) ok[k] = ok[k] & cur[k];
                }
                
                int answer = 0;
                for(int i = 0; i < 26; i++) if(ok[i]) answer++;
                System.out.println(answer);
                
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