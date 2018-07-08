package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.keng.zidingyi_view.R;

/**
 * Created by Keng on 2018/7/8.
 */

public class CountDownView extends View {
     //画笔
    Paint paint;
    int time;
    float radius;
    int textColor;
    int bgColor;

    int cx;
    int cy;
    public CountDownView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //初始化属性
        if (attrs!=null) {
            //获取属性列表
            TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyView);
             //初始化自定义属性
            time=typedArray.getInteger(R.styleable.MyView_CountDownTime,3);
            radius=typedArray.getDimension(R.styleable.MyView_CountDownRadius,25);
            textColor=typedArray.getColor(R.styleable.MyView_CountDownTextColor, Color.BLACK);
            bgColor=typedArray.getColor(R.styleable.MyView_CountDownBgColor,Color.WHITE);
           //释放
            typedArray.recycle();

        }else {
            time=3;
            radius=30;
            textColor=Color.BLACK;
            bgColor=Color.WHITE;
        }
  //初始化画笔
        paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(bgColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
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
        cx=w/2;
        cy=h/2;

    }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        Path path=new Path();
        path.addCircle(cx,cy,radius,Path.Direction.CW);
        canvas.drawPath(path,paint);

        //绘制文字
        paint.setColor(textColor);
        paint.setTextSize(20);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(""+time,cx,cy,paint);

    }
}
