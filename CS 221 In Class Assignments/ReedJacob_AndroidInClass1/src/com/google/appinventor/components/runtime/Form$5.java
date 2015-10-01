// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import android.widget.FrameLayout;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Form

class this._cls0
    implements Runnable
{

    final Form this$0;

    public void run()
    {
        if (Form.access$000(Form.this) != null && Form.access$000(Form.this).getWidth() != 0 && Form.access$000(Form.this).getHeight() != 0)
        {
            if (Form.access$300())
            {
                Sizing("Fixed");
            } else
            {
                Sizing("Responsive");
            }
            ReplayFormOrientation();
            Form.access$000(Form.this).requestLayout();
            return;
        } else
        {
            Form.access$200(Form.this).post(this);
            return;
        }
    }

    ()
    {
        this$0 = Form.this;
        super();
    }
}
