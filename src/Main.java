import java.io.IOException;

/**
 * Created by sudheera on 2/23/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        readAllFilesInADir read = new readAllFilesInADir();
        countMostFeqWords count = new countMostFeqWords();

        String textDataDirLocation = "data";
        String concatenatedFileLocation = "lines.txt";
        String resultsFileLocation = "results.txt";


        read.concatenateAllSubFiles(textDataDirLocation,concatenatedFileLocation);
        count.countWords(concatenatedFileLocation,resultsFileLocation);
    }
}
