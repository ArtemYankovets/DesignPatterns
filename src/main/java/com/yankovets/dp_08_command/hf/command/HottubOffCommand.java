package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Hottub;

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
