import java.io.IOException;

public class Main {
    String channel1 = "https://www.youtube.com/user/TaylorSwiftVEVO";
    String channel2 = "https://www.youtube.com/user/marquesbrownlee";
    String channel3 = "https://www.youtube.com/user/WatchMojo";
    String channel4 = "https://www.youtube.com/user/hickok45";


    public static void main(String[] args) throws IOException {
        String starter = "https://www.youtube.com/user/WonderWhy7439";
        YoutuberGraph graph = new YoutuberGraph();
        Youtuber current = CrawlThread.addChannel(starter);
        graph.addYoutuber(current);
        graph.DoBFS();
    }

}
