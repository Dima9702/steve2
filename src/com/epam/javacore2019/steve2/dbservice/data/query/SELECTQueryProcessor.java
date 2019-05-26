package com.epam.javacore2019.steve2.dbservice.data.query;

import com.epam.javacore2019.steve2.dbservice.DBApplication;
import com.epam.javacore2019.steve2.dbservice.data.Table;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SELECTQueryProcessor implements QueryProcessor {

    public static final String OP_GROUP = "^(SELECT)";
    public static final String FLD_GROUP = "([*a-zA-Z, ]+)";
    public static final String SPACE = "([\\s]+)";              // "\\s" - пустой символ или пробел или что-то похожее
    public static final String FROM_GROUP = "(FROM)";
    public static final String TBL_GROUP = "([a-zA-Z]+)$";
    public static final String WHERE_GROUP = "(WHERE)";
    public static final String ID_GROUP = "(id=)[0-9]+";



    @Override
    public QueryResult process(String query) {
        Pattern pattern = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP + SPACE  + WHERE_GROUP + SPACE + ID_GROUP);
      //  Pattern pattern = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP);
        QueryResult queryResult = new QueryResult();        //результат запроса
        Matcher matcher = pattern.matcher(query);
        queryResult.status = QueryResult.Status.OK;         //все хорошо, если пойдет не так - поменяем
        if (matcher.find()) {
            String[] fields = matcher.group(3).split(",");      //название полей
            String tableName = matcher.group(7);                        // название таблички
         //   String id = matcher.group(11);
            Table table = DBApplication.INSTANCE.getTable(tableName);       // достаем табл из реестра таблиц
            if (table != null) {
           //     List<List<String>> result = table.collect(fields,id);              // наш ответ 2х мерный как и сама таблица
                List<List<String>> result = table.collect(fields);              // наш ответ 2х мерный как и сама таблица
                queryResult.setMessage("COMPLETED SUCCESSFULLY");
                queryResult.setLoad(collectedResultToString(result));           // из списка списков строк --> в
            } else {                                                                // если не нашли табличку -
                queryResult.setStatus(QueryResult.Status.FAILURE);
                queryResult.setMessage("TABLE DOES NOT EXISTS");
            }
        } else {                        /// если не валидный запрос
            queryResult.setStatus(QueryResult.Status.FAILURE);
            queryResult.setMessage("INVALID QUERY");
        }

        return queryResult;
    }

    private String collectedResultToString(List<List<String>> collectedResult) {
        String result = "";
        for (List<String> list : collectedResult ) {        //TODO можно заменить на стринг билдер
            for (String s : list) {
                result += s + ";";
            }
            result = result.substring(0, result.length()-1);
            result += ";";
        }
        return result;
    }

}
