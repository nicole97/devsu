package com.demoblazce.demoblaze.test;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class SetStage {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

}