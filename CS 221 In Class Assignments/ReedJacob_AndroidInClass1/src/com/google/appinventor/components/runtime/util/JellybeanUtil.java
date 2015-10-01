// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.graphics.Point;
import android.view.Display;

public class JellybeanUtil
{

    private JellybeanUtil()
    {
    }

    public static void getRealSize(Display display, Point point)
    {
        display.getRealSize(point);
    }
}
