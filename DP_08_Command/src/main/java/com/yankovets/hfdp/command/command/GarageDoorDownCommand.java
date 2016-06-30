package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.classes.GarageDoor;

public class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.lightOff();
        garageDoor.down();
    }

    public void undo() {

    }
}
