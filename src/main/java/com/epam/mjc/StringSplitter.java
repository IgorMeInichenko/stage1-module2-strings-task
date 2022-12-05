package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String strDelimiters = "";
        String finallystrDelimiters = "";
        List<String> resultFinal = new ArrayList<>();
        for (String s: delimiters){
            strDelimiters += s+"|";
        }
        finallystrDelimiters = strDelimiters.substring(0,strDelimiters.length()-1);
        String[] result = source.split(finallystrDelimiters);
        for (String s: result){
            if (!Objects.equals(s, "") && !Objects.equals(s, " ")){
                resultFinal.add(s);
            }
        }
        return resultFinal;
    }
}
