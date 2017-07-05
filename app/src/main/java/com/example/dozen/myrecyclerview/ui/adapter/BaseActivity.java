package com.example.dozen.myrecyclerview.ui.adapter;

import android.annotation.TargetApi;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.appconfig.AppData;
import com.example.dozen.myrecyclerview.view.SystemBarTintManager;

/**
 * Created by dells on 2017/4/14.
 */

public abstract class BaseActivity extends AppCompatActivity{
    //关于Button并不能直接使用app:srcCompat来使用Vector图像，需要通过selector进行使用。但是必须t添加flag在Activity中加入
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    //保存数据
    protected Bundle savedInstanceState;
    //toolbar
    protected Toolbar toolbar;

    protected abstract void getLayoutResource();
    protected abstract void initView();

    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutResource();

        AppData.getApplication().addActivity(this);

        Log.i(TAG, "oncreate");

        this.savedInstanceState = savedInstanceState;
        initView();

        initStatusBar();
    }

    protected void initToolbar(){
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void initStatusBar(){
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
    }
    @TargetApi(19)
    protected void setTranslucentStatus(boolean on){
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        AppData.getApplication().removeActivity(this);
    }
}
