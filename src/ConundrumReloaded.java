import java.util.*;

public class ConundrumReloaded {
    int INF = 9999999;
   public int minimumLiars(String answers) {
	int q = -1;
        int N = answers.length();
        for(int i = 0; i < N; i++) if(answers.charAt(i) == '?') q = i;
        
        if(q == -1){
            int res = INF;
            for(int t = 0; t < 2; t++){
                int cur = t;
                int liars = 0;
                for(int i = 0; i < N; i++){
                    liars += cur;
                    cur ^= (answers.charAt(i) == 'L') ? 1 : 0;
                }
                
                if(cur == t){
                    res = Math.min(res, liars);
                }
            }
            
            if(res > N) return -1;
            else return res;
        }
        else{
            String s = "";
            int res = 0;
            for(int i = 0; i <= N; i++){
                int index = (q + i) % N;
                if(answers.charAt(index) == '?'){
                    if(s.length() > 0){
                        res += best(s);
                    }
                    s = "";
                }
                else{
                    s += answers.charAt(index);
                }
            }
            
            return res;
        }
   }
   
   private int best(String s){
       int N = s.length();
       int res = INF;
       for(int t = 0; t < 2; t++){
           int cur = t;
           int liars = 0;
           for(int i = 0; i < N; i++){
               liars += cur;
               cur ^= (s.charAt(i) == 'L') ? 1 : 0;
           }
           
           liars += cur; //if last person himself is liar/contradicting
           
           res = Math.min(res, liars);
       }
       
       return res;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ConundrumReloadedHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ConundrumReloadedHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ConundrumReloadedHarness {
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
			String answers            = "LLH";
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}
		case 1: {
			String answers            = "?????";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}
		case 2: {
			String answers            = "LHLH?";
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}
		case 3: {
			String answers            = "??LLLLLL??";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}
		case 4: {
			String answers            = "LLL";
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}

		// custom cases

/*      case 5: {
			String answers            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}*/
/*      case 6: {
			String answers            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}*/
/*      case 7: {
			String answers            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ConundrumReloaded().minimumLiars(answers));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
