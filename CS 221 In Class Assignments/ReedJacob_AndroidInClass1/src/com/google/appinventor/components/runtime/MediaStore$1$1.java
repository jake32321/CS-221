// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;

// Referenced classes of package com.google.appinventor.components.runtime:
//            MediaStore

class val.response
    implements Runnable
{

    final val.response this$1;
    final String val$response;

    public void run()
    {
        MediaStored(val$response);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$response = String.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/MediaStore$1

/* anonymous class */
    class MediaStore._cls1
        implements AsyncCallbackPair
    {

        final MediaStore this$0;

        public void onFailure(final String message)
        {
            MediaStore.access$000(MediaStore.this).post(new MediaStore._cls1._cls2());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((String)obj);
        }

        public void onSuccess(String s)
        {
            MediaStore.access$000(MediaStore.this).post(s. new MediaStore._cls1._cls1());
        }

            
            {
                this$0 = MediaStore.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/MediaStore$1$2

/* anonymous class */
        class MediaStore._cls1._cls2
            implements Runnable
        {

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
        }

    }

}
