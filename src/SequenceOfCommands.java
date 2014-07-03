import java.util.*;

public class SequenceOfCommands {
    int[] dx = {0, +1, 0, -1};
    int[] dy = {+1, 0, -1, 0};
   public String whatHappens(String[] commands) {
       int dir = 0;
       int x = 0, y = 0;
       for(int i = 0; i < commands.length; i++){
           for(char c : commands[i].toCharArray()){
               if(c == 'S'){
                   x += dx[dir];
                   y += dy[dir];
               }
               else if(c == 'L'){
                   dir = (dir + 4 - 1) % 4;
               }
               else if(c == 'R'){
                   dir = (dir + 1) % 4;
               }
           }
       }
       
       if(dir == 0 && x == 0 && y == 0) return "bounded";
       else if(dir == 0) return "unbounded";
       else return "bounded";
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SequenceOfCommandsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SequenceOfCommandsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SequenceOfCommandsHarness {
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
			String[] commands         = {"L"};
			String expected__         = "bounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}
		case 1: {
			String[] commands         = {"SRSL"};
			String expected__         = "unbounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}
		case 2: {
			String[] commands         = {"SSSS","R"};
			String expected__         = "bounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}
		case 3: {
			String[] commands         = {"SRSL","LLSSSSSSL","SSSSSS","L"};
			String expected__         = "unbounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}

		// custom cases

/*      case 4: {
			String[] commands         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}*/
/*      case 5: {
			String[] commands         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}*/
/*      case 6: {
			String[] commands         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
