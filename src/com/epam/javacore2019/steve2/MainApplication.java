package com.epam.javacore2019.steve2;

import com.epam.javacore2019.steve2.webservice.WebClientApplication;

public class MainApplication {

    public static void main(String[] args) {
        //DBApplication.INSTANCE.start();
        try {
            WebClientApplication.INSTANCE.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
