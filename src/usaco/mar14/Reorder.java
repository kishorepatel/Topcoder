
//package usaco.mar14;

import java.util.*;
import java.io.*;

public class Reorder implements Runnable {
public static final String IN_FILE = "reorder.in";
public static final String OUT_FILE = "reorder.out";

        static class Cow{
                int c ;
                int next = -1;
                Cow(int p){c = p;}
        }
        
        
	public void solve() throws IOException {
		int N = nextInt();
                int[] a = new int[N];
                for(int i = 0; i < N; i++) a[i] = nextInt() -1;
                int[] b = new int[N];
                for(int i = 0; i < N; i++) b[i] = nextInt() - 1;
                
                
                int cycles = 0;
                int longestCycle = -1;
                
                while(true){
                        if(isEqual(a, b)) break;
                        cycles++;
                        int[] temp = new int[N];
                        Arrays.fill(temp, -1);
                        
                        int ind = 0;
                        while(a[ind] == b[ind]) ind++;
                        
                        int cow = a[ind];
                        while(true){
                                int nextCow = -1;
                                int j = 0;
                                for(j = 0; j < N; j++){
                                        if(b[j] == cow) break;
                                }
                                
                                if(temp[j] != -1) break;
                                temp[j] = cow;
                                cow = a[j];
                        }
                        
                        int curLen = 0;
                        for(int i = 0; i < N; i++) if(temp[i] != -1){ a[i] = temp[i]; curLen++;}
                        
                        longestCycle = Math.max(longestCycle, curLen);
                }
                
                
                out.println(cycles + " " + longestCycle);
	}//***************REMOVE pkg***************

	public boolean isEqual(int[] a, int[] b){
                for(int i = 0; i < a.length; i++) if(a[i] != b[i]) return false;
                return true;
        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Reorder().run();
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
