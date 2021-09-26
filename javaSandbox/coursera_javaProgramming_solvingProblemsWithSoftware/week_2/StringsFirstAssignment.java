package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

public class StringsFirstAssignment {

    public String findSimpleGene(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (startIndex == -1 || stopIndex == -1) {
            return result;
        }
        result = dna.substring(startIndex, stopIndex + 3);
        // modulo checken, hier weiter
        return result;
    }

    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }

    // If the length of the substring between the “ATG” and “TAA” is a multiple of
    // 3, then return the substring that starts with that “ATG” and ends with that
    // “TAA”.

    public static void main(String[] args) {
        StringsFirstAssignment sfa = new StringsFirstAssignment();
        sfa.testFindGeneSimple();
    }

}