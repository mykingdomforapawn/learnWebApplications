package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

public class StringsSeventhAssignment {

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

    public void printAllGenes(String dna) {
        int firstIndex = 0;

        System.out.println("DNA string: " + dna);

        while (true) {
            String gene = findGene(dna, firstIndex);

            if (gene.isEmpty()) {
                break;
            }

            System.out.println("Gene: " + gene);
            firstIndex = dna.indexOf(gene, firstIndex) + gene.length();
        }
    }

    public int countGenes(String dna) {
        int numberOfGenes = 0;
        int firstIndex = 0;

        while (true) {
            String gene = findGene(dna, firstIndex);

            if (gene.isEmpty()) {
                break;
            }

            numberOfGenes++;
            firstIndex = dna.indexOf(gene, firstIndex) + gene.length();
        }

        return numberOfGenes;
    }

    public void testCountGenes() {
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println("String: " + dna);
        System.out.println("Number of genes: " + countGenes(dna));
        printAllGenes(dna);
    }

    public static void main(String[] args) {
        StringsSeventhAssignment ssa = new StringsSeventhAssignment();
        ssa.testCountGenes();
    }
}
