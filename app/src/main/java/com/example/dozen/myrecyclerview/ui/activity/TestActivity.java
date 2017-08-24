package com.example.dozen.myrecyclerview.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.example.dozen.myrecyclerview.R;

import com.example.dozen.myrecyclerview.databinding.ActivityTestBinding;
import com.example.dozen.myrecyclerview.ui.adapter.BaseActivity;

public class TestActivity extends BaseActivity {
    ActivityTestBinding mBinding;

    @Override
    protected void getLayoutResource() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test);
    }

    @Override
    protected void initView() {
        initToolbar();
        jumpToFruit();
        jumpToStudent();
        jumpToAsyncTask();
        jumpToOrders();
    }

    private void jumpToFruit() {
        mBinding.jumpFruitRecyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FruitRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void jumpToStudent() {
        mBinding.jumpStudentRecyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StudentRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void jumpToAsyncTask() {
        mBinding.jumpAsyncTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AsyncTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    private void jumpToOrders() {
        mBinding.jumpOrdersRecyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrdersActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void initToolbar() {
        toolbar = mBinding.testToolbar.toolbar;
        toolbar.setTitle("test1");
        toolbar.setNavigationIcon(null);
        super.initToolbar();
    }

}
