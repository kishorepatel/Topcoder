import java.util.*;

public class DoorsGame {
   public int determineOutcome(String doors, int trophy) {
       Set<Character> a = new TreeSet<>();
       Set<Character> b = new TreeSet<>();
       for(int i = 0; i < doors.length(); i++){
           if(i < trophy) a.add(doors.charAt(i));
           else b.add(doors.charAt(i));
       }
       
       int player = 0;
       int turns = 0;
       while(true){
           turns++;
           char c = 'Z';
           if(player == 0){
               for(char aa : a){
                   if(! b.contains(aa)){
                       c = aa;
                       break;
                   }
               }
           }
           else{
               for(char bb : b){
                   if(! a.contains(bb)){
                       c = bb;
                       break;
                   }
               }
           }
           
           if(c == 'Z'){
               if(player == 0){
                   for(char aa : a){
                       c = aa;
                       break;
                   }
               }
               else{
                   for(char bb : b){
                       c = bb;
                       break;
                   }
               }
        }
       
       
       a.remove(c);
       b.remove(c);
       
       if(a.isEmpty() && b.isEmpty()) return 0;
       else if(a.isEmpty()) return turns;
       else if(b.isEmpty()) return -turns;
       
       player = 1 - player;
       
       }
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			DoorsGameHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DoorsGameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class DoorsGameHarness {
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
			String doors              = "ABCD";
			int trophy                = 2;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 1: {
			String doors              = "ABCC";
			int trophy                = 2;
			int expected__            = -2;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 2: {
			String doors              = "ABABAB";
			int trophy                = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 3: {
			String doors              = "ABAPDCAA";
			int trophy                = 5;
			int expected__            = -4;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 4: {
			String doors              = "MOCFDCE";
			int trophy                = 3;
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 5: {
			String doors              = "ABCCDE";
			int trophy                = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 6: {
			String doors              = "ABCCD";
			int trophy                = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}

		// custom cases

/*      case 7: {
			String doors              = ;
			int trophy                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}*/
/*      case 8: {
			String doors              = ;
			int trophy                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}*/
/*      case 9: {
			String doors              = ;
			int trophy                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
