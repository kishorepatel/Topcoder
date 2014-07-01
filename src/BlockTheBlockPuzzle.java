import java.util.*;

public class BlockTheBlockPuzzle {
   public int minimumHoles(String[] board) {
		
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
