/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.nov11;

import java.util.*;
import java.io.*;

public class Ctiming implements Runnable {
public static final String IN_FILE = "I.10";
public static final String OUT_FILE = "output.txt";

	public void solve() throws IOException {
		int starttime = 10 * 24 * 60;
                starttime += (11 * 60) + (11);
                
                int curTime = (nextInt() - 1 ) * 24 * 60;
                    curTime += (nextInt() * 60);
                    curTime += nextInt();
                    
               if(curTime < starttime) System.out.println(-1);
               else{
                       System.out.println(curTime - starttime);
               }
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Ctiming().run();
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