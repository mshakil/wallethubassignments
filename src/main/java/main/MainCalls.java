package main;

import pageObjects.task1.facebook_PO;

public class MainCalls {
    private static facebook_PO fb_po;
    public static facebook_PO getFb_po() {
        if(fb_po == null){
            fb_po = new facebook_PO();
        }
        return fb_po;
    }

}
