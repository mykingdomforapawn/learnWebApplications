package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

import edu.duke.StorageResource;

public class StorageFirstAssignment {

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

    public String findGene(String dna, int firstIndex) {
        int startIndex = dna.indexOf("ATG", firstIndex);

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

    public void testFindGene() {
        String dna;

        // testcase: with valid gene
        dna = "GTTAATGTTATAGCTTAAACCTTTAAAGCAAGGCACTGAAATGCCTAGATGA";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna, 0));

        // testcase: no ATG
        dna = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGCCTTCTTATTAGT";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna, 0));

        // testcase: with one valid stop codon
        dna = "TTTCAGTGAGCTTACACATGCAAGTATAACCGCGCGCCAGTGAAAATGCCC";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna, 0));

        // testcase: with multiple valid stop codons
        dna = "TCAATGATCTAATAGTGAATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna, 0));

        // testcase: with no valid stop codons
        dna = "AGCTCACAACACCTTGCTTAGCCACACCCATGCCACGGGATACAGCAGTGATA";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna, 0));

        // testcase: practice quiz
        dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println("DNA string: " + dna);
        System.out.println("Gene: " + findGene(dna, 0));
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int start = 0;

        while (true) {
            String currentGene = findGene(dna, start);

            if (currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            start = dna.indexOf(currentGene, start) + currentGene.length();
        }

        return geneList;
    }

    public void testGetAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGAGCTGCAACGGTGAAGAATGATCTAA";
        StorageResource geneList = getAllGenes(dna);

        System.out.println("Testing getAllGenes on " + dna);
        for (String gene : geneList.data()) {
            System.out.println("Gene: " + gene);
        }
    }

    public static void main(String[] args) {
        StorageFirstAssignment sfa = new StorageFirstAssignment();
        sfa.testFindStopCodon();
        sfa.testFindGene();
        sfa.testGetAllGenes();
    }
}
