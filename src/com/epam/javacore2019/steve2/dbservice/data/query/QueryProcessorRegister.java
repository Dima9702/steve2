package com.epam.javacore2019.steve2.dbservice.data.query;

import java.util.HashMap;
import java.util.Map;


public class QueryProcessorRegister { // можно через енум
    static Map<String, QueryProcessor> queryProcessors;

    static {
        queryProcessors = new HashMap<>();
        queryProcessors.put("SELECT", new SELECTQueryProcessor());
        queryProcessors.put("DELETE", null);// null тк не поддерживаются
        queryProcessors.put("UPDATE", null);
        queryProcessors.put("INSERT", null);
    }

    public static QueryProcessor getQueryProcessor(String queryType) {
        return queryProcessors.get(queryType);
    }

}
