import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

/**
 * Created by sudheera on 2/23/15.
 */
public class countMostFeqWords {

    public void countWords(String linesFileLocation,String resultsFileLocation) throws  IOException {

        File file = new File(linesFileLocation); //lines.txt
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new FileReader(file));
        String inputLine = null;
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        try {
            while ((inputLine = bufferedReader.readLine()) != null) {
                String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");

                for (int counter = 0; counter < words.length; counter++) {
                    String key = words[counter].toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                    if (key.trim().equals("")){
                        continue;
                    }
                    //System.out.print(key + ", ");
                    if (key.length() > 0) {
                        if (map.get(key) == null) {
                            map.put(key, 1);
                        }
                        else {
                            int value = map.get(key).intValue();
                            value++;
                            map.put(key, value);
                        }
                    }
                }
                //System.out.println();
            }

            BufferedWriter br = new BufferedWriter(new FileWriter(new File(resultsFileLocation))); //results.txt
           TreeMap<Integer,String> sortedMap = new TreeMap<Integer, String>(Collections.reverseOrder());

            Iterator<String> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                String next = iterator.next();
                sortedMap.put(map.get(next),next);
            }


            Iterator<Integer> iterator1 = sortedMap.keySet().iterator();
            while(iterator1.hasNext()){
                int nextInt = iterator1.next();
                String out = sortedMap.get(nextInt)+" : "+nextInt;
                System.out.println(out);
                br.write(out);
                br.newLine();
                br.flush();
            }

            br.close();
        }

        catch (IOException error) {
            System.out.println("Invalid File");
        }
        finally {
            bufferedReader.close();
        }

    }
}
