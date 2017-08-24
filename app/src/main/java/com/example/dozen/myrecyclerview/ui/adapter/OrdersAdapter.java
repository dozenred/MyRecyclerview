package com.example.dozen.myrecyclerview.ui.adapter;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.bean.Orders;
import com.example.dozen.myrecyclerview.databinding.ListOrdersItemBinding;

import java.util.List;

/**
 * Created by Dozen on 2017/8/24.
 */

public class OrdersAdapter extends BaseQuickAdapter<Orders, OrdersAdapter.ViewHolder> {
    private List<Orders> ordersList;


    public OrdersAdapter(List<Orders> ordersList) {
        super(R.layout.list_orders_item, ordersList);
        this.ordersList = ordersList;
    }

    @Override
    protected void convert(ViewHolder helper, Orders item) {
        item = ordersList.get(helper.getLayoutPosition());
        helper.mBinding.setOrders(item);
    }

    public class ViewHolder extends BaseViewHolder {
        ListOrdersItemBinding mBinding;
        View view;
        public ViewHolder(View view) {
            super(view);
            this.view = view;
            mBinding = DataBindingUtil.bind(view);
        }
    }

}
