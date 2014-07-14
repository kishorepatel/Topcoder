/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.nov11;

import java.util.*;
import java.io.*;

public class LineUp implements Runnable {
public static final String IN_FILE = "I.12";
public static final String OUT_FILE = "OO.12";

        class Cow implements Comparable<Cow>{
                int x, type;
                Cow(int i, int t){x = i; type = t;}
                public int compareTo(Cow b){
                        return x - b.x;
                }
        }
        
        
	public void solve() throws IOException {
                int N = nextInt();
                Cow[] cows = new Cow[N];
                Set<Integer> set = new HashSet<Integer>();
                for(int i = 0; i < N; i++){
                        cows[i] = new Cow(nextInt(), nextInt());
                        set.add(cows[i].type);
                }
                
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int t : set) map.put(t,0);
                int idTypes =  set.size();
                
                Arrays.sort(cows);
                int l = 0, r = 0;
                int curTypes = 0;
                
                int ans = Integer.MAX_VALUE;
                while(true){
                        
                        while(r < N && curTypes < idTypes){
                                        if(map.get(cows[r].type) == 0) curTypes++;
                                        map.put(cows[r].type, map.get(cows[r].type) + 1);
                                        r++;
                        }
                        
                        if(r == N && curTypes != idTypes) break;
                        
                        while(map.get(cows[l].type) > 1){
                                map.put(cows[l].type, map.get(cows[l].type) - 1);
                                l++;
                        }
                        
                        if(cows[r - 1].x - cows[l].x < ans) ans = cows[r - 1].x - cows[l].x;
                        map.put(cows[l].type, map.get(cows[l].type) - 1);
                        l++;
                        curTypes--;
                }
                
                out.println(ans);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new LineUp().run();
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