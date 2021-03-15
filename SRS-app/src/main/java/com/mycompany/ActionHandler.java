package com.mycompany;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.ActionEvent;
import com.mycompany.Logged;
import com.mycompany.Register;
import com.mycompany.Withdraw;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

/**
 * Handler for the two kinds of ActionEvent.
 */

@Logged
@SessionScoped
public class ActionHandler implements Serializable {

    private static final Logger logger =
            Logger.getLogger(ActionHandler.class.getCanonicalName());

    public ActionHandler() {
        logger.log(Level.INFO, "ActionHandler created.");
    }

    public void registerAction(@Observes @Register ActionEvent event) {
        logger.log(Level.INFO, "ActionHandler - Register Handler: {0}",
                event.toString());

        // call a specific Register handler class...
    }

    public void withdrawAction(@Observes @Withdraw ActionEvent event) {
        logger.log(Level.INFO, "ActionHandler - Withdraw Handler: {0}",
                event.toString());
 
        // call a specific Withdraw handler class...
    }
}
