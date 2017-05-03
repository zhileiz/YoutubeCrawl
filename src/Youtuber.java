import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhileiz on 4/30/17.
 */
public class Youtuber {
    private String name;
    private String url;
    private int fanSize;
    private HashSet<Youtuber> outlinks;
    private HashSet<Youtuber> inlinks;
    private HashSet<String> pagelinks;

    public Youtuber(String name, int fanSize, String url){
        this.name = name;
        this.fanSize = fanSize;
        this.url = url;
        pagelinks = new HashSet<String>();
        outlinks = new HashSet<Youtuber>();
        inlinks = new HashSet<Youtuber>();
    }

    @Override
    public boolean equals(Object other){
        if(other == this){
            return true;
        } else if (other == null){
            if (this == null){
                return true;
            } else {
                return false;
            }
        } else if (other.getClass().equals(this.getClass())){
            return false;
        } else {
            Youtuber temp = (Youtuber) other;
            if (temp.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        }
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.fanSize;
    }

    public Set<Youtuber> refering(){
        return this.outlinks;
    }

    public Set<Youtuber> referers(){
        return this.inlinks;
    }

    public void addReferer(Youtuber u){
        inlinks.add(u);
    }

    public void addRefering(Youtuber u){
        outlinks.add(u);
    }

    public String getURL(){
        return url;
    }

    public void populateLinks(String url){
        pagelinks.add(url);
    }

    private Set<String> getLinks(){
        return this.pagelinks;
    }

}
