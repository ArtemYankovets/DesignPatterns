package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.TV;

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
