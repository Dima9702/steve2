package com.epam.javacore2019.steve2;

import com.epam.javacore2019.steve2.db.dbstate.DBState;
import com.epam.javacore2019.steve2.db.dbstate.DBStateInit;
import com.epam.javacore2019.steve2.db.dbstate.DBStateStop;
import com.epam.javacore2019.steve2.db.misc.Utils;
import com.epam.javacore2019.steve2.db.misc.XMLDocumentHandler;
import com.epam.javacore2019.steve2.db.misc.DBConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainApplication {

    static private int count = 1;
    public static void main(String[] args) {
        //DBApplication.INSTANCE.start();
        //DBApplication.INSTANCE.stop();
        //BadApplication badApplication = new BadApplication();
        //badApplication.start();
        //testXMLReader();
        //Utils.readDir(DBConstants.STRUCTURE_DIR,);
    }


    public static void testXMLReader() {
        try {
            Utils.readXMLDocument(DBConstants.STRUCTURE_DIR + "/test.xml",
                    new XMLDocumentHandler() {
                        @Override
                        public void handleDocument(Document document) {
                            Element root = document.getDocumentElement();
                            System.out.println(root.getAttribute("name"));
                            NodeList columns = root.getElementsByTagName("column");
                            System.out.println(columns.getLength());
                            for (int i = 0, len = columns.getLength(); i < len; i++) {
                                Element column = (Element)columns.item(i);
                                System.out.println(column.getAttribute("systemName"));
                                System.out.println(column.getAttribute("displayName"));
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
