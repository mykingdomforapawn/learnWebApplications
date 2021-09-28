package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

public class StringsThirdAssignment {

    public boolean twoOccurrences(String stringa, String stringb) {
        int firstOccurrence = stringb.indexOf(stringa);
        int lastOccurrence = stringb.lastIndexOf(stringa);

        if (firstOccurrence != lastOccurrence) {
            return true;
        } else {
            return false;
        }
    }

    public String lastPart(String stringa, String stringb) {
        String result;
        int firstOccurrence = stringb.indexOf(stringa);

        if (firstOccurrence == -1) {
            result = stringb;
        } else {
            result = stringb.substring(firstOccurrence + stringa.length(), stringb.length());
        }
        return result;
    }

    public void testing() {
        String testa;
        String testb;

        // testcase: two occurences
        testa = "a";
        testb = "banana";
        System.out.println("String a is " + testa + " and String b is " + testb);
        System.out.println("There are two occurences: " + twoOccurrences(testa, testb));

        // testcase: one occurence
        testa = "a";
        testb = "banini";
        System.out.println("String a is " + testa + " and String b is " + testb);
        System.out.println("There are two occurences: " + twoOccurrences(testa, testb));

        // testcase: no occurences
        testa = "a";
        testb = "binini";
        System.out.println("String a is " + testa + " and String b is " + testb);
        System.out.println("There are two occurences: " + twoOccurrences(testa, testb));
    }

    public static void main(String[] args) {
        StringsThirdAssignment sfa = new StringsThirdAssignment();
        sfa.testing();
    }
}