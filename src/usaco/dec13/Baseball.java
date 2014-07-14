
package usaco.dec13;

import java.util.*;
import java.io.*;

public class Baseball implements Runnable {
public static final String IN_FILE = "baseball.in";
public static final String OUT_FILE = "baseball.out";


        public int index_of(int value){
                int l = 0; int r = N;
                while(l < r){
                        int mid = (l + r) >> 1;
                        if(a[mid] < value) l = mid + 1;
                        else r = mid;
                }
                
                return l;
        }
        
        public int compute_triplet(int a, int b){
                return index_of(b + 1) - index_of(a);
        }

        int N;
        int[] a;
	public void solve() throws IOException {
		N = nextInt();
                a = new int[N + 1];
                for(int i = 0; i < N; i++) a[i] = nextInt();
                
                a[N] = 100000000 + 5;
                Arrays.sort(a);
                
                int answer = 0;
                for(int i = 0; i < N; i++){
                        for(int j = i + 1; j < N; j++){
                                int d = a[j] - a[i];
                                answer += compute_triplet(a[j] + d, a[j] + 2 * d);
                        }
                }
                
                out.println(answer);
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Baseball().run();
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
