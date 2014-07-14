/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.jan12;

import java.util.*;
import java.io.*;

public class Gifts implements Runnable {
public static final String IN_FILE = "10.in";
public static final String OUT_FILE = "O.10";


        class Gift implements Comparable<Gift>{
                int id, p, t;
                Gift(int i, int P, int T){
                        id = i; p = P; t = T;
                }
                public int compareTo(Gift b){
                        return (p + t) - (b.p + b.t);
                }
        }
        
	public void solve() throws IOException {
		int N = nextInt();
                int money = nextInt();
                Gift[] gifts = new Gift[N];
                for(int i = 0; i < N; i++){
                        gifts[i] = new Gift(i, nextInt(), nextInt());
                }
                
                Gift[] cpGifts = gifts.clone();
                Arrays.sort(gifts);
                
                int ans = 0;
                for(int i = 0; i < N; i++){
                        int remainMoney = money;
                        remainMoney -= (cpGifts[i].p / 2 + cpGifts[i].t);
                        if(remainMoney < 0) continue;
                        int cnt = 1;
                        for(int k = 0; k < N; k++){
                                if(i != gifts[k].id && remainMoney >= (gifts[k].p + gifts[k].t)){
                                        cnt++;
                                        remainMoney -= gifts[k].p + gifts[k].t;
                                }
                        }
                        
                        ans = Math.max(ans, cnt);
                }
                
                out.println(ans);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Gifts().run();
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
