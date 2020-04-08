package com.bigcat.app.dto;

public class HN5SmallBell {

    public boolean HN5_SMALL_BELL = true;

    public void bell(){
        HN5_SMALL_BELL = false;
    }
    public void endService(){
        HN5_SMALL_BELL = true;
    }
    public boolean listenBell(){
        return HN5_SMALL_BELL;
    }
}
