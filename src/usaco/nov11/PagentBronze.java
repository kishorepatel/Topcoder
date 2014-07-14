/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.nov11;

import java.util.*;
import java.io.*;

public class PagentBronze implements Runnable {
public static final String IN_FILE = "I.10";
public static final String OUT_FILE = "output.txt";
        class Point{
                int x; int y;
                Point(int xx, int yy){ x = xx; y = yy;}
        }
        
        int[] dx = {0, 0, +1, -1};
        int[] dy = {+1, -1, 0, 0};
        int R, C;
        
	public void solve() throws IOException {
                Set<Point> oneSet = new HashSet<Point>();
                Set<Point> twoSet = new HashSet<Point>();
                
                R = nextInt(); C = nextInt();
                char[][] map = new char[R][C];
                for(int i = 0; i < R; i++) map[i] = nextToken().toCharArray();
                
                
                
                int id = 0;
                for(int i = 0; i < R; i++){
                        for(int j = 0; j < C; j++){
                                if(map[i][j] == 'X'){
                                        id++;
                                        floodfill(i, j, id, map);
                                }
                        }
                }
                
//                for(int i = 0; i < R; i++){
//                        for(int j = 0; j  < C; j++){
//                                System.out.print(map[i][j]);
//                        }
//                        System.out.println();
//                }
                
                for(int i = 0; i < R; i++){
                        for(int j = 0; j < C; j++){
                                if(map[i][j] == '.'){
                                        boolean one = false; boolean two = false;
                                        for(int k = 0; k < 4; k++){
                                                int ni = i + dx[k];
                                                int nj = j + dy[k];
                                                if(ni >= 0 && ni < R && nj >= 0 && nj < C){
                                                        if(map[ni][nj] == '1') one = true;
                                                        if(map[ni][nj] == '2') two = true;
                                                }
                                        }
                                        if(one) oneSet.add(new Point(i, j));
                                        if(two) twoSet.add(new Point(i, j));
                                }
                        }
                }
                
                //System.out.println(oneSet.size() + " " + twoSet.size());
                
                int ans = Integer.MAX_VALUE;
                for(Point o : oneSet)
                        for(Point t : twoSet)
                                ans = Math.min(ans, Math.abs(o.x - t.x) + Math.abs(o.y - t.y));
                
                System.out.println(ans + 1);
	}//***************REMOVE pkg***************

	public void floodfill(int i, int j, int id, char[][] map){
                map[i][j] = (char)(id + '0');
                
                for(int k = 0; k < 4; k++){
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if(ni >= 0 && ni < R && nj >= 0 && nj < C){
                                if(map[ni][nj] == 'X'){
                                        floodfill(ni, nj, id, map);
                                }
                        }
                }
        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new PagentBronze().run();
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