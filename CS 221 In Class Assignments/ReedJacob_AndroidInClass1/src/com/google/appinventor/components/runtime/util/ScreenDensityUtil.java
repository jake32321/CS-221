// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            SdkLevel, JellybeanUtil

public final class ScreenDensityUtil
{

    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    private static final String LOG_TAG = "ScreenDensityUtil";
    public static final float MAXIMUM_ASPECT_RATIO = 1.779167F;

    private ScreenDensityUtil()
    {
    }

    public static float computeCompatibleScaling(Context context)
    {
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        Point point = new Point();
        getRawScreenDim(context, point);
        int i = point.x;
        int j = point.y;
        float f;
        float f1;
        int k;
        int l;
        int i1;
        if (i < j)
        {
            i1 = i;
            l = j;
        } else
        {
            i1 = j;
            l = i;
        }
        k = (int)(320F * displaymetrics.density + 0.5F);
        f1 = (float)l / (float)i1;
        f = f1;
        if (f1 > 1.779167F)
        {
            f = 1.779167F;
        }
        l = (int)((float)k * f + 0.5F);
        if (i < j)
        {
            i1 = k;
            k = l;
        } else
        {
            i1 = l;
        }
        f = (float)i / (float)i1;
        f1 = (float)j / (float)k;
        if (f >= f1)
        {
            f = f1;
        }
        f1 = f;
        if (f < 1.0F)
        {
            f1 = 1.0F;
        }
        return f1;
    }

    public static void getRawScreenDim(Context context, Point point)
    {
        new DisplayMetrics();
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        int i = SdkLevel.getLevel();
        if (i >= 17)
        {
            JellybeanUtil.getRealSize(context, point);
            return;
        }
        if (i <= 10)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        Method method;
        Method method1;
        method = android/view/Display.getMethod("getRawHeight", new Class[0]);
        method1 = android/view/Display.getMethod("getRawWidth", new Class[0]);
        point.x = ((Integer)method1.invoke(context, new Object[0])).intValue();
        point.y = ((Integer)method.invoke(context, new Object[0])).intValue();
        return;
        context;
        try
        {
            Log.e("ScreenDensityUtil", "Error reading raw screen size", context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("ScreenDensityUtil", "Error reading raw screen size", context);
        }
        return;
        context;
        Log.e("ScreenDensityUtil", "Error reading raw screen size", context);
        return;
        context;
        Log.e("ScreenDensityUtil", "Error reading raw screen size", context);
        return;
        point.x = context.getWidth();
        point.y = context.getHeight();
        return;
    }
}
