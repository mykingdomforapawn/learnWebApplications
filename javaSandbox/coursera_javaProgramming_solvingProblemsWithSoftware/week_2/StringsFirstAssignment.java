package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

public class StringsFirstAssignment {

    public String findSimpleGene(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (startIndex == -1 || stopIndex == -1) {
            return "";
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }
        return result;
    }

    public void testFindGeneSimple() {
        // testcase: no ATG
        String dna_1 = "AAGCGTAATATGGT";
        System.out.println("DNA strand is " + dna_1);
        String gene_1 = findSimpleGene(dna_1);
        System.out.println("Gene is " + gene_1);

        // testcase: no TAA
        String dna_2 = "AATGCGTATATGGT";
        System.out.println("DNA strand is " + dna_2);
        String gene_2 = findSimpleGene(dna_2);
        System.out.println("Gene is " + gene_2);

        // testcase: no ATG or TAA
        String dna_3 = "AATCGTATATGGT";
        System.out.println("DNA strand is " + dna_3);
        String gene_3 = findSimpleGene(dna_3);
        System.out.println("Gene is " + gene_3);

        // testcase: with ATG, TAA and the substring is a multiple of 3
        String dna_4 = "AATGCCGTAATATGGT";
        System.out.println("DNA strand is " + dna_4);
        String gene_4 = findSimpleGene(dna_4);
        System.out.println("Gene is " + gene_4);

        // testcase: with ATG, TAA and the substring is not a multiple of 3
        String dna_5 = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna_5);
        String gene_5 = findSimpleGene(dna_5);
        System.out.println("Gene is " + gene_5);
    }

    public static void main(String[] args) {
        StringsFirstAssignment sfa = new StringsFirstAssignment();
        sfa.testFindGeneSimple();
    }
}