package crawler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        YoutuberGraph graph = new YoutuberGraph();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 32; i++) {
            threads.add(new Thread(new CrawlThread(graph,i+1)));
        }
        for (int i = 0; i < 32; i++) {
            threads.get(i).start();
        }
        System.out.println("\n\n##########################################################################" +
                             "\n################################## Threading!!! ##########################\n\n\n");
        for (int i = 0; i < 32; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n\n##########################################################################" +
                "\n################################## Finishing!!! ##########################\n\n\n");
        System.out.println(graph.size());
        Iterator<Youtuber> visited = graph.getYoutuber();
        PrintWriter writer = new PrintWriter("youtubers.txt");
        PrintWriter output = new PrintWriter("connections.txt");
        while (visited.hasNext()){
            Youtuber u = visited.next();
            System.out.println("Printing: " + u.getName());
            writer.println(u.getName() + ":" +u.getSize());
            Set<Youtuber> neighbors = u.refering();
            for (Youtuber k : neighbors){
                if(!u.getName().equals("") && !k.getName().equals("")) {
                    output.println(u.getName() + " >> " + k.getName());
                }
            }
        }
        writer.close();
        output.close();
    }

}
