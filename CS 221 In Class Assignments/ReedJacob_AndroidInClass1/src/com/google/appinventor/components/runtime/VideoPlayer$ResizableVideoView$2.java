// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            VideoPlayer

class val.trycount
    implements Runnable
{

    final val.trycount this$1;
    final int val$specheight;
    final int val$specwidth;
    final int val$trycount;

    public void run()
    {
        cess._mth000(this._cls1.this, val$specwidth, val$specheight, val$trycount + 1);
    }

    ()
    {
        this$1 = final_;
        val$specwidth = i;
        val$specheight = j;
        val$trycount = I.this;
        super();
    }
}
