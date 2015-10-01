// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Sprite, ComponentContainer, Form

public class ImageSprite extends Sprite
{

    private BitmapDrawable drawable;
    private final Form form;
    private int heightHint;
    private String picturePath;
    private boolean rotates;
    private int widthHint;

    public ImageSprite(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        widthHint = -1;
        heightHint = -1;
        picturePath = "";
        form = componentcontainer.$form();
        rotates = true;
    }

    public int Height()
    {
        if (heightHint == -1 || heightHint == -2 || heightHint <= -1000)
        {
            if (drawable == null)
            {
                return 0;
            } else
            {
                return (int)((float)drawable.getBitmap().getHeight() / form.deviceDensity());
            }
        } else
        {
            return heightHint;
        }
    }

    public void Height(int i)
    {
        heightHint = i;
        registerChange();
    }

    public void HeightPercent(int i)
    {
    }

    public String Picture()
    {
        return picturePath;
    }

    public void Picture(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        picturePath = s1;
        try
        {
            drawable = MediaUtil.getBitmapDrawable(form, picturePath);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("ImageSprite", (new StringBuilder()).append("Unable to load ").append(picturePath).toString());
            drawable = null;
        }
        registerChange();
    }

    public void Rotates(boolean flag)
    {
        rotates = flag;
        registerChange();
    }

    public boolean Rotates()
    {
        return rotates;
    }

    public int Width()
    {
        if (widthHint == -1 || widthHint == -2 || widthHint <= -1000)
        {
            if (drawable == null)
            {
                return 0;
            } else
            {
                return (int)((float)drawable.getBitmap().getWidth() / form.deviceDensity());
            }
        } else
        {
            return widthHint;
        }
    }

    public void Width(int i)
    {
        widthHint = i;
        registerChange();
    }

    public void WidthPercent(int i)
    {
    }

    public void onDraw(Canvas canvas)
    {
        int i;
        int j;
        int k;
        int l;
label0:
        {
            if (drawable != null && visible)
            {
                i = (int)((float)Math.round(xLeft) * form.deviceDensity());
                j = (int)((float)Math.round(yTop) * form.deviceDensity());
                k = (int)((float)Width() * form.deviceDensity());
                l = (int)((float)Height() * form.deviceDensity());
                drawable.setBounds(i, j, i + k, j + l);
                if (rotates)
                {
                    break label0;
                }
                drawable.draw(canvas);
            }
            return;
        }
        canvas.save();
        canvas.rotate((float)(-Heading()), k / 2 + i, l / 2 + j);
        drawable.draw(canvas);
        canvas.restore();
    }
}
