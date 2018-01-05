package konstytucja;

import java.util.ArrayList;

public class Action {
    private String filepath;
    private String actionmode;
    private int idxstart;
    private int idxend;
    private boolean[] element = new boolean[3]; // 0 - section, 1 - chapter, 2 -article(s)
    String badchapter="There is no such chapter";
    String badsection= " There is no such section";
    String badrange="Wrong range of elements";
    String badinput="Jesus Christ, wrong args again";
    public Action(String[] actionargs){
        this.filepath=actionargs[0];
        this.actionmode=actionargs[1];
        this.idxstart=Integer.parseInt(actionargs[2]);
        if(actionargs.length==3){
            this.idxend=-1;
        }
        else{
            this.idxend=Integer.parseInt(actionargs[3]);
        }
        this.element[Integer.parseInt(actionargs[4])]=true;
    }

    public void Action(ArrayList<Section> sections, ArrayList<Chapter> chapters,ArrayList<Article> articles){
        if(idxstart<=0 || idxend<=0)throw new IllegalArgumentException((badinput));
        if(element[0]){
            if(idxstart>chapters.size()) throw new IllegalArgumentException(badchapter);
            if(actionmode.equals(("-c"))) System.out.println(chapters.get(idxstart).toString());
            else System.out.println(chapters.get(idxstart).getToC());
        }
        else if(element[1]){
            if(idxstart>sections.size()) throw new IllegalArgumentException(badsection);
            if(actionmode.equals(("-c"))) System.out.println(chapters.get(idxstart).toString());
                else System.out.println(sections.get(idxstart).getToC());
        }
        else if(element[2]) {
            if(idxstart>articles.size())throw new IllegalArgumentException(badinput);
            if (actionmode.equals("-c")) {
                if (idxend == -1) {
                    System.out.println(articles.get(idxstart).toString());
                } else {
                    if(idxend>articles.size())throw new IllegalArgumentException(badinput);
                    for(int i=idxstart ; i<= idxend; i++){
                        System.out.println(articles.get(i).toString());
                    }
                }
            } else throw new IllegalArgumentException(badinput);

            }
        else throw new IllegalArgumentException(badinput);
        }

}

