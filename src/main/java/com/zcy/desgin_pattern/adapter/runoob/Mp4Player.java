package com.zcy.desgin_pattern.adapter.runoob;

import com.zcy.desgin_pattern.adapter.runoob.AdvancedMediaPlayer;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:48 2018-12-14
 * @ Modified: By:
 */

public class Mp4Player implements AdvancedMediaPlayer {


    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
