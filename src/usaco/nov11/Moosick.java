/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.nov11;

import java.util.*;
import java.io.*;

public class Moosick implements Runnable {
public static final String IN_FILE = "I.10";
public static final String OUT_FILE = "OO.10";

	public void solve() throws IOException {
		
                int N = nextInt();
                int[] a = new int[N];
                for(int i = 0; i < N; i++) a[i] = nextInt();
                int M = nextInt();
                int[] c = new int[M];
                for(int i = 0; i < M; i++) c[i] = nextInt();
                
                if(M == 1){
                        out.println(N);
                        for(int i = 0; i < N; i++)out.println(i + 1);
                }
                else{
                        Arrays.sort(c);
                        Set<Integer> ans = new TreeSet<Integer>();
                        for(int i = 0; i <= N - M; i++){
                                int[] cur = new int[M];
                                System.arraycopy(a, i, cur, 0, M);
                                Arrays.sort(cur);
                                
                                int d = cur[0] - c[0];
                                
                                boolean ok = true;
                                for(int k = 0; k < M; k++){
                                        if(d != cur[k] - c[k]){
                                                ok =false;
                                                break;
                                        }
                                }
                                
                                if(ok) ans.add(i + 1);
                        }
                        
                        out.println(ans.size());
                        for(int i : ans)
                                out.println(i);
                }
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Moosick().run();
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
