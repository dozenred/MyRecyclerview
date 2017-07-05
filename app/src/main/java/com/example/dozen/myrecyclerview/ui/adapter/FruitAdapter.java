package com.example.dozen.myrecyclerview.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.bean.Fruit;
import com.example.dozen.myrecyclerview.databinding.ListFruitItemBinding;
import com.example.dozen.myrecyclerview.ui.activity.StudentRecyclerActivity;

import java.util.List;

/**
 * Created by dells on 2017/5/3.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> fruitList;
    private Context mContext;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_fruit_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.mFruitItemBinding.fruitName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = viewHolder.getAdapterPosition();
//                Fruit fruit = fruitList.get(position);
//                Toast.makeText(v.getContext(), "fruit name:" + fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = viewHolder.getAdapterPosition();
//                Fruit fruit = fruitList.get(position);
//                Intent intent = new Intent(mContext, StudentRecyclerActivity.class);
//                Toast.makeText(v.getContext(), "Item name:" + fruit.getName(), Toast.LENGTH_SHORT).show();
//                mContext.startActivity(intent);
//            }
//        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final Fruit fruit = fruitList.get(i);
        viewHolder.mFruitItemBinding.setFruit(fruit);
        viewHolder.mFruitItemBinding.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null){
                    itemClickListener.onClick(i);
                }
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null){
                    itemClickListener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public FruitAdapter(List<Fruit> fruitList, Context mContext){
        this.mContext = mContext;
        this.fruitList = fruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ListFruitItemBinding mFruitItemBinding;
        View itemView;
        //TextView fruitName_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            //fruitName_tv = (TextView)itemView.findViewById(R.id.fruit_name);
            mFruitItemBinding = DataBindingUtil.bind(itemView);
            //fruitName_tv=mFruitItemBinding.fruitName;
        }
    }

    private ItemClickListener itemClickListener;

    public interface ItemClickListener{
        void onClick(int position);
        void onItemClick(int position);
    }

    public void setItemClikListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

}
