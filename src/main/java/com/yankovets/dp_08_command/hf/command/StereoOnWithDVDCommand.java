package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Stereo;

public class StereoOnWithDVDCommand implements Command {
    Stereo stereo;

    public StereoOnWithDVDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setDVD();
        stereo.setVolume(11);
    }

    public void undo() {

    }
}
