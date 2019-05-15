package com.epam.javacore2019.steve2.webservice;

import java.util.Map;

public class Template {

    public String templateFileName; //criminalProfile.html //html page
    public Map<String, String> values;

    public Template(String fileName, Map<String, String> values) {
        this.values = values;
        this.templateFileName = fileName;
    }

    public String compile() {

        //String templateText = Utils.readFile(templateFileName);
        String templateText = "";
        for (String key : values.keySet()){
            templateText = templateText.replace("{{" + key + "}}", values.get(key));
        }
        return templateText;
    }
    //map.put("firstName", "Vasia");
    //map.put("lastname", "Petrov");
}
