package HackerRank.weekly_2014july.MinAvgCookTime;

import java.util.*;
import java.io.*;

public class Solution implements Runnable {
        class Person{
            int enter, pizzaTime;
            Person(int e, int p){
                enter = e;
                pizzaTime = p;
            }
        }
        
        class TimeCompar implements Comparator<Person>{
            public int compare(Person a, Person b){
                return a.enter - b.enter;
            }
        }
        
        class CookCompar implements Comparator<Person>{
            public int compare(Person a, Person b){
                return a.pizzaTime - b.pizzaTime;
            }
        }
        
	public void solve() throws IOException {
            int N = nextInt();
            int _n = N;
            PriorityQueue<Person> pqTime = new PriorityQueue<Person>(N, new TimeCompar());
            PriorityQueue<Person> pqCook = new PriorityQueue<Person>(N, new CookCompar());
            for(int i = 0; i < N; i++){
                int arrival = nextInt();
                int pTime = nextInt();
                pqTime.add(new Person(arrival, pTime));
            }
            
            
            
            long totalTime = 0;
            long curTime = 0;
            while(N > 0){
                while(!pqTime.isEmpty() && pqTime.peek().enter <= curTime){
                    pqCook.add(pqTime.poll());
                }
                if(pqCook.isEmpty()){
                    curTime = pqTime.peek().enter;
                    continue;
                }
                
                //now there is someone whom I can serve
                Person cust = pqCook.poll();
                //serve Him
                curTime += (long)cust.pizzaTime;
                // customer total wait time is noted
                totalTime += ((long)curTime - (long)cust.enter);
                N--;
            }
            
            double answer = (totalTime * 1.0) / _n;
            answer += 0.5;
            
            long result = (long)(answer);
            System.out.print(result);
	}
        
        
        
        

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Solution().run();
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
			in = new BufferedReader(new InputStreamReader(System.in));
			tok = null;
			solve();
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

	BufferedReader in;
	StringTokenizer tok;
}