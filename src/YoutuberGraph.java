import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhileiz on 4/30/17.
 */
public class YoutuberGraph {
    private ConcurrentHashMap<String, Youtuber> connections;
    private Queue<Youtuber> toBeSeen;
    private HashSet<Youtuber> Visited;

    public YoutuberGraph(){
        connections = new ConcurrentHashMap<String, Youtuber>();
        toBeSeen = new ConcurrentLinkedQueue<Youtuber>();
        Visited = new HashSet<Youtuber>();
    }

    public boolean addYoutuber(Youtuber u){
        if (connections.containsKey(u.getName())){
            return false;
        } else {
            connections.put(u.getName(), u);
            toBeSeen.add(u);
            //print(u);
            return true;
        }
    }

    private void print(Youtuber u){
        System.out.println(connections.size() + ": added: " + u.getName() + " with " + u.getSize() + " followers.");
    }

    public Set<String> allUsers(){
        return this.connections.keySet();
    }

    public void addEdge(Youtuber from, Youtuber to){
        if (connections.containsKey(from.getName()) && connections.containsKey(to.getName())){
            connections.get(from.getName()).addRefering(to);
            connections.get(to.getName()).addReferer(from);
        } else {
            throw new NoSuchElementException();
        }
    }

    public int size(){
        return connections.size();
    }

    public Youtuber next(){
        Youtuber u = toBeSeen.poll();
        Visited.add(u);
        return u;
    }

    public Boolean isQueued(Youtuber u){
        return toBeSeen.contains(u);
    }

    public Boolean isVisited(Youtuber u){
        return Visited.contains(u);
    }

    public void enqueue(Youtuber u){
        if (!isQueued(u) && !isVisited(u)){
            toBeSeen.add(u);
        }
    }

    public void DoBFS() throws IOException{
        while (!toBeSeen.isEmpty()) {
            Youtuber u = toBeSeen.poll();
            System.out.println("\n##### Working On " + u.getName());
            try {
                Visited.add(u);
                addNeighbors(u);
            } catch (Exception e) {
                System.out.println("!!!!!!! Time Out !!!!!!");
            }
        }
    }

    private void addNeighbors(Youtuber u) throws IOException{
        String url = u.getURL();
        Document up = Jsoup.connect(url).timeout(5000).get();
        Elements links = up.select("li.branded-page-related-channels-item");
        for (Element lk:links){
            Elements k = lk.select("h3").first().select("a");
            String st = k.attr("abs:href");
            String checker = k.text();
            if ( this.connections.containsKey(checker)){
                continue;
            }
            Youtuber now = CrawlThread.addChannel(st);
            this.addYoutuber(now);
            System.out.println(connections.size() + ": added: " + now.getName() + " with " + now.getSize() + " followers from " + u.getName());
            this.addEdge(u,now);
        }
    }

}
