import java.util.*;

public class HappyLetterDiv2 {
   public char getHappyLetter(String letters) {
	int N = letters.length();
        int[] cnt = new int[26];
        for(char c : letters.toCharArray()) cnt[c - 'a']++;
        int max = 0;
        for(int i = 0; i < 26; i++) max = Math.max(max, cnt[i]);
        
        
        
        
            int half = N / 2;
            if(max > half){
                for(int i = 0; i < 26; i++) if(cnt[i] == max){
                    return (char)(i + 'a');
                }
            }
      
                return '.';
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			HappyLetterDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				HappyLetterDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class HappyLetterDiv2Harness {
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
	
	static boolean compareOutput(char expected, char result) { return expected == result; }
	static String formatResult(char res) {
		return String.format("'%c'", res);
	}
	
	static int verifyCase(int casenum, char expected, char received) { 
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
			String letters            = "aacaaa";
			char expected__           = 'a';

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}
		case 1: {
			String letters            = "dcdjx";
			char expected__           = '.';

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}
		case 2: {
			String letters            = "bcbbbbba";
			char expected__           = 'b';

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}
		case 3: {
			String letters            = "aabc";
			char expected__           = '.';

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}

		// custom cases

/*      case 4: {
			String letters            = ;
			char expected__           = ;

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}*/
/*      case 5: {
			String letters            = ;
			char expected__           = ;

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}*/
/*      case 6: {
			String letters            = ;
			char expected__           = ;

			return verifyCase(casenum__, expected__, new HappyLetterDiv2().getHappyLetter(letters));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
