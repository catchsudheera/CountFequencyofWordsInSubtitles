import java.io.*;

/**
 * Created by sudheera on 2/23/15.
 */
public class readAllFilesInADir {

    public void concatenateAllSubFiles(String subFileDirLocation,String linesFileLocation) throws IOException {


        File folder = new File(subFileDirLocation);//data
        File[] listOfFiles = folder.listFiles();
        BufferedWriter bwrite = new BufferedWriter(new FileWriter(new File(linesFileLocation)));
        String regex = "[0-9]+";
        int count=0;


        for (File file : listOfFiles) {
            if (file.isFile()) {
                count++;
                System.out.println(count+" processing file "+file.getName());
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                while((line=br.readLine())!=null){
                    line=line.trim().replaceAll("\\<[^>]*>","");
                    if (line.contains("-->") || line.matches(regex) || line.equals("")){
                        continue;
                    }
                    line=line.replaceAll("-", "").replaceAll("!","").replace("?","").replaceAll("\\[","").replaceAll("\\]","").trim();
                    System.out.println("    line : "+line);
                    bwrite.write(line);
                    bwrite.newLine();
                    bwrite.flush();

                }

                br.close();
            }
        }

        System.out.println("file count : "+count);
        bwrite.close();
    }
}
