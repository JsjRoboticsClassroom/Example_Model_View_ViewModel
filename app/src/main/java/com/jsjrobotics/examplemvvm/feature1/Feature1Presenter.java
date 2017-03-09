package com.jsjrobotics.examplemvvm.feature1;

import android.support.v4.app.Fragment;

import com.jsjrobotics.examplemvvm.utils.Consumer;

import java.lang.ref.WeakReference;

class Feature1Presenter {

    private static Feature1Presenter sInstance;
    private final Feature1Model mModel;
    private WeakReference<Fragment> mContext;
    private Feature1View mView;
    private boolean mTextIsShown;

    static Feature1Presenter getInstance() {
        if (sInstance == null) {
            sInstance = new Feature1Presenter();
        }
        return sInstance;
    }

    private Feature1Presenter(){
        mModel = new Feature1Model();
    }

    void onStart(WeakReference<Fragment> context, Feature1View mFeature1View) {
        mContext = context;
        mView = mFeature1View;
        mView.hideHelloText();
        setTextShown(false);
        mView.setToggleHelloClickListener(buildToggleHelloListener());
        mView.setDownloadDataClickListener(buildDownloadListener());

    }

    private Consumer<Void> buildDownloadListener() {
        return new Consumer<Void>() {
            @Override
            public void accept(Void data) {
                mModel.getDataFromInternet(buildInternetDataReceiver());
            }
        };
    }

    private Consumer<String> buildInternetDataReceiver() {
        return new Consumer<String>() {
            @Override
            public void accept(String data) {
                mView.showInternetText(data);
            }
        };
    }

    private Consumer<Void> buildToggleHelloListener() {
        return new Consumer<Void>() {
            @Override
            public void accept(Void data) {
                setTextShown(!mTextIsShown);
            }
        };
    }

    private void setTextShown(boolean showText) {
        if (showText) {
            mView.showHelloText();
        } else {
            mView.hideHelloText();
        }
        mTextIsShown = showText;
    }
}
