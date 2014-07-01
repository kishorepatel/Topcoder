/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.weekly_2014july.ACMTeam;
import java.util.*;
import java.io.*;

public class Solution implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt();
                int M = nextInt();
                char[][] a = new char[N][M];
                for(int i = 0; i < N; i++)
                    a[i] = nextToken().toCharArray();
                
                int cnt = 0;
                int maxTopics = 0;
                for(int i = 0; i < N; i++)
                    for(int j = i + 1; j < N; j++){
                        int curTopics = 0;
                        for(int k = 0; k < M; k++){
                            if(a[i][k] == '1' || a[j][k] == '1') curTopics++;
                        }
                        if(curTopics > maxTopics){
                            maxTopics = curTopics;
                            cnt = 1;
                        }
                        else if(curTopics == maxTopics){
                            cnt++;
                        }
                    }
                
                System.out.println(maxTopics + "\n" + cnt);
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