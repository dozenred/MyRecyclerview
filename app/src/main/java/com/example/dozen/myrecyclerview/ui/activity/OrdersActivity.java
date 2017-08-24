package com.example.dozen.myrecyclerview.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.bean.Orders;
import com.example.dozen.myrecyclerview.databinding.ActivityOrdersBinding;
import com.example.dozen.myrecyclerview.ui.adapter.BaseActivity;
import com.example.dozen.myrecyclerview.ui.adapter.OrdersAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends BaseActivity {
    ActivityOrdersBinding mBinding;
    private List<Orders> ordersList;

    @Override
    protected void getLayoutResource() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_orders);
    }

    @Override
    protected void initView() {
        initToolbar();
        initData();
        initRecyclerView();
    }

    @Override
    protected void initToolbar() {
        toolbar = mBinding.fruitRecyclerToolbar.toolbar;
        toolbar.setTitle("Orders");
        super.initToolbar();
    }

    private void initRecyclerView() {
        OrdersAdapter ordersAdapter = new OrdersAdapter(ordersList);
        mBinding.ordersRecyclerView.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ordersAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(OrdersActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
        ordersAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        ordersAdapter.isFirstOnly(false);
        mBinding.ordersRecyclerView.recyclerView.setAdapter(ordersAdapter);
    }

    private void initData() {
        ordersList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            ordersList.add(new Orders("adsfdsaf", "dsafsaf"));
        }
    }


}
