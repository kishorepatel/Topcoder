
package usaco.mar14;

import java.util.*;
import java.io.*;

public class Lazy implements Runnable {
public static final String IN_FILE = "lazy.in";
public static final String OUT_FILE = "lazy.out";

        static class Grass implements Comparable<Grass>{
                int location;
                int qty;
                Grass(int qty, int location){
                        this.location = location;
                        this.qty = qty;
                }
                
                @Override
                public int compareTo(Grass b){
                        return location - b.location;
                }
        }
        
        
	public void solve() throws IOException {
		int N = nextInt(), K = nextInt();
                Grass[] grass = new Grass[N];
                for(int i = 0; i < N; i++)
                        grass[i] = new Grass(nextInt(), nextInt());
                
                Arrays.sort(grass);
                
               
                K = 2 * K;
                
                int answer = 0;
                //select a location(obviously a grass location) and move forward within 2 * K, which you can eat
                
                int curGrass = 0;
                int j = 0;
                for(int i = 0; i < N; i++){
                        while(j < N && (grass[j].location - grass[i].location <= K)){  curGrass += grass[j].qty; j++;}
                        answer = Math.max(answer, curGrass);
                        curGrass -= grass[i].qty;
                }
                
                out.println(answer);
                
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Lazy().run();
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
