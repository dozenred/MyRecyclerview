package com.example.dozen.myrecyclerview.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.bean.Student;
import com.example.dozen.myrecyclerview.databinding.ListStudentItemBinding;

import java.util.ArrayList;

/**
 * Created by dells on 2017/5/5.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> studentList;
    private Context context;
    public StudentAdapter(ArrayList<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_student_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mListStudentItemBinding.studentFirstnameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "firstname: " + studentList.get(viewHolder.getAdapterPosition()).getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "this is : " + studentList.get(viewHolder.getAdapterPosition()).getInfo(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Student student = studentList.get(i);
        viewHolder.mListStudentItemBinding.setStudent(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ListStudentItemBinding mListStudentItemBinding;
        private View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            mListStudentItemBinding = DataBindingUtil.bind(itemView);

        }
    }
}
