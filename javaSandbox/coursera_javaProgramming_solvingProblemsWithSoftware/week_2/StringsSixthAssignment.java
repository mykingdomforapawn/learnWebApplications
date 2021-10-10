package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

public class StringsSixthAssignment {

    public int howMany(String strinA, String stringB) {
        int counter = 0;
        int currIndex = 0;

        while (true) {
            int startIndex = stringB.indexOf(strinA, currIndex);
            if (startIndex != -1) {
                counter += 1;
                currIndex = startIndex + strinA.length();
            } else {
                break;
            }
        }

        return counter;
    }

    public void testHowMany() {
        String stringA = "GAA";
        String stringB = "ATGAACGAATTGAATC";
        System.out.println("String A: " + stringA + " | String B: " + stringB);
        System.out.println("Occurrences of A in B: " + howMany(stringA, stringB));

        stringA = "AA";
        stringB = "ATAAAA";
        System.out.println("String A: " + stringA + " | String B: " + stringB);
        System.out.println("Occurrences of A in B: " + howMany(stringA, stringB));
    }

    public static void main(String[] args) {
        StringsSixthAssignment ssa = new StringsSixthAssignment();
        ssa.testHowMany();
    }
}
