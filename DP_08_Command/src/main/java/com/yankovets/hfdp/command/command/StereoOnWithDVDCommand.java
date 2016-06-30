package com.yankovets.hfdp.command.command;

import com.yankovets.hfdp.command.receivers.Stereo;

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
