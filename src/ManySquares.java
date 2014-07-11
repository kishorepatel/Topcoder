import java.util.*;

public class ManySquares {
   public int howManySquares(int[] sticks) {
	int[] cnt = new int[2000];
        for(int i : sticks) cnt[i]++;
        
        int ans = 0;
        for(int i = 0 ; i < cnt.length; i++) ans += cnt[i] / 4;
        
        return ans;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ManySquaresHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ManySquaresHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ManySquaresHarness {
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
			int[] sticks              = {1,1,2,2,1,1,2};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}
		case 1: {
			int[] sticks              = {3, 1, 4, 4, 4, 10, 10, 10, 10} ;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}
		case 2: {
			int[] sticks              = {1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,3,3};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}
		case 3: {
			int[] sticks              = {1,1,1,2,2,2,3,3,3,4,4,4};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}
		case 4: {
			int[] sticks              = {1,1,1,2,1,1,1,3,1,1,1};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}
		case 5: {
			int[] sticks              = {2,2,4,4,8,8};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}

		// custom cases

/*      case 6: {
			int[] sticks              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}*/
/*      case 7: {
			int[] sticks              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}*/
/*      case 8: {
			int[] sticks              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ManySquares().howManySquares(sticks));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
