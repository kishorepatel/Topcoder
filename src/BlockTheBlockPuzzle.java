import java.util.*;

public class BlockTheBlockPuzzle {
        class Edge{
        int to, from, cap, flow;
        Edge rev;
        public Edge(int f, int t, int c){
            this.to = t; this.from =f ; this.cap = c;
            rev = null;
        }
    }
    
    public void addEdge(int from, int to, int cap){
        Edge e1 = new Edge(from, to, cap);
        Edge e2 = new Edge(to, from, 0);
        e1.rev = e2;
        e2.rev = e1;
        graph[from].add(e1);
        graph[to].add(e2);
    }
    
    private boolean dfs(int s, int t){
        if(was[s]) return false;
        was[s] = true;
        if(s == t) return true;
        for(int i = 0; i < graph[s].size(); i++){
            Edge c = graph[s].get(i);
            if(c.flow < c.cap && dfs(c.to, t)){
                c.flow++;
                c.rev.flow--;
                return true;
            }
        }
        return false;
    }
    
    private int minCut(int s, int t){
        int flow = 0;
        while(true){
            Arrays.fill(was, false);
            if(dfs(s, t))
                flow++;
            else 
                break;
        }
        
        return flow;
    }
    
    
    List<Edge>[] graph;
    boolean[] was;
    final int INF = 1000;
    int N;
    
    public int id(int x, int y, int inOut){
        return inOut * N * N + x * N + y + 1;
    }
    
   public int minimumHoles(String[] board) {
       //querty code
       N = board.length;
       int sz = 1 + 2 * N * N + 1;
       graph = new ArrayList[sz];
       for(int i = 0; i <sz; i++) graph[i] = new ArrayList<>();
       was = new boolean[sz];
       
       int gi = -1; int gj = -1;
       
       
       for(int i = 0; i < N; i++)
           for(int j = 0; j < N; j++){
               char c = board[i].charAt(j);
               if(c == '.'){
                   addEdge(id(i, j, 0), id(i, j, 1), 1);
               }
               else if(c != 'H'){
                   addEdge(id(i, j, 0), id(i, j, 1), INF);
               }
           }
       
       for(int i = 0; i < N; i++)
           for(int j = 0; j < N; j++)
               if(board[i].charAt(j) == '$'){
                   addEdge(id(i, j, 1), sz-1, INF);
                   gi = i;
                   gj = j;
               }
       
       
       for(int i = 0; i < N; i++)
           for(int j = 0; j < N; j++)
               if(board[i].charAt(j) == 'b')
                   if(i%3 == gi%3 && j%3 == gj%3){
                       addEdge(0, id(i, j, 0), INF);
                   }
       
       for(int i = 0; i < N; i++)
           for(int j = 0; j < N; j++)
               if(i%3 == gi%3 && j%3 == gj%3){
                   if(i+3 < N){
                       addEdge(id(i, j, 1), id(i+1, j, 0), INF);
                       addEdge(id(i, j, 1), id(i+2, j, 0), INF);
                       addEdge(id(i+1, j, 1), id(i+3, j, 0), INF);
                       addEdge(id(i+2, j, 1), id(i+3, j, 0), INF);
                   }
                   if(i - 3 >= 0){
                       addEdge(id(i, j, 1), id(i-1, j, 0), INF);
                       addEdge(id(i, j, 1), id(i-2, j, 0), INF);
                       addEdge(id(i-1, j, 1), id(i-3, j, 0), INF);
                       addEdge(id(i-2, j, 1), id(i-3, j, 0), INF);
                   }
                   if(j+3<N){
                       addEdge(id(i, j, 1), id(i, j+1, 0), INF);
                       addEdge(id(i, j, 1), id(i, j+2, 0), INF);
                       addEdge(id(i, j+1, 1), id(i, j+3, 0), INF);
                       addEdge(id(i, j+2, 1), id(i, j+3, 0), INF);
                   }
                   if(j-3 >= 0){
                       addEdge(id(i, j, 1), id(i, j-1, 0), INF);
                       addEdge(id(i, j, 1), id(i, j-2, 0), INF);
                       addEdge(id(i, j-1, 1), id(i, j-3, 0), INF);
                       addEdge(id(i, j-2, 1), id(i, j-3, 0), INF);
                   }                   
               }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
//       for(int i = gi%3; i < N; i += 3)
//           for(int j = gj%3; j < 3; j += 3){
//               for(int dx = -1; dx <= 1; dx++)
//                   for(int dy = -1; dy <= 1; dy++)
//                       if(Math.abs(dx) + Math.abs(dy) == 1){
//                           int ni = i + 3 * dx; int nj = j + 3 * dy;
//                           if(ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni].charAt(nj) != 'H' && board[i].charAt(j) != 'H'){
//                               
//                               char c1 = board[i+dx].charAt(j+dy);
//                               char c2 = board[i+ 2*dx].charAt(j + 2 * dy);
//                               int cap = 0;
//                               if(c1 == 'b' || c2 == 'b'){
//                                   cap = INF;
//                               }
//                               else{
//                                   if(c1 == '.') cap++;
//                                   if(c2 == '.') cap++;
//                               }
//                               
//                               addEdge(id(i, j, 1), id(ni, nj, 0), cap);
//                           }
//                       }
//           }
       
       int answer = minCut(0, sz-1);
       if(answer >= 50){
           return -1;
       }
       
       return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BlockTheBlockPuzzleHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BlockTheBlockPuzzleHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BlockTheBlockPuzzleHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			String[] board            = {"b..$",
 "....",
 "HHHH",
 "HHHH"};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}
		case 1: {
			String[] board            = {"............H..",
 "...............",
 "...............",
 "HHH$HHH.....H..",
 "HHHHHHH........",
 "HHHHHHHH.......",
 "......b..H.....",
 "...............",
 "...............",
 "...H..H..H.....",
 "...............",
 "...............",
 "...............",
 "...............",
 "..............."};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}
		case 2: {
			String[] board            = {"............H..",
 "...............",
 "...............",
 "HHH$HHH........",
 "HHHHHHH........",
 "HHHHHHHH.......",
 "......b..H.....",
 "...............",
 "...............",
 "...H..H..H.....",
 "...............",
 "...............",
 "...............",
 "...............",
 "..............."};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}
		case 3: {
			String[] board            = {"b..$...",
 "...H...",
 ".......",
 "b..b..b",
 "...H...",
 ".......",
 "b..b..b"}

;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}
		case 4: {
			String[] board            = {"b..b..b",
 "..b..b.",
 ".......",
 "b..$bbb",
 ".b.....",
 "....b..",
 "b..b..b"}
;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}

		// custom cases

/*      case 5: {
			String[] board            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}*/
/*      case 6: {
			String[] board            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}*/
/*      case 7: {
			String[] board            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
