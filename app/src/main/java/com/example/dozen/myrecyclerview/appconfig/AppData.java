package com.example.dozen.myrecyclerview.appconfig;

import android.app.Activity;
import android.app.Application;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by dells on 2017/4/17.
 */

public class AppData extends Application {
    private static AppData instance;
    private final LinkedList<Activity> activityLinkedList = new LinkedList();
    /**
     * 在Application中创建一个HashMap<String,Object> ，以字符串为索引，Object为value
     * 这样我们的HashMap就可以存储任何类型的对象了。
     * 在Activity A中把需要传递的对象放入这个HashMap，然后通过Intent或者其它途经再把这人索引的字符串传递给Activity B ,
     * Activity B 就可以根据这个字符串在HashMap中取出这个对象了。只要再向下转个型 ，就实现了对象的传递。
     */
    private static HashMap<String, Object> dataTransmission_map;
    /**
     * 我一般会习惯在application中建立两个HashMap<String,Object>一个用于数据的传递，一个用于缓存一些数据。
     * 比如有一个Activity需要从网站获取一些数据，获取完之后我们就可以把这个数据cache到Application当中，
     * 当页面设置到其它Activity再回来的时候，就可以直接使用缓存好的数据了。
     * 但如果需要cache一些大量的数据，最好是cache一些 (软引用)SoftReference并把这些数据cache到本地rom上或者sd卡上。
     * 如果在application中的缓存不存在，从本地缓存查找，如果本地缓存的数据也不存在再从网络上获取。
     */
    private static HashMap<String, Object> dataCatching_map;

    public static AppData getApplication(){
        return instance;
    }

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }



    public void addActivity(Activity activity){
        activityLinkedList.add(activity);
    }

    public void removeActivity(Activity activity){
        activityLinkedList.remove(activity);
    }

    public void finishAllActivities(){
        for (Activity activity : activityLinkedList){
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


}
