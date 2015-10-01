// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.io.PrintStream;

// Referenced classes of package com.google.appinventor.components.runtime:
//            HVArrangement, AndroidViewComponent

class val.trycount
    implements Runnable
{

    final HVArrangement this$0;
    final AndroidViewComponent val$component;
    final int val$fWidth;
    final int val$trycount;

    public void run()
    {
        System.err.println("(HVArrangement)Width not stable yet... trying again");
        setChildWidth(val$component, val$fWidth, val$trycount + 1);
    }

    nent()
    {
        this$0 = final_hvarrangement;
        val$component = androidviewcomponent;
        val$fWidth = i;
        val$trycount = I.this;
        super();
    }
}
