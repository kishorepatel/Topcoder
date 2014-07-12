import java.util.*;

public class Circuits {
    
   public int howLong(String[] connects, String[] costs) {
      int INF = -99999999;
       int[][] graph = new int[55][55];
       for(int i = 0; i < 55; i++) Arrays.fill(graph[i], INF);
       
       for(int i = 0; i < 55; i++)  graph[i][i]  = 0;
       
       for(int i = 0; i < connects.length; i++){
           if(connects[i].length() > 0){
            String[] c = connects[i].split(" ");
            String[] cost = costs[i].split(" ");
            for(int k = 0; k < c.length; k++){
                graph[i][Integer.parseInt(c[k])] = Integer.parseInt(cost[k]);
            }
           }
       }
       
       for(int k = 0; k < 55; k++)
        for(int i = 0; i < 55; i++)
              for(int j = 0; j < 55; j++){
                    graph[i][j] = Math.max(graph[i][j], graph[i][k] + graph[k][j]);
              }
       
       int answer = 0;
       for(int i = 0; i < 55; i++)
           for(int j = 0; j < 55; j++)
                   answer = Math.max(answer, graph[i][j]);
                     
       
       return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CircuitsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CircuitsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CircuitsHarness {
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
			String[] connects         = {"1 2",
 "2",
 ""};
			String[] costs            = {"5 3",
 "7",
 ""};
			int expected__            = 12;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}
		case 1: {
			String[] connects         = {"1 2 3 4 5","2 3 4 5","3 4 5","4 5","5",""};
			String[] costs            = {"2 2 2 2 2","2 2 2 2","2 2 2","2 2","2",""};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}
		case 2: {
			String[] connects         = {"1","2","3","","5","6","7",""};
			String[] costs            = {"2","2","2","","3","3","3",""};
			int expected__            = 9;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}
		case 3: {
			String[] connects         = {"","2 3 5","4 5","5 6","7","7 8","8 9","10",
 "10 11 12","11","12","12",""};
			String[] costs            = {"","3 2 9","2 4","6 9","3","1 2","1 2","5",
 "5 6 9","2","5","3",""};
			int expected__            = 22;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}
		case 4: {
			String[] connects         = {"","2 3","3 4 5","4 6","5 6","7","5 7",""};
			String[] costs            = {"","30 50","19 6 40","12 10","35 23","8","11 20",""};
			int expected__            = 105;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}

		// custom cases

/*      case 5: {
			String[] connects         = ;
			String[] costs            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}*/
/*      case 6: {
			String[] connects         = ;
			String[] costs            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}*/
/*      case 7: {
			String[] connects         = ;
			String[] costs            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Circuits().howLong(connects, costs));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
