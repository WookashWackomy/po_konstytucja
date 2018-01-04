package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
/**
 * Created by lukas7980 on 07.12.17.
 */
public class Paragraph {
    public int number;
    public String content;
    public ArrayList<Passage> passages;
    public Paragraph(int number, String content, ArrayList<Passage> passage_set){
        this.number = number;
        this.content = content;
        this.passages=passage_set;
    }

    @Override
    public String toString(){
        String output="";
        output += "ust. " + this.number + ". " + content + "\n";
        for(Passage p: this.passages) {

            output += "\n" + p.toString();
        }
        return output;
    }
}
