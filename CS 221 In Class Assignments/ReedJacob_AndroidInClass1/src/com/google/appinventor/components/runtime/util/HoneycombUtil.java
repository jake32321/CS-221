// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.view.View;
import android.view.ViewGroup;

public class HoneycombUtil
{

    public static final int VIEWGROUP_MEASURED_HEIGHT_STATE_SHIFT = 16;

    private HoneycombUtil()
    {
    }

    public static int combineMeasuredStates(ViewGroup viewgroup, int i, int j)
    {
        return ViewGroup.combineMeasuredStates(i, j);
    }

    public static int getMeasuredState(View view)
    {
        return view.getMeasuredState();
    }

    public static int resolveSizeAndState(ViewGroup viewgroup, int i, int j, int k)
    {
        return ViewGroup.resolveSizeAndState(i, j, k);
    }
}
