// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.MenuItem;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ReplForm, ReplApplication, Form, Notifier

class this._cls0
    implements android.view.MenuItemClickListener
{

    final ReplForm this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem = ReplForm.access$000(ReplForm.this);
        ReplApplication.reportError(null, menuitem);
        Notifier.oneButtonAlert(Form.activeForm, (new StringBuilder()).append("Your Report Id is: ").append(menuitem).append("<br />Use this ID when reporting this error.").toString(), "Error Report Id", "OK");
        return true;
    }

    tion()
    {
        this$0 = ReplForm.this;
        super();
    }
}
