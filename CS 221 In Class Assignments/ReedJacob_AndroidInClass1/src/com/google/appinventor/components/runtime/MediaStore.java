// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, EventDispatcher

public final class MediaStore extends AndroidNonvisibleComponent
    implements Component
{

    private static final String LOG_TAG_COMPONENT = "MediaStore: ";
    private Handler androidUIHandler;
    protected final ComponentContainer componentContainer;
    private String serviceURL;

    public MediaStore(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        componentContainer = componentcontainer;
        androidUIHandler = new Handler();
        serviceURL = "http://ai-mediaservice.appspot.com";
    }

    private String getUploadUrl()
    {
        Object obj;
        StringBuilder stringbuilder;
        obj = (HttpURLConnection)(new URL(serviceURL)).openConnection();
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        ((HttpURLConnection) (obj)).setRequestProperty("User-Agent", "AppInventor");
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "text/plain; charset=utf-8");
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
        stringbuilder = new StringBuilder();
_L1:
        String s = ((BufferedReader) (obj)).readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                stringbuilder.append(s);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return "";
            }
        }
          goto _L1
        ((BufferedReader) (obj)).close();
        obj = stringbuilder.toString();
        return ((String) (obj));
    }

    public void MediaStored(String s)
    {
        EventDispatcher.dispatchEvent(this, "MediaStored", new Object[] {
            s
        });
    }

    public void PostMedia(String s)
        throws FileNotFoundException
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final MediaStore this$0;

            public void onFailure(String s1)
            {
                androidUIHandler.post(s1. new Runnable() {

                    final _cls1 this$1;
                    final String val$message;

                    public void run()
                    {
                        WebServiceError(message);
                    }

            
            {
                this$1 = final__pcls1;
                message = String.this;
                super();
            }
                });
            }

            public volatile void onSuccess(Object obj1)
            {
                onSuccess((String)obj1);
            }

            public void onSuccess(String s1)
            {
                androidUIHandler.post(s1. new Runnable() {

                    final _cls1 this$1;
                    final String val$response;

                    public void run()
                    {
                        MediaStored(response);
                    }

            
            {
                this$1 = final__pcls1;
                response = String.this;
                super();
            }
                });
            }

            
            {
                this$0 = MediaStore.this;
                super();
            }
        };
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            Object obj = MultipartEntityBuilder.create();
            ((MultipartEntityBuilder) (obj)).setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            if (s.split("/")[0].equals("file:"))
            {
                s = (new File((new URL(s)).toURI())).getAbsolutePath();
            }
            ((MultipartEntityBuilder) (obj)).addPart("file", new FileBody(new File(s)));
            s = ((MultipartEntityBuilder) (obj)).build();
            obj = new HttpPost(getUploadUrl());
            ((HttpPost) (obj)).setEntity(s);
            asynccallbackpair.onSuccess(EntityUtils.toString(defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj))).getEntity()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        asynccallbackpair.onFailure(s.getMessage());
    }

    public String ServiceURL()
    {
        return serviceURL;
    }

    public void ServiceURL(String s)
    {
        serviceURL = s;
    }

    public void WebServiceError(String s)
    {
        EventDispatcher.dispatchEvent(this, "WebServiceError", new Object[] {
            s
        });
    }

}
