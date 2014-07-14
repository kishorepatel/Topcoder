import java.util.*;

public class ThreeColorabilityEasy {
   public String isColorable(String[] cells) {
	for(int i = 0; i < cells.length - 1; i++)
            for(int j = 0; j < cells[0].length() - 1; j++){
                int count = 0;
                if(cells[i].charAt(j) == 'N')count++;
                if(cells[i+1].charAt(j) == 'N')count++;
                if(cells[i].charAt(j+1) == 'N')count++;
                if(cells[i+1].charAt(j+1) == 'N')count++;
                if(count % 2 == 1) return "No";
            }
        
        return "Yes";
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ThreeColorabilityEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ThreeColorabilityEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ThreeColorabilityEasyHarness {
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
			String[] cells            = {"Z"};
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}
		case 1: {
			String[] cells            = {"NZ"
,"NZ"};
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}
		case 2: {
			String[] cells            = {"ZZZ"
,"ZNZ"};
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}
		case 3: {
			String[] cells            = {"NZNZNNN"
,"NNZNNNZ"
,"NNNNZZZ"
,"ZZZNZZN"
,"ZZNZNNN"
,"NZZZZNN"
,"ZZZNZNN"};
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}
		case 4: {
			String[] cells            = {"ZZZZ"
,"ZZZZ"
,"ZZZZ"};
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}

		// custom cases

/*      case 5: {
			String[] cells            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}*/
/*      case 6: {
			String[] cells            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}*/
/*      case 7: {
			String[] cells            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ThreeColorabilityEasy().isColorable(cells));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
