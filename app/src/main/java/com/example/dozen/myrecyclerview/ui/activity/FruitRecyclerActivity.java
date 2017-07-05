package com.example.dozen.myrecyclerview.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.bean.Fruit;

import com.example.dozen.myrecyclerview.databinding.ActivityFruitRecyclerBinding;
import com.example.dozen.myrecyclerview.ui.adapter.BaseActivity;
import com.example.dozen.myrecyclerview.ui.adapter.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class FruitRecyclerActivity extends BaseActivity {
    ActivityFruitRecyclerBinding mBinding;
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void getLayoutResource() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fruit_recycler);
        initFruits();
    }

    private void initFruits() {
        for(int i = 0; i < 4; i++){
            Fruit apple = new Fruit("Apple");
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana");
            fruitList.add(banana);
            Fruit pineapple = new Fruit("Pineapple");
            fruitList.add(pineapple);
            Fruit pear = new Fruit("Pear");
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape");
            fruitList.add(grape);
            Fruit orange = new Fruit("Orange");
            fruitList.add(orange);
            Fruit cherry = new Fruit("Cherry");
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango");
            fruitList.add(mango);
        }
    }

    @Override
    protected void initView() {
        initToolbar();
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mBinding.fruitRecyclerView.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList, this);
        fruitAdapter.setItemClikListener(new FruitAdapter.ItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(FruitRecyclerActivity.this, fruitList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int position) {
                Toast.makeText(FruitRecyclerActivity.this, "Item position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        //fruitAdapter.set
        mBinding.fruitRecyclerView.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBinding.fruitRecyclerView.recyclerView.setAdapter(fruitAdapter);
    }

    @Override
    protected void initToolbar() {
        toolbar = mBinding.fruitRecyclerToolbar.toolbar;
        toolbar.setTitle("Fruit");
        super.initToolbar();
    }
}
