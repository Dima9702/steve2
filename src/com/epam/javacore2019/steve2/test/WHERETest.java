package com.epam.javacore2019.steve2.test;

import com.epam.javacore2019.steve2.dbservice.data.query.WHEREParser;

import static com.epam.javacore2019.steve2.dbservice.data.query.WHEREParser.WHERE_STRING;


public class WHERETest {
    public static final String VALID_STRING1 = "WHERE id = 5";
    public static final String VALID_STRING2 = "   WHERE    id = 1 AND name= Tony    ";
    public static final String INVALID_STRING1 = "WHERE id =  1 AND";
    public static final String INVALID_STRING2 = "BAD WHERE ";


    static WHEREParser parser = new WHEREParser();
    @Test
    public static void testValidString() {
        assert parser.validate(VALID_STRING1) : VALID_STRING1;

    }
    @Test
    public static void testInvalidString() {
        assert !parser.validate(INVALID_STRING1) : INVALID_STRING1;

    }
    @Test
    public static void testBeatufyValid(){
        assert  parser.beautify(VALID_STRING2).equals("WHERE id = 1 AND name= Tony");
}

    public static void notTest() {
        System.out.println(" NOT TEST");
    }
    @Test
    public static void testExtractClause (){
        assert parser.extractClause(VALID_STRING1).equals(" id = 5");
        assert parser.extractClause(VALID_STRING2).equals("    id = 1 AND name= Tony    ");

    }



}
