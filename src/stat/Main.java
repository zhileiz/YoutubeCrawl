package stat;

import crawler.Youtuber;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhileiz on 5/5/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> outlinks = new HashMap<String,Integer>();
        HashMap<String, Integer> inlinks = new HashMap<String,Integer>();
        String fileName = "cc0.csv";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while(line != null) {
                String[] sts = line.split(",");
                if (sts.length == 2) {
                    String first = sts[0];
                    if (outlinks.containsKey(first)) {
                        int k = outlinks.remove(first);
                        outlinks.put(first,k+1);
                    } else {
                        outlinks.put(first,1);
                    }
                    System.out.println(first);
                    String last = sts[1];
                    if (inlinks.containsKey(last)) {
                        int k = inlinks.remove(last);
                        inlinks.put(last,k+1);
                    } else {
                        inlinks.put(last,1);
                    }
                    System.out.println(last);
                }
                line = bufferedReader.readLine();
            }

            // Always close files.
            bufferedReader.close();
            System.out.println("Average outlink is: " + computeAverage(outlinks));
            System.out.println("Average inlink is: " + computeAverage(inlinks));
            System.out.println("Total user is: " + outlinks.keySet().size());
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    private static double computeAverage(HashMap<String, Integer> hm){
        Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator();
        double denom = 0.0;
        double nom = 0.0;
        while (it.hasNext()){
            Map.Entry<String,Integer> e = it.next();
            nom = nom + e.getValue();
            denom = denom + 1;
        }
        if (nom == 0 || denom == 0){
            return 0.0;
        } else {
            return nom/denom;
        }
    }
}
