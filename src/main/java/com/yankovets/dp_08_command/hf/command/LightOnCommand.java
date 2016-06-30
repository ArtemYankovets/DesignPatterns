package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Light;

public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
