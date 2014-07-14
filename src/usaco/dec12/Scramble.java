/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package usaco.dec12;

import java.util.*;
import java.io.*;

public class Scramble implements Runnable {
public static final String IN_FILE = "scramble.in";
public static final String OUT_FILE = "scramble.out";

	public void solve() throws IOException {
		int N = nextInt();
                String[] actual = new String[N];
                String[] sorted = new String[N];
                String[] reverse = new String[N];
                for(int i = 0; i < N; i++){
                        actual[i] = nextToken();
                }
                
                for(int i = 0; i < N; i++){
                        char[] c = actual[i].toCharArray();
                        Arrays.sort(c);
                        sorted[i] = new String(c);
                        reverse[i] = new StringBuilder(new String(c)).reverse().toString();
                }
                
                Arrays.sort(sorted);
                Arrays.sort(reverse);
                
                for(int i = 0; i < N; i++){
                        char[] c = actual[i].toCharArray();
                        Arrays.sort(c);
                        Arrays.sort(c);
                        String first = new String(c);
                        String second = new StringBuilder(new String(c)).reverse().toString();
                        
                        
                        //now binary search to find its index;
                        int lo = Arrays.binarySearch(reverse, first);
                        if(lo < 0) lo = -(lo + 1);
                        else lo++;
                        
                        int hi = Arrays.binarySearch(sorted, second);
                        if(hi < 0) hi = -(hi + 1);
                        else hi++;
                        
                        if(lo < hi)
                                out.println(lo + " " + hi);
                        else
                                out.println(hi + " " + lo);
                }
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Scramble().run();
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