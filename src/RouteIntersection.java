import java.util.*;

public class RouteIntersection {
   public String isValid(int N, int[] coords, String moves) {
	Map<Integer, Integer> list = new HashMap<Integer, Integer>();
        for(int i : coords) list.put(i, 0);
        Set<Map<Integer, Integer>> set = new HashSet<Map<Integer, Integer>>();
        set.add(new HashMap<Integer, Integer>(list));
        for(int i = 0; i < coords.length; i++){
            list.put(coords[i], list.get(coords[i]) + ((moves.charAt(i) == '+') ? 1 : -1));
            set.add(new HashMap<Integer, Integer>(list));
        }
        
        if(set.size() != coords.length + 1) return "NOT VALID";
        
        return "VALID";
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RouteIntersectionHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RouteIntersectionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RouteIntersectionHarness {
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
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}
	
	static int verifyCase(int casenum, String expected, String received) { 
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
			int N                     = 1;
			int[] coords              = {1};
			String moves              = "+";
			String expected__         = "VALID";

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}
		case 1: {
			int N                     = 2;
			int[] coords              = {1,2,1,2};
			String moves              = "++--";
			String expected__         = "NOT VALID";

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}
		case 2: {
			int N                     = 3;
			int[] coords              = {1,2,3,1,2};
			String moves              = "+++--";
			String expected__         = "VALID";

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}
		case 3: {
			int N                     = 344447;
			int[] coords              = {132,51717,628,344447,628,51717,344447,2};
			String moves              = "+-++-+--";
			String expected__         = "NOT VALID";

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}
		case 4: {
			int N                     = 1;
			int[] coords              = {1,1};
			String moves              = "+-";
			String expected__         = "NOT VALID";

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}
		case 5: {
			int N                     = 990630;
			int[] coords              = {833196,524568,361663,108056,28026,824639,269315,440977,440977,765458, 988451,242440,948414,130873,773990,765458,130873,28026,853121,553636, 581069,82254,735536,833196,898562,898562,940783,988451,540613,317306, 623194,940783,571384,988451,108056,514374,97664};
			String moves              = "--+---+-+++-+-+---++-++-+---+-+--+-++";
			String expected__         = "NOT VALID";

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}

		// custom cases

/*      case 6: {
			int N                     = ;
			int[] coords              = ;
			String moves              = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}*/
/*      case 7: {
			int N                     = ;
			int[] coords              = ;
			String moves              = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}*/
/*      case 8: {
			int N                     = ;
			int[] coords              = ;
			String moves              = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RouteIntersection().isValid(N, coords, moves));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
