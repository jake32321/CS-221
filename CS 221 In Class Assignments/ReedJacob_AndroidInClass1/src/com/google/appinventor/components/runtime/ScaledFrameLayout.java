// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;

public class ScaledFrameLayout extends ViewGroup
{

    private int mLeftWidth;
    private int mRightWidth;
    private float mScale;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;

    public ScaledFrameLayout(Context context)
    {
        super(context);
        mTmpContainerRect = new Rect();
        mTmpChildRect = new Rect();
        mScale = 1.0F;
    }

    public ScaledFrameLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ScaledFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mTmpContainerRect = new Rect();
        mTmpChildRect = new Rect();
        mScale = 1.0F;
        setClipChildren(false);
    }

    private void updatePadding(int i, int j)
    {
        setPadding(0, 0, (int)(((float)i * (mScale - 1.0F)) / mScale), (int)(((float)j * (mScale - 1.0F)) / mScale));
    }

    protected void dispatchDraw(Canvas canvas)
    {
        canvas.save(1);
        canvas.scale(mScale, mScale);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        motionevent.setLocation(motionevent.getX() * (1.0F / mScale), motionevent.getY() * (1.0F / mScale));
        super.dispatchTouchEvent(motionevent);
        return true;
    }

    public ViewParent invalidateChildInParent(int ai[], Rect rect)
    {
        int i = (int)((float)ai[0] * mScale);
        int j = (int)((float)ai[1] * mScale);
        ai = new Rect((int)((float)rect.left * mScale), (int)((float)rect.top * mScale), (int)((float)rect.right * mScale), (int)((float)rect.bottom * mScale));
        invalidate(ai);
        return super.invalidateChildInParent(new int[] {
            i, j
        }, ai);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int j1 = getChildCount();
        k = getPaddingLeft();
        int k1 = getPaddingTop();
        int l1 = getPaddingBottom();
        for (i = 0; i < j1;)
        {
            View view = getChildAt(i);
            int i1 = k;
            if (view.getVisibility() != 8)
            {
                int i2 = view.getMeasuredWidth();
                int j2 = view.getMeasuredHeight();
                mTmpContainerRect.left = k;
                mTmpContainerRect.right = k;
                i1 = mTmpContainerRect.right;
                mTmpContainerRect.top = k1;
                mTmpContainerRect.bottom = l - j - l1;
                Gravity.apply(51, i2, j2, mTmpContainerRect, mTmpChildRect);
                view.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            }
            i++;
            k = i1;
        }

    }

    protected void onMeasure(int i, int j)
    {
        int j2 = getChildCount();
        mLeftWidth = 0;
        mRightWidth = 0;
        int l = 0;
        int k = 0;
        for (int i1 = 0; i1 < j2;)
        {
            View view = getChildAt(i1);
            int i2 = k;
            int k1 = l;
            if (view.getVisibility() != 8)
            {
                measureChild(view, i, j);
                mLeftWidth = mLeftWidth + Math.max(0, view.getMeasuredWidth());
                l = Math.max(l, view.getMeasuredHeight());
                i2 = k;
                k1 = l;
                if (SdkLevel.getLevel() >= 11)
                {
                    i2 = HoneycombUtil.combineMeasuredStates(this, k, HoneycombUtil.getMeasuredState(view));
                    k1 = l;
                }
            }
            i1++;
            k = i2;
            l = k1;
        }

        int j1 = mLeftWidth;
        int l1 = mRightWidth;
        l = Math.max(l, getSuggestedMinimumHeight());
        j1 = Math.max(0 + (j1 + l1), getSuggestedMinimumWidth());
        if (SdkLevel.getLevel() >= 11)
        {
            setMeasuredDimension(HoneycombUtil.resolveSizeAndState(this, j1, i, k), HoneycombUtil.resolveSizeAndState(this, l, j, k << 16));
            return;
        } else
        {
            setMeasuredDimension(resolveSize(j1, i), resolveSize(l, j));
            return;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        updatePadding(i, j);
    }

    public void setScale(float f)
    {
        mScale = f;
        updatePadding(getWidth(), getHeight());
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}
