import java.util.*;

public class CentaurCompanyDiv2 {
    
    public long dfs(int root){
        if(was[root]) return 1;
        was[root] = true;
        long res = 1;
        for(int i = 0; i < graph[root].size(); i++){
            res = res * (dfs(graph[root].get(i))); //result with this node
        }
        
        
        answer += res; // result for each node as root
        
        res++; // PLUS if this node is not selected then none of the node below it are.// NOT SELECTING THIS NODE
        d[root] = res;
        return res;
    }
    
    long[] d;
    long answer;
    List<Integer>[] graph;
    boolean[] was;
   public long count(int[] a, int[] b) {
       answer = 1;
       
       int N = a.length + 1;
       graph = new ArrayList[N];
       d = new long[N];
       for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();
       was = new boolean[N];
       for(int i = 0; i < N-1; i++){
           int from  = a[i] - 1;
           int to = b[i] - 1;
           graph[from].add(to);
           graph[to].add(from);
       }
       
       dfs(0); //count the number of subtree formation  possible in the graph;
       
       for(int i = 0; i < N; i++){
           System.out.println(i + " " + d[i]);
       }
       
       return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CentaurCompanyDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CentaurCompanyDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CentaurCompanyDiv2Harness {
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
			int[] a                   = {1};
			int[] b                   = {2};
			long expected__           = 4;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}
		case 1: {
			int[] a                   = {2,2};
			int[] b                   = {1,3};
			long expected__           = 7;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}
		case 2: {
			int[] a                   = {1,2,3,4,5,6,7,8,9};
			int[] b                   = {2,3,4,5,6,7,8,9,10};
			long expected__           = 56;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}
		case 3: {
			int[] a                   = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
			int[] b                   = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
			long expected__           = 1125899906842675L;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}
		case 4: {
			int[] a                   = {10, 7, 2, 5, 6, 2, 4, 9, 7};
			int[] b                   = {8, 10, 10, 4, 1, 6, 2, 2, 3};
			long expected__           = 144;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}

		// custom cases

/*      case 5: {
			int[] a                   = ;
			int[] b                   = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}*/
/*      case 6: {
			int[] a                   = ;
			int[] b                   = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}*/
/*      case 7: {
			int[] a                   = ;
			int[] b                   = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new CentaurCompanyDiv2().count(a, b));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
