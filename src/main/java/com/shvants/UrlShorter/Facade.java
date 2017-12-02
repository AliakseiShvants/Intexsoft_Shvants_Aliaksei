package com.shvants.UrlShorter;

public class Facade {

    private static volatile Facade instance;

    private Facade() {
    }

    public static Facade getInstance(){
        if (instance == null){
            synchronized (Facade.class){
                if (instance == null){
                    instance = new Facade();
                }
            }
        }
        return instance;
    }
}
