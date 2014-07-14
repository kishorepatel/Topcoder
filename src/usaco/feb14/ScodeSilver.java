/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package usaco.feb14;

import java.util.*;
import java.io.*;

public class ScodeSilver implements Runnable {
public static final String IN_FILE = "scode.in";
public static final String OUT_FILE = "scode.out";

        public static final int MOD = 2014;
        Map<String, Integer> memo = new HashMap<String, Integer>();
        
        public int doit(String s){
                if(memo.containsKey(s)) return memo.get(s);
                
                int result = 1;
                int len = s.length();
                
                for(int i = 1; i * 2 < len; i++){
                        // abc -> a + abc 2
                        if(s.substring(0, i).compareTo(s.substring(i, i + i)) == 0) result += doit(s.substring(i));
                        //abc -> c + abc 1
                        if(s.substring(0,i).compareTo(s.substring(len-i)) == 0) result += doit(s.substring(i));
                        //abc -> abc + a
                        if(s.substring(0, i).compareTo(s.substring(len-i)) == 0) result += doit(s.substring(0, len - i));
                        //abc -> abc + c
                        if(s.substring(len - i).compareTo(s.substring(len - (2 * i), len - i)) == 0) result += doit(s.substring(0, len - i));
                        
                }
                
                
                
                
                result = result % MOD;
                memo.put(s, result);
                return result;
        }
	public void solve() throws IOException {
		String s = nextToken();
                int answer = doit(s) - 1;
                //it may get negative => (doit(s) - 1 + M) % MOD;
                answer = (answer + MOD) % MOD;
                
                out.println(answer);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new ScodeSilver().run();
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