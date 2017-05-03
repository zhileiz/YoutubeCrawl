import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zhileiz on 5/3/17.
 */
public class CrawlThread implements Runnable {
    String channel1 = "https://www.youtube.com/user/TaylorSwiftVEVO";
    String channel2 = "https://www.youtube.com/user/marquesbrownlee";
    String channel3 = "https://www.youtube.com/user/WatchMojo";
    String channel4 = "https://www.youtube.com/user/hickok45";
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    public CrawlThread(HashSet<Youtuber> input){

    }


    @Override
    public void run() {

    }

    public static Youtuber addChannel(String url) throws IOException {
        Document up = Jsoup.connect(url).get();
        String name = up.select("a.branded-page-header-title-link").text();
        String number = up.select("span.yt-subscription-button-subscriber-count-branded-horizontal").text();
        Youtuber current = new Youtuber(name, parseNumber(number), url);
        Elements links = up.select("li.branded-page-related-channels-item");
        for (Element lk:links){
            String link = lk.select("h3").first().select("a").attr("abs:href");
            current.populateLinks(link);
        }
        return current;
    }


    public static int parseNumber(String number){
        try {
            String[] ints = number.split(",");
            StringBuilder sb = new StringBuilder();
            for (String in : ints) {
                sb.append(in);
            }
            return Integer.parseInt(sb.toString());
        } catch (Exception e){
            System.out.print("Failed to Parse Int for this: ");
            return 0;
        }
    }
}
