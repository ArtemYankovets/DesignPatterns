package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Hottub;

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
