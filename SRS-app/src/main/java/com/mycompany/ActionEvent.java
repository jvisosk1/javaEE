package com.mycompany;

import java.io.Serializable;
import java.util.Date;

public class ActionEvent implements Serializable {
        
    public String actionType;
    public Date datetime;

    public ActionEvent() {
    }

    @Override
    public String toString() {
        return this.actionType
                + " at " + this.datetime.toString();
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
