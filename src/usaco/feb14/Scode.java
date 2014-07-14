/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package usaco.feb14;

/**
 *
 * @author patel
 */
import java.util.*;
import java.io.*;

public class Scode implements Runnable {
public static final String IN_FILE = "scode.in";
public static final String OUT_FILE = "scode.out";
        
        public int doit(String s){
                int l = s.length();
                if(l % 2 == 0 || l == 1) return 1;
                
                int result = 1;
                
                //ABC -> AB + ABC
                if(s.substring(l/2).startsWith(s.substring(0, l/2))) result += doit(s.substring(l/2));
                //ABC -> ABC + AB
                if(s.substring(0, l/2 + 1).startsWith(s.substring(l/2 + 1))) result += doit(s.substring(0, l/2 + 1));
                //ABC -> ABC + BC
                if(s.substring(0, l/2 + 1).endsWith(s.substring(l/2 + 1))) result += doit(s.substring(0, l/2 + 1));
                //ABC -> BC + ABC
                if(s.substring(l/2).endsWith(s.substring(0, l/2))) result += doit(s.substring(l/2));
                
                return result;
        }
        
	public void solve() throws IOException {
		String s = nextToken();
                out.println(doit(s) - 1);                
        }//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Scode().run();
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