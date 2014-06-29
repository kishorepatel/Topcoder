import java.util.*;

public class CostOfDancing {
   public int minimum(int K, int[] danceCost) {
	Arrays.sort(danceCost);
        int answer = 0;
        for(int i = 0; i < K; i++)  answer += danceCost[i];
        
        return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CostOfDancingHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CostOfDancingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CostOfDancingHarness {
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
			int K                     = 2;
			int[] danceCost           = {1, 5, 3, 4};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}
		case 1: {
			int K                     = 3;
			int[] danceCost           = {1, 5, 4};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}
		case 2: {
			int K                     = 1;
			int[] danceCost           = {2, 2, 4, 5, 3};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}
		case 3: {
			int K                     = 39;
			int[] danceCost           = {973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932, 703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801};
			int expected__            = 20431;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}

		// custom cases

/*      case 4: {
			int K                     = ;
			int[] danceCost           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}*/
/*      case 5: {
			int K                     = ;
			int[] danceCost           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}*/
/*      case 6: {
			int K                     = ;
			int[] danceCost           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CostOfDancing().minimum(K, danceCost));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
