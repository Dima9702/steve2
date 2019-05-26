package com.epam.javacore2019.steve2.dbservice.data.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WHEREParser {

    public static final String WHERE_STRING = "^(WHERE)([\\s]*[a-zA-Z0-9<>= ]+)";

    public boolean validate(String whereString){
        return  whereString.matches(WHERE_STRING);

    }
    public String beautify(String whereString){
        return whereString.trim().replaceAll("[\\s]+"," ");
    }
    public String extractClause(String whereString){
        Pattern p = Pattern.compile(WHERE_STRING);
        Matcher m = p.matcher(whereString);
        System.out.println(" ");
        if(m.find()){
            for (int i = 0;m.group(i)!= null ; i++) {
                System.out.println(m.group(i) + i);
            }

            return  whereString;
        }else return null;
    }
}
