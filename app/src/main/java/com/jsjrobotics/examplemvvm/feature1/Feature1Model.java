package com.jsjrobotics.examplemvvm.feature1;


import com.jsjrobotics.examplemvvm.utils.Consumer;

public class Feature1Model {

    private final String INTERNET_DATA = "There was no internet connection";
    public void getDataFromInternet(Consumer<String> listener){
        /* do some internet or database work and pass result to listener */
        listener.accept(INTERNET_DATA);
    }
}
