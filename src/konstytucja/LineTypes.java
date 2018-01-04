package konstytucja;

/**
 * Created by lukas7980 on 08.12.17.
 */
public enum LineTypes {
    Kancelaria("\u00a9Kancelaria Sejmu"),
    Rozdzial("Rozdział"),
    Dzial("DZIAŁ"),
    Artykul("Art.");

    private String linetype;

    LineTypes(String s) {
        this.linetype=s;
    }
    public String getLineType(){
        return linetype;
    }
    @Override
    public String toString(){
        return linetype;
    }
}
