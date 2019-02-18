package com.epam.cdp.bo;

public enum RatingsView {

    FULL(0), COMPACT(1);

    private int position;

    RatingsView(int position){
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
