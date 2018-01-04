package konstytucja;

public class Letter {
    public String letter;
    public String content;
    public Letter(String letter, String content){
        this.letter = letter;
        this.content = content;
    }
    @Override
    public String toString(){
        return("lit. " + letter + "): " + content + "\n");
    }
}
