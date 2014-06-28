import java.util.*;

public class NegativeGraphDiv2 {
    int[][] dp;
    List<Edge>[] graph;
    int N;
    class Edge{
        int to, w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
    
    
   public long findMin(int _N, int[] s, int[] t, int[] weight, int charges) {
       N = _N;
       dp = new int[N][charges + 1];
       for(int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
       
       graph = new ArrayList[N];
       for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();
       for(int i = 0; i < s.length; i++){
           graph[s[i] - 1].add(new Edge(t[i] - 1 , weight[i]));
           graph[s[i] - 1].add(new Edge(t[i]  - 1,-weight[i]));
       }
       
       dp[0][charges] = 0;
       dfs(0, charges, 0); //vertex, AvailCharge, currentCost
       
       int answer = Integer.MAX_VALUE;
       for(int i = 0; i <= charges; i++) answer = Math.min(dp[N-1][i], answer);
       
       return answer;
   }
   
   public void dfs(int v, int availCharge, int currentCost){
       for(int i = 0; i < graph[v].size(); i++){
           Edge c = graph[v].get(i);
           if(c.w < 0){
               //means we are using charge
               //System.err.println(N + " " + c.to );
               if(availCharge > 0 && dp[c.to][availCharge - 1] > currentCost + c.w){
                    dp[c.to][availCharge - 1] = currentCost + c.w;
                    dfs(c.to, availCharge - 1, currentCost + c.w);
                }
           }
           else{
               if(dp[c.to][availCharge] > currentCost + c.w){
                    dp[c.to][availCharge] = currentCost + c.w;
                    dfs(c.to, availCharge, currentCost + c.w);
               }
           }
       }
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			NegativeGraphDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				NegativeGraphDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class NegativeGraphDiv2Harness {
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
	
	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, long expected, long received) { 
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
			int N                     = 3;
			int[] s                   = {1,1,2,2,3,3};
			int[] t                   = {2,3,1,3,1,2};
			int[] weight              = {1,5,1,10,1,1};
			int charges               = 1;
			long expected__           = -9;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}
		case 1: {
			int N                     = 1;
			int[] s                   = {1};
			int[] t                   = {1};
			int[] weight              = {100};
			int charges               = 1000;
			long expected__           = -100000;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}
		case 2: {
			int N                     = 2;
			int[] s                   = {1,1,2};
			int[] t                   = {2,2,1};
			int[] weight              = {6,1,4};
			int charges               = 2;
			long expected__           = -9;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}
		case 3: {
			int N                     = 2;
			int[] s                   = {1};
			int[] t                   = {2};
			int[] weight              = {98765};
			int charges               = 100;
			long expected__           = -98765;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}

		// custom cases

/*      case 4: {
			int N                     = ;
			int[] s                   = ;
			int[] t                   = ;
			int[] weight              = ;
			int charges               = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}*/
/*      case 5: {
			int N                     = ;
			int[] s                   = ;
			int[] t                   = ;
			int[] weight              = ;
			int charges               = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}*/
/*      case 6: {
			int N                     = ;
			int[] s                   = ;
			int[] t                   = ;
			int[] weight              = ;
			int charges               = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
