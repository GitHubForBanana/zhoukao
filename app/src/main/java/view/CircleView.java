package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.keng.zidingyi_view.R;

/**
 * Created by Keng on 2018/7/8.
 */

public class CircleView extends View {
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //绘制


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        BitmapShader bitmapShader=new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(bitmap,300,300,paint);
    }



}
