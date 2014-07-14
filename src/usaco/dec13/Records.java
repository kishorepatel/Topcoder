/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.dec13;

import java.util.*;
import java.io.*;

public class Records implements Runnable {
public static final String IN_FILE = "records.in";
public static final String OUT_FILE = "records.out";

	public void solve() throws IOException {
		int N = nextInt();
                Map<String, Integer> map = new HashMap<String, Integer>();
                for(int i = 0; i < N; i++){
                        String[] s = new String[3];
                        for(int k = 0; k < 3; k++) s[k] = nextToken();
                        Arrays.sort(s);
                        
                        String cur = s[0] + "$" + s[1] + " $" + s[2];
                        if(map.containsKey(cur)) map.put(cur, map.get(cur) + 1);
                        else map.put(cur, 1);
                }
                
                int ans = 0;
                for(Map.Entry<String, Integer> me : map.entrySet()){
                        if(me.getValue() > ans) ans = me.getValue();
                }
                
                out.println(ans);
        
                
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Records().run();
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
