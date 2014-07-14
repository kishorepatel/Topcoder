
package usaco.nov13;

import java.util.*;
import java.io.*;

public class Milktemp implements Runnable {
public static final String IN_FILE = "milktemp.in";
public static final String OUT_FILE = "milktemp.out";

        
	public void solve() throws IOException {
                int N = nextInt();
                int X = nextInt(); int Y = nextInt(); int Z = nextInt();
                int[] a = new int[N + 1];
                int[] b  = new int[N + 1];
                for(int i = 0; i < N; i++){ a[i] = nextInt(); b[i] = nextInt(); }
                a[N] = 1000000005;
                b[N] = 1000000005;
                
                Arrays.sort(a); Arrays.sort(b);
                
                int i = 0; int j = 0;
                int cur_milk = N * X;
                int answer = N * X;
                
                while(i < N || j < N){
                        if(a[i] <= b[j]){
                                cur_milk += Y - X;
                                i++;
                        }
                        else{
                                cur_milk += Z - Y;
                                j++;
                        }
                        
                        answer = Math.max(answer, cur_milk);
                }
                
                out.println(answer);
                              
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Milktemp().run();
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