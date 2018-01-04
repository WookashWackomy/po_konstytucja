package konstytucja;

import java.io.*;

public class ReadFile {
    public String toOneString(String filePath) throws IOException {

        StringBuilder finalstring = new StringBuilder();
        InputStream inputStream = new FileInputStream(filePath);
        try {
            Reader r = new InputStreamReader(inputStream, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                finalstring.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String finalstringfinal = ClearUnwanted(finalstring.toString());
        return finalstringfinal;
    }
    public String ClearUnwanted(String string){
        StringBuilder cleared_string = new StringBuilder();
        String messed_up_string = string;
        BufferedReader bufReader = new BufferedReader(new StringReader(messed_up_string));
        String textline = null;
        String checked_line;
        try {
            while((textline=bufReader.readLine()) != null){
                boolean unwantedlineflag = false;
                checked_line=textline.substring(0,Math.min(textline.length(),17));
                if(isNumeric(textline)) unwantedlineflag=true;
                else if(textline.length()==1) unwantedlineflag=true;
                else if(checked_line.equals(LineTypes.Kancelaria.toString()))unwantedlineflag=true;
                     if(unwantedlineflag==false){
                        cleared_string.append(textline);
                        cleared_string.append(System.getProperty("line.separator"));
                     }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cleared_string.toString();
    }
    public  boolean isNumeric(String str)
    {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) || c=='-') continue;
            else return false;
        }
        return true;
    }
}


