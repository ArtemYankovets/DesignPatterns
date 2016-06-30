package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.GarageDoor;

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
