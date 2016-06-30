package com.yankovets.dp_08_command.hf.command;

import com.yankovets.dp_08_command.hf.classes.Stereo;

public class StereoOnWithRadioCommand implements Command {
    Stereo stereo;

    public StereoOnWithRadioCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setRadio();
        stereo.setVolume(11);
    }

    public void undo() {

    }
}
