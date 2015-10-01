// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.View;

// Referenced classes of package com.google.appinventor.components.runtime:
//            VisibleComponent, ComponentContainer, Form, HandlesEventDispatching

public abstract class AndroidViewComponent extends VisibleComponent
{

    private int column;
    protected final ComponentContainer container;
    private int lastSetHeight;
    private int lastSetWidth;
    private int percentHeightHolder;
    private int percentWidthHolder;
    private int row;

    protected AndroidViewComponent(ComponentContainer componentcontainer)
    {
        percentWidthHolder = -3;
        percentHeightHolder = -3;
        lastSetWidth = -3;
        lastSetHeight = -3;
        column = -1;
        row = -1;
        container = componentcontainer;
    }

    public int Column()
    {
        return column;
    }

    public void Column(int i)
    {
        column = i;
    }

    public void CopyHeight(AndroidViewComponent androidviewcomponent)
    {
        Height(androidviewcomponent.lastSetHeight);
    }

    public void CopyWidth(AndroidViewComponent androidviewcomponent)
    {
        Width(androidviewcomponent.lastSetWidth);
    }

    public int Height()
    {
        return (int)((float)getView().getHeight() / container.$form().deviceDensity());
    }

    public void Height(int i)
    {
        container.setChildHeight(this, i);
        lastSetHeight = i;
        if (i <= -1000)
        {
            container.$form().registerPercentLength(this, i, Form.PercentStorageRecord.Dim.HEIGHT);
        }
    }

    public void HeightPercent(int i)
    {
        if (i < 0 || i > 100)
        {
            container.$form().dispatchErrorOccurredEvent(this, "HeightPercent", 2801, new Object[] {
                Integer.valueOf(i)
            });
            return;
        } else
        {
            Height(-i - 1000);
            return;
        }
    }

    public int Row()
    {
        return row;
    }

    public void Row(int i)
    {
        row = i;
    }

    public void Visible(Boolean boolean1)
    {
        View view = getView();
        int i;
        if (boolean1.booleanValue())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean Visible()
    {
        return getView().getVisibility() == 0;
    }

    public int Width()
    {
        return (int)((float)getView().getWidth() / container.$form().deviceDensity());
    }

    public void Width(int i)
    {
        container.setChildWidth(this, i);
        lastSetWidth = i;
        if (i <= -1000)
        {
            container.$form().registerPercentLength(this, i, Form.PercentStorageRecord.Dim.WIDTH);
        }
    }

    public void WidthPercent(int i)
    {
        if (i < 0 || i > 100)
        {
            container.$form().dispatchErrorOccurredEvent(this, "WidthPercent", 2801, new Object[] {
                Integer.valueOf(i)
            });
            return;
        } else
        {
            Width(-i - 1000);
            return;
        }
    }

    public HandlesEventDispatching getDispatchDelegate()
    {
        return container.$form();
    }

    public int getSetHeight()
    {
        if (percentHeightHolder == -3)
        {
            return Height();
        } else
        {
            return percentHeightHolder;
        }
    }

    public int getSetWidth()
    {
        if (percentWidthHolder == -3)
        {
            return Width();
        } else
        {
            return percentWidthHolder;
        }
    }

    public abstract View getView();

    public void setLastHeight(int i)
    {
        percentHeightHolder = i;
    }

    public void setLastWidth(int i)
    {
        percentWidthHolder = i;
    }
}
