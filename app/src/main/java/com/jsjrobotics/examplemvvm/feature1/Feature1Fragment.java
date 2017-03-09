package com.jsjrobotics.examplemvvm.feature1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

public class Feature1Fragment extends Fragment {
    private Feature1Presenter mPresenter;
    private Feature1View mFeature1View;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = Feature1Presenter.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        WeakReference<Fragment> weakReference = new WeakReference<Fragment>(this);
        mPresenter.onStart(weakReference, mFeature1View);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mFeature1View = new Feature1View(inflater, parent, savedInstanceState);
        return mFeature1View.getRoot();
    }
}
