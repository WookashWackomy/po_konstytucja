package konstytucja;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
public class Passage {
    public int number;
    public String content;
    public ArrayList<Letter> letters;
    public Passage(int number, String content, ArrayList<Letter> letter_set){
        this.number = number;
        this.content = content;
        this.letters=letter_set;
    }
    @Override
    public String toString(){
        String output="";
        output += "pkt. " + this.number + "): " + content;
       for(Letter l : this.letters) {
                output += "\n" + l.toString();
        }
        return output;
    }
}
