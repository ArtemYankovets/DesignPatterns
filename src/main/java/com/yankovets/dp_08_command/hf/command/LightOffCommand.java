package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Light;

public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}
