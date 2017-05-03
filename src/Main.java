import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        YoutuberGraph graph = new YoutuberGraph();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 4; i++) {
            threads.add(new Thread(new CrawlThread(graph,i+1)));
        }
        for (int i = 0; i < 4; i++) {
            threads.get(i).start();
        }
        for (int i = 0; i < 4; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
