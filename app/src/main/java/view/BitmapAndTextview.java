package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.keng.zidingyi_view.R;

/**
 * Created by Keng on 2018/7/8.
 */

public class BitmapAndTextview extends View {
    //定义画笔
    Paint paint;
    //定义监听事件
    MyClickListener listener;
    //定义全局区域
    Region region;
    //切割圆形区域
    Region circleRegion;

    public BitmapAndTextview(Context context) {
        super(context);
        init(context);
    }
    //初始化变量
    private void init(Context context) {
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

        region=new Region();
        circleRegion=new Region();
    }
   //初始化变量，初始化自定义属性
    public BitmapAndTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        init(context);
    }

    //测量控件大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    //最终控件大小

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //设置全局区域范围
        Rect rect=new Rect(0,0,w,h);
        region.set(rect);
    }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制图片
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,200,200,paint);

        //定义圆形区域路径
        Path path=new Path();
        path.addCircle(200,200,100,Path.Direction.CW);

        //切割圆形区域
        circleRegion.setPath(path,region);

        //画原型
        canvas.drawPath(path,paint);
    }
   //事件处理

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                int x= (int) event.getX();
                int y= (int) event.getY();

                if(circleRegion.contains(x,y)){

                    if(listener!=null){
                      listener.innerToast(this);
                    }

                }else {
                    if(listener!=null){
                        listener.outerToast(this);
                    }
                }
                break;
                default:
                    break;

        }
        return super.onTouchEvent(event);
    }
    //接口
    public  interface  MyClickListener{
        void innerToast(View view);
        void outerToast(View view);
    }
    //向外提供的接口
    public void setMyListener(MyClickListener listener){
        this.listener=listener;
    }
}
