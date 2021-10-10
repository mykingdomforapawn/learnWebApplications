package javaSandbox.coursera_javaProgramming_solvingProblemsWithSoftware.week_2;

import edu.duke.URLResource;

public class StringsFifthAssignment {

    public void findLinks(String url) {
        URLResource urlResource = new URLResource(url);

        for (String word : urlResource.words()) {
            int youtubeIndex = word.toLowerCase().indexOf("youtube.com");

            if (youtubeIndex != -1) {
                int startIndex = word.lastIndexOf("\"", youtubeIndex);
                int lastIndex = word.indexOf("\"", youtubeIndex);
                System.out.println("The youtube link is: " + word.substring(startIndex + 1, lastIndex));
            }
        }
    }

    public void testFindLinks() {
        String url = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        findLinks(url);
    }

    public static void main(String[] args) {
        StringsFifthAssignment sfa = new StringsFifthAssignment();
        sfa.testFindLinks();
    }
}
