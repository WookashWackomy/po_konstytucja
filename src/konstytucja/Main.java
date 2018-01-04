package konstytucja;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] todo = new String[4];
    ArgumentParser parsedargs = new ArgumentParser(args);
    try{
        todo = parsedargs.parse();
    } catch(IllegalArgumentException ex){
        System.out.println(ex.getMessage());
        System.exit(1);
    }


    ReadFile wut = new ReadFile();
    String oneString;
    oneString=wut.toOneString(todo[0]);

    System.out.println(oneString);
    }
}
