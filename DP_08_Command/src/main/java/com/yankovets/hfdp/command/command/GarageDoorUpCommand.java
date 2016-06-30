package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.classes.GarageDoor;

public class GarageDoorUpCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
    }

    public void undo() {

    }
}
