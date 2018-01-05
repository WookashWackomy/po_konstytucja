package konstytucja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class FileParser {
    public String document;
    private ArrayList<Section> sections;
    private int[] SectionNumbers;
    private String[] SectionTitles;
    private int[] ChapterNumbers;
    private String[] ChapterTitles;
    private int[] ArticleNumbers;
    private String[] ArticleLines;
    private int[] ParagraphNumbers;
    private String[] ParagraphLines;
    private int[] PassageNumbers;
    private String[] PassageLines;
    private String[] LetterNumbers;
    private String[] LetterLines;

    FileParser(String document){
        this.document=document;
    }

    private void makeStructure(){
        BufferedReader bufReader = new BufferedReader(new StringReader(document));
        String textline;
        String check_section;
        String check_chapter;
        String check_article;
        String check_rest;
        int section_idx=0;
        int chapter_idx=0;
        int art_idx=0;
        int par_idx=0;
        int passage_idx=0;
        int letter_idx=0;
        boolean[] textbeings= new boolean[4]; //0-art, 1-par, 2-pass, 3-letter
        for(boolean b: textbeings){
            b=false;
        }
        try {
            while((textline=bufReader.readLine()) != null){
                check_section=textline.substring(0,Math.min(textline.length(),5));
                check_chapter=textline.substring(0,Math.min(textline.length(),8));
                check_article=textline.substring(0,Math.min(textline.length(),4));
                check_rest=textline.substring(0,Math.min(textline.length(),2)); //ustep,reszta
                if(check_section.equals((LineTypes.Dzial.toString()))){
                    this.SectionNumbers[section_idx]=chapter_idx;
                    this.SectionTitles[section_idx]= bufReader.readLine();
                    section_idx++;
                }
                else if(check_chapter.equals(LineTypes.Rozdzial.toString())){
                    this.ChapterNumbers[chapter_idx]=art_idx;
                    this.ChapterTitles[chapter_idx] = bufReader.readLine();
                    chapter_idx++;
                }

                else if(check_article.equals(LineTypes.Artykul.toString())){
                    this.ArticleNumbers[art_idx]=par_idx;
                    art_idx++;
                    textbeings[0]=true;
                }
                else if(isParagraph(check_rest)){
                    this.ParagraphNumbers[par_idx]=passage_idx;
                    par_idx++;
                    textbeings[1]=true;
                }
                else if(isPassage(check_rest)){
                    this.PassageNumbers[passage_idx]=letter_idx;
                    passage_idx++;
                    textbeings[2]=true;
                }
                else if (isLetter(check_rest)) {
                    letter_idx++;
                    textbeings[3]=true;
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Letter> parseLetters(){
        ArrayList<Letter> parsedletters = new ArrayList<Letter>();
        for(int i=0; i<this.LetterLines.length; i++){
            parsedletters.add(i,new Letter(Integer.toString(i),this.LetterLines[i]));
        }

        return parsedletters;
    }
    public ArrayList<Passage> parsePassages(ArrayList<Letter> parsedletters){
        ArrayList<Passage> parsedpassages = new ArrayList<Passage>();
        for(int i=0; i<parsedletters.size();i++){
           // ArrayList<Letter> subarray
        }
        return parsedpassages;
    }
    public ArrayList<Paragraph> parseParagraphs(){
        ArrayList<Paragraph> parsedparagraphs = new ArrayList<Paragraph>();

        return parsedparagraphs;
    }
    public ArrayList<Article> parseArticles(Paragraph[] parsedParagraphs){
        ArrayList<Article> parsedarticles = new ArrayList<Article>();
        int i;
        for (i = 0; i < parsedarticles.size(); i++) {
            //ArrayList<Paragraph> subarray = Arrays.copyOfRange(parsedParagraphs,this.ArticleNumbers[i],this.ArticleNumbers[i+1]);
            //parsedarticles[i] = new Article(i + 1, this.formatText(ArticleLines[i]),subarray);
        }

        return parsedarticles;
    }
    public ArrayList<Section> parseSections() {
        ArrayList<Section> parsedsections = new ArrayList<Section>();

        return parsedsections;
    }


    public static boolean isParagraph(String str)
    {
        char[] chars = str.toCharArray();
        if(Character.isDigit(chars[0]) && chars[1]=='.') return true;
        return false;
    }
    public static  boolean isPassage(String str)
    {
        char[] chars = str.toCharArray();
        if(Character.isDigit(chars[0]) && chars[1]==')') return true;
        return false;
    }
    public static boolean isLetter(String str)
    {
        char[] chars = str.toCharArray();
        if(Character.isLetter(chars[0]) && chars[1]==')') return true;
        return false;
    }



}
