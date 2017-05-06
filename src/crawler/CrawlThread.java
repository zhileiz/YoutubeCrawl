package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by zhileiz on 5/3/17.
 */
public class CrawlThread implements Runnable {
    String channel1 = "https://www.youtube.com/user/FoxNewsChannel";
    String channel2 = "https://www.youtube.com/user/vice";
    String channel3 = "https://www.youtube.com/user/JoergSprave";
    String channel4 = "https://www.youtube.com/user/tnnrawnews";
    String channel5 = "https://www.youtube.com/user/bbcnews";
    String channel6 = "https://www.youtube.com/user/RTAmerica";
    String channel7 = "https://www.youtube.com/user/gordonramsay";
    String channel8 = "https://www.youtube.com/user/RosannaPansino";
    String channel9 = "https://www.youtube.com/user/HellthyJunkFood";
    String channel10 = "https://www.youtube.com/user/paulshardware";
    String channel11 = "https://www.youtube.com/user/unboxtherapy";
    String channel12 = "https://www.youtube.com/user/coldfustion";
    String channel13 = "https://www.youtube.com/user/sbnation";
    String channel14 = "https://www.youtube.com/user/HockeyReviewHQ";
    String channel15 = "https://www.youtube.com/user/usagymnasticsorg";
    String channel16 = "https://www.youtube.com/user/sxephil";
    String channel17 = "https://www.youtube.com/user/WWEFanNation";
    String channel18 = "https://www.youtube.com/user/corycotton";
    String channel19 = "https://www.youtube.com/user/BeautyFulfilled";
    String channel20 = "https://www.youtube.com/user/Rclbeauty101";
    String channel21 = "https://www.youtube.com/user/CuteGirlsHairstyles";
    String channel22 = "https://www.youtube.com/user/caseyneistat";
    String channel23 = "https://www.youtube.com/user/BrooklynAndBailey";
    String channel24 = "https://www.youtube.com/user/screwattack";
    String channel25 = "https://www.youtube.com/user/FilmTheorists";
    String channel26 = "https://www.youtube.com/user/iHasCupquake";
    String channel27 = "https://www.youtube.com/user/PewDiePie";
    String channel28 = "https://www.youtube.com/channel/UC8xDSf5LRGwEf5v9iH6xrwg";
    String channel29 = "https://www.youtube.com/user/teamcoco";
    String channel30 = "https://www.youtube.com/user/AwesomenessTV";
    String channel31 = "https://www.youtube.com/user/JoeyGraceffa";
    String channel32 = "https://www.youtube.com/user/BritainsGotTalent09";
    String channel33 = "https://www.youtube.com/user/StanfordUniversity";
    String channel34 = "https://www.youtube.com/user/VEVO";
    String channel35 = "https://www.youtube.com/user/vlogbrothers";
    String channel36 = "https://www.youtube.com/user/TheBackyardScientist";
    String channel37 = "https://www.youtube.com/user/numberphile";
    String channel38 = "https://www.youtube.com/user/6488jesse";
    String channel39 = "https://www.youtube.com/user/NTDChinaUncensored";
    String channel40 = "https://www.youtube.com/channel/UCyjwQ6oz4cqqtEcWGboSU3g";
    String channel41 = "https://www.youtube.com/user/caseyneistat";
    String channel42 = "https://www.youtube.com/channel/UCdxi8d8qRsRyUi2ERYjYb-w";
    String channel43 = "https://www.youtube.com/user/JoergSprave";
    String channel44 = "https://www.youtube.com/channel/UC7IcJI8PUf5Z3zKxnZvTBog";
    String channel45 = "https://www.youtube.com/user/Nerdwriter1";
    String channel46 = "https://www.youtube.com/channel/UCsqjHFMB_JYTaEnf_vmTNqg";
    String channel47 = "https://www.youtube.com/user/CNETTV";
    String channel48 = "https://www.youtube.com/user/joeisblu";
    YoutuberGraph graph;
    String starter;
    int ThreadNum;
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

    public CrawlThread(YoutuberGraph input, int it){
        graph = input;
        switch (it){
            case 1:
                starter = channel1;
                break;
            case 2:
                starter = channel2;
                break;
            case 3:
                starter = channel3;
                break;
            case 4:
                starter = channel4;
                break;
            case 5:
                starter = channel5;
                break;
            case 6:
                starter = channel6;
                break;
            case 7:
                starter = channel7;
                break;
            case 8:
                starter = channel8;
                break;
            case 9:
                starter = channel9;
                break;
            case 10:
                starter = channel10;
                break;
            case 11:
                starter = channel11;
                break;
            case 12:
                starter = channel12;
                break;
            case 13:
                starter = channel13;
                break;
            case 14:
                starter = channel14;
                break;
            case 15:
                starter = channel15;
                break;
            case 16:
                starter = channel16;
                break;
            case 17:
                starter = channel17;
                break;
            case 18:
                starter = channel18;
                break;
            case 19:
                starter = channel19;
                break;
            case 20:
                starter = channel20;
                break;
            case 21:
                starter = channel21;
                break;
            case 22:
                starter = channel22;
                break;
            case 23:
                starter = channel23;
                break;
            case 24:
                starter = channel24;
                break;
            case 25:
                starter = channel25;
                break;
            case 26:
                starter = channel26;
                break;
            case 27:
                starter = channel27;
                break;
            case 28:
                starter = channel28;
                break;
            case 29:
                starter = channel29;
                break;
            case 30:
                starter = channel30;
                break;
            case 31:
                starter = channel31;
                break;
            case 32:
                starter = channel32;
                break;
            case 33:
                starter = channel33;
                break;
            case 34:
                starter = channel34;
                break;
            case 35:
                starter = channel35;
                break;
            case 36:
                starter = channel36;
                break;
            case 37:
                starter = channel37;
                break;
            case 38:
                starter = channel38;
                break;
            case 39:
                starter = channel39;
                break;
            case 40:
                starter = channel40;
                break;
            case 41:
                starter = channel41;
                break;
            case 42:
                starter = channel42;
                break;
            case 43:
                starter = channel43;
                break;
            case 44:
                starter = channel44;
                break;
            case 45:
                starter = channel45;
                break;
            case 46:
                starter = channel46;
                break;
            case 47:
                starter = channel47;
                break;
            case 48:
                starter = channel48;
                break;

        }
        ThreadNum = it-1;
    }


    @Override
    public void run() {
        try {
            Youtuber current = CrawlThread.addChannel(starter);
            System.out.println("-----OnThread: " + this.ThreadNum + "-----");
            graph.addYoutuber(current);
            graph.DoBFS();
        } catch (Exception e) {
            System.out.println("Something is wrong!");
        }
        System.out.println("##### " + ThreadNum + "th Thread is Finished! #####");
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
