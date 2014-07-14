/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usaco.nov11;

import java.util.*;
import java.io.*;

public class Digits implements Runnable {
public static final String IN_FILE = "I.10";
public static final String OUT_FILE = "OO.10";

	public void solve() throws IOException {
		char[] two = nextToken().toCharArray();
                String three = nextToken();
                
                for(int i = two.length - 1; i >= 0; i--){
                        if(two[i] == '0') two[i] = '1';
                        else two[i] = '0';
                        
                        int curtwo = base(two, 2);
                        String baseThree = convert(curtwo, 3); 
                        while(baseThree.length() < three.length())  baseThree = "0" + baseThree;
                        
                        int d = 0;
                        for(int k = 0; k < baseThree.length(); k++) if(baseThree.charAt(k) != three.charAt(k)) d++;
                        if(d == 1){
                                out.println(curtwo);
                                return;
                        }
                        
                        if(two[i] == '0') two[i] = '1';
                        else two[i] = '0';
                        
                }
                
                out.println(-1);
                
	}//***************REMOVE pkg***************

        public int base(char[] t, int base){
                int ans = 0;
                int power = 1;
                for(int i = t.length - 1; i >= 0; i--){
                        if(t[i] == '1'){
                                ans += (power);
                        }
                        power *= 2;
                }
                
                return ans;
        }
	
        public String convert(int curtwo, int base){
                String ans = "";
                while(curtwo > 0){
                        ans = (curtwo % base) + ans;
                        curtwo = curtwo / base;
                }
                
                return ans;
        }
        
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Digits().run();
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