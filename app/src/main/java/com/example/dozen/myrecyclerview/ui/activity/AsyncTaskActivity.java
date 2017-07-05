package com.example.dozen.myrecyclerview.ui.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.Toast;

import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.databinding.ActivityAsyncTaskBinding;
import com.example.dozen.myrecyclerview.ui.adapter.BaseActivity;

public class AsyncTaskActivity extends BaseActivity {
    ActivityAsyncTaskBinding mBinding;
    @Override
    protected void getLayoutResource() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_async_task);
    }

    @Override
    protected void initView() {
        initToolbar();
        clickAsyncTaskButton();
    }

    private void clickAsyncTaskButton() {
        mBinding.startAsyncTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hi", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void initToolbar() {
        toolbar = mBinding.asyncTaskToolbar.toolbar;
        toolbar.setTitle("异步线程");
        super.initToolbar();
    }
}
