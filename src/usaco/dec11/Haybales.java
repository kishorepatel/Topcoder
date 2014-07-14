/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.dec11;

import java.util.*;
import java.io.*;

public class Haybales implements Runnable {
public static final String IN_FILE = "I.10";
public static final String OUT_FILE = "OO.10";

	public void solve() throws IOException {
		int N = nextInt();
                int[] a = new int[N];
                int sum = 0;
                
                for(int i = 0; i < N; i++){
                        a[i] = nextInt();
                        sum += a[i];
                }
                
                int avg = sum / N;
                
                int moves = 0;
                for(int i = 0; i < N; i++){
                        if(a[i] > avg) moves += a[i] - avg;
                }
                
                out.println(moves);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Haybales().run();
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
