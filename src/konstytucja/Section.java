package konstytucja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Section {
    public String number;
    public String title;
    public ArrayList<Chapter> chapters;

    public Section(String number, String title, ArrayList<Chapter> chapter_set){
        this.number=number;
        this.title=""+title;
        this.chapters=chapter_set;
    }
    @Override
    public String toString(){
        String output= "";
        output += this.title + " " + this.number + "\n";
        for(Chapter c: this.chapters) {

            output += "\n" + c.toString();
        }
        return output;
    }
    public String getTitle(){
        return this.title;
    }
}
