package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.classes.Stereo;

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
