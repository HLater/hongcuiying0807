package com.example.administrator.hongcuiying0807;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 姓名：洪翠影
 * 时间：2017/8/7.10:25
 * 类作用：
 * 思路：
 */

public class TitleSet extends RelativeLayout{
    TextView textView;//标题
    ImageView imageView;//图片
    public BarClickListener listener;//监听

    public void setListener(BarClickListener listener) {
        this.listener = listener;
    }

    /**
     * 一种参数
     * @param context
     */
    public TitleSet(Context context) {
        super(context);
        initview(null);
    }

    /**
     * 两种参数
     * @param context
     * @param attrs
     */
    public TitleSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview(attrs);
    }
    private void initview(AttributeSet attrs) {
        //获取布局
        View v = LayoutInflater.from(getContext()).inflate(R.layout.bar, this);
        textView = (TextView) v.findViewById(R.id.textview);
        imageView = (ImageView) v.findViewById(R.id.imageview);
        //标题的监听
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.titleListener(v);
                }
            }
        });
//图片的监听
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.imageListener(v);
                }
            }
        });
        //attrs判空
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TitleSet);
            //标题栏
            String str = a.getString(R.styleable.TitleSet_MYR);
            //设置字体颜色，默认黑色
            int co= a.getColor(R.styleable.TitleSet_MYZT, Color.BLACK);
            textView.setTextColor(co);
            //设置字体大小
            int size=  a.getInteger(R.styleable.TitleSet_mysize,20);
            textView.setTextSize(size);
            //设置图片的颜色，默认红色
            int ph=  a.getColor(R.styleable.TitleSet_photo,Color.RED);
            imageView.setBackgroundColor(ph);
            ///如果这是一个空的
            if (TextUtils.isEmpty(str)) {
                //就默认项目名称
                textView.setText(getResources().getString(R.string.app_name));
            } else {
                textView.setText(str);
            }
            a.recycle();//一定记得销毁
        }
    }
    //设置监听的方法
    public interface BarClickListener{
        public void imageListener(View v);
        public void titleListener(View v);
    }
}
