package com.epam.javacore2019.steve2.db.dbstate;

public abstract class DBState {

    public void enter() {
        System.out.println("Basic entering state");
    }

    public void onQuery(String query) {
        System.out.println("Basic query handling");
    }

    public void exit() {
        System.out.println("Basic exiting state");
    }

    public void onStop() {
        System.out.println("Basic stop handling");
    }

}
