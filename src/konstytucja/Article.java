package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by lukas7980 on 07.12.17.
 */
public class Article {
    public int number;
    public String content;
    public ArrayList<Paragraph> paragraphs;

    public Article(int number, String content, ArrayList<Paragraph> paragraph_set){
        this.number=number;
        this.content=""+content;
        this.paragraphs=paragraph_set;
    }
    @Override
    public String toString() {
        String output = "";
        output += "Art. " + this.number + ". " + this.content + "\n";
        for (Paragraph pr : this.paragraphs) {

            output += "\n" + pr.toString();
        }
        return output;
    }
}
