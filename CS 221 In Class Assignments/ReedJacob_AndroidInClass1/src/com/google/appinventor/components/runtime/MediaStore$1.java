// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;

// Referenced classes of package com.google.appinventor.components.runtime:
//            MediaStore

class this._cls0
    implements AsyncCallbackPair
{

    final MediaStore this$0;

    public void onFailure(final String message)
    {
        MediaStore.access$000(MediaStore.this).post(new Runnable() {

            final MediaStore._cls1 this$1;
            final String val$message;

            public void run()
            {
                WebServiceError(message);
            }

            
            {
                this$1 = MediaStore._cls1.this;
                message = s;
                super();
            }
        });
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(final String response)
    {
        MediaStore.access$000(MediaStore.this).post(new Runnable() {

            final MediaStore._cls1 this$1;
            final String val$response;

            public void run()
            {
                MediaStored(response);
            }

            
            {
                this$1 = MediaStore._cls1.this;
                response = s;
                super();
            }
        });
    }

    _cls2.val.message()
    {
        this$0 = MediaStore.this;
        super();
    }
}
