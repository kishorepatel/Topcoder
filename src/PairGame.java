import java.util.*;

public class PairGame {
   public int maxSum(int a, int b, int c, int d) {
       while(a > 0 && b > 0 && c > 0 && d > 0){
           if(a == c && b == d) return a + b;
           if(Math.max(a, b) > Math.max(c, d)){
                if(a > b)
                    a -= b;
                else 
                    b -= a;
           }
           else{
               if(c > d)
                   c -= d;
               else
                   d -= c;
           }
       }
       return -1;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			PairGameHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PairGameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class PairGameHarness {
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
			int a                     = 1;
			int b                     = 2;
			int c                     = 2;
			int d                     = 1;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}
		case 1: {
			int a                     = 15;
			int b                     = 4;
			int c                     = 10;
			int d                     = 7;
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}
		case 2: {
			int a                     = 1;
			int b                     = 1;
			int c                     = 10;
			int d                     = 10;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}
		case 3: {
			int a                     = 1000;
			int b                     = 1001;
			int c                     = 2000;
			int d                     = 2001;
			int expected__            = 1001;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}
		case 4: {
			int a                     = 10944;
			int b                     = 17928;
			int c                     = 7704;
			int d                     = 21888;
			int expected__            = 144;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}
		case 5: {
			int a                     = 1;
			int b                     = 1;
			int c                     = 1;
			int d                     = 1;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}

		// custom cases

/*      case 6: {
			int a                     = ;
			int b                     = ;
			int c                     = ;
			int d                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}*/
/*      case 7: {
			int a                     = ;
			int b                     = ;
			int c                     = ;
			int d                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}*/
/*      case 8: {
			int a                     = ;
			int b                     = ;
			int c                     = ;
			int d                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PairGame().maxSum(a, b, c, d));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
