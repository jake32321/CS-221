// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Referenced classes of package com.google.appinventor.components.runtime:
//            File, Form

class this._cls1
    implements Runnable
{

    final l.filename this$1;

    public void run()
    {
        AfterFileSaved(filename);
    }

    l.text()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/File$2

/* anonymous class */
    class File._cls2
        implements Runnable
    {

        final com.google.appinventor.components.runtime.File this$0;
        final boolean val$append;
        final String val$filename;
        final String val$text;

        public void run()
        {
            String s = File.access$100(com.google.appinventor.components.runtime.File.this, filename);
            Object obj = new File(s);
            if (!((File) (obj)).exists())
            {
                try
                {
                    ((File) (obj)).createNewFile();
                }
                catch (IOException ioexception)
                {
                    if (append)
                    {
                        form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "AppendTo", 2103, new Object[] {
                            s
                        });
                        return;
                    } else
                    {
                        form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "SaveFile", 2103, new Object[] {
                            s
                        });
                        return;
                    }
                }
            }
            try
            {
                obj = new FileOutputStream(((File) (obj)), append);
                OutputStreamWriter outputstreamwriter = new OutputStreamWriter(((java.io.OutputStream) (obj)));
                outputstreamwriter.write(text);
                outputstreamwriter.flush();
                outputstreamwriter.close();
                ((FileOutputStream) (obj)).close();
                File.access$200(com.google.appinventor.components.runtime.File.this).runOnUiThread(new File._cls2._cls1());
                return;
            }
            catch (IOException ioexception1) { }
            if (append)
            {
                form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "AppendTo", 2104, new Object[] {
                    s
                });
                return;
            } else
            {
                form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "SaveFile", 2104, new Object[] {
                    s
                });
                return;
            }
        }

            
            {
                this$0 = final_file;
                filename = s;
                append = flag;
                text = String.this;
                super();
            }
    }

}
