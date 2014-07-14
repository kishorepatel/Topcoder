
//package usaco.feb14;

import java.util.*;
import java.io.*;

public class Auto implements Runnable {
public static final String IN_FILE = "auto.in";
public static final String OUT_FILE = "auto.out";

        class Data implements Comparable<Data>{
                String s;
                int id;
                Data(String ss, int i){s = ss; id = i;}
                @Override
                public int compareTo(Data b){
                        return s.compareTo(b.s);
                }
        }
        
        
        int N, K;
        Data[] data;
	public void solve() throws IOException {
		N = nextInt(); K = nextInt();
                data = new Data[N];
                for(int i = 0; i < N; i++){
                        String cur = nextToken();
                        data[i] = new Data(cur, i);
                }
                
                Arrays.sort(data);
                
                for(int i = 0; i < K; i++){
                        int offset = nextInt();
                        String prefix = nextToken();
                        int low = 0, high = N;
                        while(low < high){
                                int  mid = (low + high) >> 1;
                                if(data[mid].s.compareTo(prefix) < 0) low = mid + 1;
                                else high = mid;
                        }
                        
                        if(data[low].s.startsWith(prefix)){
                                int curIndex = low + offset - 1;
                                if(curIndex >= N){
                                        out.println(-1);
                                        continue;
                                }
                                        
                                String ans = data[curIndex].s;
                                int id = data[curIndex].id;
                                if(ans.startsWith(prefix)){
                                        out.println(id + 1);
                                }
                                else
                                        out.println(-1);
                        }
                        else{
                                out.println(-1);
                        }
                }
                        
	}//***************REMOVE pkg***************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Auto().run();
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