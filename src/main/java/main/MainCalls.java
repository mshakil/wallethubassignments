package main;

import pageObjects.task1.facebook_PO;
import pageObjects.task2.wallethub_PO;
import pageObjects.task2.wallethub_login_PO;
import pageObjects.task2.wallethub_review_PO;

public class MainCalls {
    private static facebook_PO fb_po;
    public static facebook_PO getFb_po() {
        if(fb_po == null){
            fb_po = new facebook_PO();
        }
        return fb_po;
    }

    private static wallethub_PO wallethub_po;
    public static wallethub_PO getWallethub_po() {
        if(wallethub_po == null){
            wallethub_po = new wallethub_PO();
        }
        return wallethub_po;
    }

    private static wallethub_login_PO wallethub_login_po;
    public static wallethub_login_PO getWallethub_login_po(){
        if(wallethub_login_po==null){
            wallethub_login_po = new wallethub_login_PO();
        }
        return wallethub_login_po;
    }

    private static wallethub_review_PO wallethub_review_po;

    public static wallethub_review_PO getWallethub_review_po(){
        if(wallethub_review_po == null)
        {
            wallethub_review_po = new wallethub_review_PO();
        }
        return wallethub_review_po;
    }

}
