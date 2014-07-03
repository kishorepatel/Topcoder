import java.util.*;

public class RabbitStepping {
   public double getExpected(String field, int r) {
	int N = field.length();
        int total = 0;
        int rabbit = 0;
        for(int i = 1; i < (1 << N); i++){
            if(Integer.bitCount(i) == r){
                rabbit += Integer.bitCount(i & 0x55555) % 2;
                rabbit += Integer.bitCount(i & 0xaaaaa) % 2;
                total++;
            }
        }
        
        return 1.0 * rabbit / total;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RabbitSteppingHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RabbitSteppingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RabbitSteppingHarness {
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
			String field              = "WRBRW";
			int r                     = 4;
			double expected__         = 0.8;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}
		case 1: {
			String field              = "WWB";
			int r                     = 2;
			double expected__         = 1.3333333333333333;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}
		case 2: {
			String field              = "WW";
			int r                     = 1;
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}
		case 3: {
			String field              = "BBBBBBBBBB";
			int r                     = 4;
			double expected__         = 0.9523809523809523;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}
		case 4: {
			String field              = "RRBRRWRRBRRW";
			int r                     = 8;
			double expected__         = 0.9696969696969697;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}

		// custom cases

/*      case 5: {
			String field              = ;
			int r                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}*/
/*      case 6: {
			String field              = ;
			int r                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}*/
/*      case 7: {
			String field              = ;
			int r                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new RabbitStepping().getExpected(field, r));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
