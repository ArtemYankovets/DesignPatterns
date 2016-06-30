package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.TV;

public class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }

    public void undo() {
        tv.on();
    }
}
