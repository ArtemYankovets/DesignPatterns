package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.receivers.Hottub;

public class HottubOffCommand implements Command {
    Hottub hottub;
    int prevSpeed;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.off();
    }

    public void undo() {
        hottub.on();
    }
}
