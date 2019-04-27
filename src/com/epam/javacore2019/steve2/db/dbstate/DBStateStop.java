package com.epam.javacore2019.steve2.db.dbstate;

import com.epam.javacore2019.steve2.db.misc.DBConstants;
import com.epam.javacore2019.steve2.db.misc.DataEncryptor;
import com.epam.javacore2019.steve2.db.misc.Utils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

    @Override
    public void enter() {
        System.out.println("Entering DBStop state");

        List<String> list = new ArrayList<>();
        list.add("test string one");
        list.add("test string two");
        DataEncryptor encript = new DataEncryptor() {
            @Override
            public String encrypt(String text) {
                return text;
            }
        };
        Utils.writeListToFile(list, DBConstants.DATA_DIR + "/test.dat", encript);
    }

    @Override
    public void onStop() {
        System.out.println("Already trying to stop...");
    }
}
