package com.example.meiriq0717.gitexe;

import android.app.Application;
import android.graphics.Color;
import android.os.Environment;

import in.srain.cube.Cube;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;
import in.srain.cube.util.LocalDisplay;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class MApplication extends Application {
    private MApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }
        Cube.onCreate(instance);
        initLoader();
    }

    public void initLoader() {
        ImageLoaderFactory.customizeCache(instance, 10 * 1024, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath(), 10 * 1024);
        DefaultImageLoadHandler handler = new DefaultImageLoadHandler(this);
        handler.setImageRounded(true, LocalDisplay.dp2px(50));
        handler.setLoadingImageColor(Color.parseColor("#3fffff"));
        handler.setImageFadeIn(true);
        handler.setLoadingResources(R.mipmap.ic_launcher);
        ImageLoaderFactory.setDefaultImageLoadHandler(handler);

    }
}
