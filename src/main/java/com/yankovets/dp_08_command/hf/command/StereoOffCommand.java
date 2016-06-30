package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Stereo;

public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
    }

    public void undo() {

    }
}
