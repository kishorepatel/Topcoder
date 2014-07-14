package usaco.dec11;

import java.util.*;
import java.io.*;

public class Escape implements Runnable {

public static final String IN_FILE = "I.10";
public static final String OUT_FILE = "OO.10";

	public void solve() throws IOException {
		int N = nextInt();
                int[][] cows = new int[N][10]; // n, digit
                for(int i = 0; i < N; i++){
                        int cow = nextInt();
                        int k = 0;
                        while(cow > 0){
                                cows[i][k] = cow % 10;
                                cow = cow / 10;
                                k++;
                        }
                }
                
                int group = 0;
                for(int i = 1; i < (1 << N); i++){
                        if(Integer.bitCount(i) <= group) continue;
                        int[] placeSum = new int[10];
                        for(int j = 0; j < N; j++){
                                if( (i & (1 << j)) > 0){
                                        for(int k = 0; k < 10; k++) placeSum[k] += cows[j][k];
                                }
                        }
                        
                        boolean ok = true;
                        for(int k = 0; k < 10; k++) if(placeSum[k] > 9) {ok = false; break;}
                        if(ok){
                                //System.out.println(Integer.toBinaryString(i));
                                group = Math.max(group, Integer.bitCount(i));
                        }
                }
                
                out.println(group);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Escape().run();
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