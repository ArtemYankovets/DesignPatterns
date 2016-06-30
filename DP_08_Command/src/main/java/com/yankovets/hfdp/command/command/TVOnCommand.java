package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.classes.TV;

public class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
        tv.setInputChennel();
    }

    public void undo() {
        tv.off();
    }
}
