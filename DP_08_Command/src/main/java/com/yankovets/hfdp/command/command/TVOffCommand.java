package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.receivers.TV;

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
