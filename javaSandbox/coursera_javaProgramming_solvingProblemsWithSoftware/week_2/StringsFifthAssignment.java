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

    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");

        if (startIndex == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));

        if (minIndex == dna.length()) {
            return "";
        }

        return dna.substring(startIndex, minIndex + 3);
    }

    public void testFindStopCodon() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";

        int index = findStopCodon(dna, 0, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 9, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 1, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 0, "TAG");
        System.out.println("Index = " + index);
    }

    public void testFindGene() {
        String dna;

        // testcase: with valid gene
        dna = "GTTAATGTTATAGCTTAAACCTTTAAAGCAAGGCACTGAAATGCCTAGATGA";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna));

        // testcase: no ATG
        dna = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGCCTTCTTATTAGT";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna));

        // testcase: with one valid stop codon
        dna = "TTTCAGTGAGCTTACACATGCAAGTATAACCGCGCGCCAGTGAAAATGCCC";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna));

        // testcase: with multiple valid stop codons
        dna = "TCAATGATCTAATAGTGAATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna));

        // testcase: with no valid stop codons
        dna = "AGCTCACAACACCTTGCTTAGCCACACCCATGCCACGGGATACAGCAGTGATA";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna));
    }

    public static void main(String[] args) {
        StringsFifthAssignment sfa = new StringsFifthAssignment();
        sfa.testFindStopCodon();
        sfa.testFindGene();
    }
}
