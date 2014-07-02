import java.util.*;

public class FixedDiceGameDiv1 {

   public double getExpectation(int a, int b, int c, int d) {
		
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FixedDiceGameDiv1Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FixedDiceGameDiv1Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FixedDiceGameDiv1Harness {
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
	
	static final double MAX_DOUBLE_ERROR = 1E-9;
	static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
	static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }
	
	static String formatResult(double res) {
		return String.format("%.10g", res);
	}
	
	static int verifyCase(int casenum, double expected, double received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			int a                     = 1;
			int b                     = 2;
			int c                     = 1;
			int d                     = 5;
			double expected__         = 2.0;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}
		case 1: {
			int a                     = 3;
			int b                     = 1;
			int c                     = 1;
			int d                     = 3;
			double expected__         = 3.0;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}
		case 2: {
			int a                     = 1;
			int b                     = 5;
			int c                     = 1;
			int d                     = 1;
			double expected__         = 3.4999999999999996;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}
		case 3: {
			int a                     = 2;
			int b                     = 6;
			int c                     = 50;
			int d                     = 30;
			double expected__         = -1.0;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}
		case 4: {
			int a                     = 50;
			int b                     = 11;
			int c                     = 50;
			int d                     = 50;
			double expected__         = 369.8865999182022;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}

		// custom cases

/*      case 5: {
			int a                     = ;
			int b                     = ;
			int c                     = ;
			int d                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}*/
/*      case 6: {
			int a                     = ;
			int b                     = ;
			int c                     = ;
			int d                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}*/
/*      case 7: {
			int a                     = ;
			int b                     = ;
			int c                     = ;
			int d                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new FixedDiceGameDiv1().getExpectation(a, b, c, d));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
