package konstytucja;

public class Document {
    private int number_of_sections;
    private int number_of_chapters;
    private int number_of_articles;

    public Document(int sections_num,int chapters_num,int article_num){
        this.number_of_sections=sections_num;
        this.number_of_chapters=chapters_num;
        this.number_of_articles=article_num;
    }


    public int getNumber_of_articles() {
        return number_of_articles;
    }

    public int getNumber_of_chapters() {
        return number_of_chapters;
    }

    public int getNumber_of_sections() {
        return number_of_sections;
    }

}
