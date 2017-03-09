package com.jsjrobotics.examplemvvm.feature1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jsjrobotics.examplemvvm.R;
import com.jsjrobotics.examplemvvm.utils.Consumer;

class Feature1View {
    private final View mRoot;
    private final View mHelloText;
    private final Button mToggleButton;
    private final TextView mInternetData;
    private final Button mDownloadButton;

    Feature1View(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.feature_1_view, parent, false);
        mHelloText = mRoot.findViewById(R.id.hello);
        mInternetData = (TextView) mRoot.findViewById(R.id.internet_data);
        mDownloadButton = (Button) mRoot.findViewById(R.id.downloadInternetData);
        mToggleButton = (Button) mRoot.findViewById(R.id.toggleButton);

        mHelloText.setVisibility(View.INVISIBLE);
        mInternetData.setVisibility(View.INVISIBLE);

    }

    View getRoot() {
        return mRoot;
    }

    void showHelloText() {
        mHelloText.setVisibility(View.VISIBLE);
    }

    void showInternetText(String data) {
        mInternetData.setVisibility(View.VISIBLE);
        mInternetData.setText(data);
    }

    void hideHelloText() {
        mHelloText.setVisibility(View.INVISIBLE);
    }

    void setToggleHelloClickListener(final Consumer<Void> listener) {
        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.accept(null);
            }
        });
    }

    void setDownloadDataClickListener(final Consumer<Void> listener) {
        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.accept(null);
            }
        });
    }
}
