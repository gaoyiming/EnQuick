package com.enquick.mrgao.enquick.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Mr_g on 2016/11/18.
 */

public class WaveItem extends View {

    private float mWidth = 0f;
    private float mHigh = 0f;
    private Paint paint;
    private int num=4;
    private int mJumpValue = 0;
    private float mAnimatedValue = 0f;
    private ValueAnimator valueAnimator;


    public WaveItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));
    }

    public WaveItem(Context context) {
        this(context,null);
    }

    public WaveItem(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHigh = getMeasuredHeight();

    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        float circularX = mWidth / num;

        for (int i = 0; i < num; i++) {
            if (i == mJumpValue % num) {

                canvas.drawRect(circularX*i,50-mAnimatedValue*50,circularX*i+10,100+mAnimatedValue*50,paint);

            } else {
                canvas.drawRect(circularX*i,50,circularX*i+10,100,paint);

            }
            canvas.drawRect(circularX*i,50,circularX*i+10,100,paint);
        }

    }

    public void setAnimationDelay(int i) {
        valueAnimator = ValueAnimator.ofFloat(0,1,0);
       // valueAnimator = ValueAnimator.ofFloat(startF, endF);
        valueAnimator.setDuration(500);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                mAnimatedValue = (float) valueAnimator.getAnimatedValue();


//                if (mAnimatedValue > 0.5) {
//                    mAnimatedValue = 1 - mAnimatedValue;
//                }

                invalidate();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                mJumpValue++;
            }
        });
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();

        }

      //  return valueAnimator;

    }
}
