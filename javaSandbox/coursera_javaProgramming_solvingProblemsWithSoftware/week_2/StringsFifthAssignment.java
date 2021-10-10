package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

public class StringsFifthAssignment {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);

        while (currIndex != -1) {
            int diffIndex = currIndex - startIndex;
            if (diffIndex % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    public void testFindLinks() {

    }

    public static void main(String[] args) {
        StringsFifthAssignment sfa = new StringsFifthAssignment();
        sfa.testFindLinks();
    }
}
