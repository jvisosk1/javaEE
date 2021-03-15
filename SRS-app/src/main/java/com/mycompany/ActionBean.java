package com.mycompany;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import com.mycompany.ActionEvent;
import com.mycompany.Logged;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean that fires WITHDRAW and REGISTER events based on UI selection.
 * Check server log output for event handling output.
 */

@Named
@SessionScoped

public class ActionBean implements Serializable {

    private static final Logger logger =
            Logger.getLogger(ActionBean.class.getCanonicalName());

    @Inject
    @Register
    Event<ActionEvent> registerEvent;

    @Inject
    @Withdraw
    Event<ActionEvent> withdrawEvent;

    private static final int WITHDRAW = 1;
    private static final int REGISTER = 2;    
    private int actionOption = WITHDRAW;
    private String nextAction = null;
    private Date datetime;

    /**
     * Fires a action event.
     *
     * @return the response page location
     */

        
    public String doIt() {
        this.setDatetime(Calendar.getInstance().getTime());
        switch (actionOption) {
            case WITHDRAW:
                ActionEvent withdrawPayload = new ActionEvent();
                withdrawPayload.setActionType("Withdraw");
                withdrawPayload.setDatetime(datetime);
                withdrawEvent.fire(withdrawPayload);
                nextAction = "withdraw_page";
                break;
            case REGISTER:
                ActionEvent registerPayload = new ActionEvent();
                registerPayload.setActionType("Register");
                registerPayload.setDatetime(datetime);
                registerEvent.fire(registerPayload);
                nextAction = "reg_page";
                break;
            default:
                logger.severe("Invalid action option!");
        }
            
        return nextAction;

    }

    /**
     * Resets the values in the index page.
     */

    @Logged
    public void reset() {
        setActionOption(WITHDRAW);
    }

    public int getActionOption() {
        return this.actionOption;
    }

    public void setActionOption(int actionType) {
        this.actionOption = actionType;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
    