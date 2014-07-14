
package usaco.feb14;

import java.util.*;
import java.io.*;

public class Rblock implements Runnable {
public static final String IN_FILE = "rblock.in";
public static final String OUT_FILE = "rblock.out";
        
        class Pair implements Comparable<Pair>{
                int to;
                int cost;
                Pair(int t, int c){to = t; cost = c;}
                
                @Override
                public int compareTo(Pair b){
                        return cost - b.cost;
                }
        }
        
	public void solve() throws IOException {
		int N = nextInt();
                int M = nextInt();
                Map<Integer, ArrayList<Pair>> graph = new TreeMap<Integer, ArrayList<Pair>>();
                for(int i = 0; i < N; i++) graph.put(i, new ArrayList<Pair>());
                
                for(int i = 0; i < M; i++){
                        int a = nextInt() - 1;
                        int b = nextInt() - 1;
                        int c = nextInt();
                        graph.get(a).add(new Pair(b, c));
                        graph.get(b).add(new Pair(a, c));
                }
                
                int[] path = new int[N];
                Arrays.fill(path, -1);
                int actualCost = dijkistra(0, N, path, graph);
                
                List<Integer> pathList = new ArrayList<Integer>();
                for(int i = N - 1; i > -1 ; i = path[i]){
                        pathList.add(i);
                }
                
                int newCost = 0;
                for(int i = 0; i + 1 < pathList.size(); i++){
                        int a = pathList.get(i);
                        int b = pathList.get(i + 1);
                        for(int k = 0; k < graph.get(a).size(); k++){
                                Pair cur = graph.get(a).get(k);
                                if(cur.to == b)
                                        cur.cost = cur.cost * 2;
                        }
                        for(int k = 0; k < graph.get(b).size(); k++){
                                Pair cur = graph.get(b).get(k);
                                if(cur.to == a)
                                        cur.cost = cur.cost * 2;
                        }
                        
                        newCost = Math.max(newCost, dijkistra(0, N, path, graph));
                        
                        for(int k = 0; k < graph.get(a).size(); k++){
                                Pair cur = graph.get(a).get(k);
                                if(cur.to == b)
                                        cur.cost = cur.cost / 2;
                        }
                        for(int k = 0; k < graph.get(b).size(); k++){
                                Pair cur = graph.get(b).get(k);
                                if(cur.to == a)
                                        cur.cost = cur.cost / 2;
                        }
                        
                }
                
                out.println(newCost - actualCost);
                
	}//***************REMOVE pkg***************

        public int dijkistra(int start, int N, int[] path, Map<Integer, ArrayList<Pair>> graph){
                int[] d = new int[N];
                Arrays.fill(d, Integer.MAX_VALUE);
                
                d[start] = 0;
                Queue<Pair> pq = new PriorityQueue<Pair>();
                pq.add(new Pair(start, 0));
                
                while(!pq.isEmpty()){
                        Pair p = pq.poll(); 
                        for (Pair c : graph.get(p.to)) {
                                
                                if(d[c.to] > (p.cost + c.cost)){
                                        d[c.to] = p.cost + c.cost;
                                        pq.add(new Pair(c.to, d[c.to]));
                                        path[c.to] = p.to;
                                }
                        }
                }
                
                return d[N-1];
        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Rblock().run();
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