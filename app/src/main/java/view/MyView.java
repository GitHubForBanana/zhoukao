package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.keng.zidingyi_view.R;

/**
 * Created by Keng on 2018/7/8.
 */

public class MyView extends View {
    Paint paint;
    private String text="Android";
    private int textColor= Color.WHITE;
    //构造函数（直接new 调用这个构造函数）
    public MyView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        //定义画笔
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setTextSize(18);

    }

    //构造函数（加载布局文件的时候调用 xml）
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    //构造函数（定义主题文件时使用）
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs) {
         init(context);
         TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.MyView);
         text = typedArray.getString(R.styleable.MyView_MyText);
         textColor= typedArray.getColor(R.styleable.MyView_MyTextColor,Color.WHITE);
         typedArray.recycle();
    }
   //加载xml监听
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
   //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    //获得视图的最终大小

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
    //布局

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    //绘制

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制矩形
        Rect rect=new Rect(100,100,300,300);
        canvas.drawRect(rect,paint);
        //绘制圆形
        Path path=new Path();
        path.addCircle(200,200,100,Path.Direction.CW);
        paint.setColor(Color.BLACK);
        canvas.drawPath(path,paint);
        //绘制文字
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text,200,200,paint);

    }
    //点击事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
