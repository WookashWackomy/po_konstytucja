package konstytucja;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukas7980 on 07.12.17.
 */
public class ArgumentParser {
    public String[] args;

    ArgumentParser(String[] args){
    this.args = args;
    }

    public String[] parse() throws IllegalArgumentException {
        String invalid = "Invalid input.Use --help flag for more";
        String badpath = "File doesn't exist or wrong directory was given.";
        String help = "Proper format of arguments: filepath [mode] start end \n ( mode:{-t,-c} where -t =>Table Of Contents | -c => content \n start - starting index of doc element \n end - ending index of doc element \n if single element is desired omit [end] \n NOTE: roman numbers are NOT accepted";
        String badmode = "Use either -c or -t for [mode] option";
        if (!(this.args.length == 4 || this.args.length == 3 || this.args.length == 1))
            throw new IllegalArgumentException(invalid);
        if (this.args.length == 1){
            if (this.args[0].equals("--help")) {
                throw new IllegalArgumentException(help);
            }
            else{throw new IllegalArgumentException(invalid);}
        }
        if(!(new File(this.args[0]).isFile())){
            throw new IllegalArgumentException(badpath);
        }

        if(!(this.args[1].equals("-t") || this.args[1].equals("-c"))){
            throw new IllegalArgumentException(badmode);
        }

        if(this.args.length == 3)
            if(!(isInt(this.args[2])))
                throw new IllegalArgumentException(invalid);
        if(this.args.length == 4)
            if(!(isInt(this.args[2]) && isInt(this.args[2])))
                throw new IllegalArgumentException(invalid);
        return args;
    }

    private boolean isInt(String arg){
        boolean flag = true;
        for(int i=0; i<arg.length(); i++) {
            if (!(arg.charAt(i) >= '0' && arg.charAt(i) <= '9')) flag = false;
            if (!flag) return false;
        }
        return true;
        }
}
