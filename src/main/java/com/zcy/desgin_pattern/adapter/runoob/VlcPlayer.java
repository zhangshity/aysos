package com.zcy.desgin_pattern.adapter.runoob;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:47 2018-12-14
 * @ Modified: By:
 */

public class VlcPlayer implements AdvancedMediaPlayer {


    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
