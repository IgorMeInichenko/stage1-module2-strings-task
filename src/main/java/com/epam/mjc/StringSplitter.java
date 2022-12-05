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
        for (String s: delimiters){
            strDelimiters += s+"|";
        }
        finallystrDelimiters = strDelimiters.substring(0,strDelimiters.length()-1);
        String[] result = source.split(finallystrDelimiters);
        int countOfEmpty = 0;
        for (String s: result){
            if (s==""){
                countOfEmpty++;
            }
        }
        String[] finalResult = new String[result.length-countOfEmpty];
        int iter = 0;
        for (String s: result){
            if (s!=""){
                finalResult[iter]=s;
                iter++;
            }
        }
        List<String> resultAtList = Arrays.asList(finalResult);
        return resultAtList;
    }
}
