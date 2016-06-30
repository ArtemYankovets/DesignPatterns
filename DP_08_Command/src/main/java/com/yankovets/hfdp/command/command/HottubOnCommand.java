package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.receivers.Hottub;

public class HottubOnCommand implements Command {
    Hottub hottub;
    int prevSpeed;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.on();
    }

    public void undo() {
        hottub.off();
    }
}
