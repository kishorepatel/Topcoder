/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.nov13;

import java.util.*;
import java.io.*;

public class Combo implements Runnable {
public static final String IN_FILE = "combo.in";
public static final String OUT_FILE = "combo.out";
        
        public boolean ok(int a, int b){
                if(Math.abs(a - b) <= 2 || Math.abs(a - b) >= (N - 2)) return true;
                return false;
        }

        public boolean near(int a, int b, int c, int aa, int bb, int cc){
                if(ok(a, aa) && ok(b, bb) && ok(c, cc)) return true;
                return false;
        }

        int N;
	public void solve() throws IOException {
		N = nextInt();
                int a = nextInt(); int b = nextInt(); int c = nextInt();
                int x = nextInt(); int y = nextInt(); int z = nextInt();
                
                int cnt = 0;
                for(int i = 1; i <= N; i++){
                        for(int j = 1; j <= N; j++){
                                for(int k = 1; k <= N; k++){
                                        if(near(a, b, c, i, j, k) || near(x, y, z, i, j, k)) cnt++;
                                }
                        }
                }
                
                out.println(cnt);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Combo().run();
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