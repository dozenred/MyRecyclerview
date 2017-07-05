package com.example.dozen.myrecyclerview.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dozen.myrecyclerview.R;
import com.example.dozen.myrecyclerview.bean.Student;

import com.example.dozen.myrecyclerview.databinding.ActivityStudentRecyclerBinding;
import com.example.dozen.myrecyclerview.ui.adapter.BaseActivity;
import com.example.dozen.myrecyclerview.ui.adapter.StudentAdapter;

import java.util.ArrayList;


public class StudentRecyclerActivity extends BaseActivity {
    ActivityStudentRecyclerBinding mBinding;
    private ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    protected void getLayoutResource() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_student_recycler);
    }

    @Override
    protected void initView() {
        initToolbar();
        initStudentList();
        mBinding.studentRecyclerView.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.studentRecyclerView.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        StudentAdapter studentAdapter = new StudentAdapter(studentsList, this);
        mBinding.studentRecyclerView.recyclerView.setAdapter(studentAdapter);
    }

    private void initStudentList() {
        for(int i = 0; i < 4; i++){
            Student student1 = new Student("朱", "奕达", 18.5f);
            studentsList.add(student1);
            Student student2 = new Student("阿道夫", "啊是是是", 10.5f);
            studentsList.add(student2);
            Student student3 = new Student("撒打发斯蒂芬", "升水", 22f);
            studentsList.add(student3);
            Student student4 = new Student("这些", "时的发生", 18.5f);
            studentsList.add(student4);
            Student student5 = new Student("是打发点", "我师父", 20.5f);
            studentsList.add(student5);
            Student student6 = new Student("啊", " ", 1.5f);
            studentsList.add(student6);
            Student student7 = new Student("离开家", "咯一哟哦哦哦", 18.588f);
            studentsList.add(student7);
            Student student8 = new Student("方法", "尴尬", 18.52f);
            studentsList.add(student8);
            Student student9 = new Student("自行车v", "是打发点", 8.5231456f);
            studentsList.add(student9);
            Student student10 = new Student("VB那么", "奕得到的", 18.5f);
            studentsList.add(student10);
        }

    }

    @Override
    protected void initToolbar() {
        toolbar = mBinding.studentRecyclerToolbar.toolbar;
        toolbar.setTitle("学生列表");
        super.initToolbar();

    }
}
