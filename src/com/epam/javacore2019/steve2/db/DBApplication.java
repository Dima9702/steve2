package com.epam.javacore2019.steve2.db;

import com.epam.javacore2019.steve2.db.data.QueryResult;
import com.epam.javacore2019.steve2.db.dbstate.DBState;
import com.epam.javacore2019.steve2.db.dbstate.DBStateInit;
import com.epam.javacore2019.steve2.db.dbstate.DBStateRunning;
import com.epam.javacore2019.steve2.db.dbstate.DBStateStop;

public enum DBApplication {
    INSTANCE;

    public static final String DATA_ENCRYPTION_LEVEL = "LOW";
    private DBState currentState;
    public DBState stateInit = new DBStateInit();
    public DBState stateRun = new DBStateRunning();
    public DBState stateStop = new DBStateStop();

    public void start() {
        changeState(stateInit);
    }

    public void stop() {
        currentState.onStop();
    }

    public QueryResult query(String query) {
        return null;
    }

    public void changeState(DBState state) {
        if (currentState != null) {
            if (currentState.equals(state)) {
                return;
            } else {
                currentState.exit();
            }
        }
        currentState = state;
        currentState.enter();
    }

}
