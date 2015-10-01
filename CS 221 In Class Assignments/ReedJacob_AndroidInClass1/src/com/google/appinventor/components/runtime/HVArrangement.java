// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.PrintStream;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, Component, ComponentContainer, LinearLayout, 
//            Form

public class HVArrangement extends AndroidViewComponent
    implements Component, ComponentContainer
{

    private final AlignmentUtil alignmentSetter;
    private final Handler androidUIHandler = new Handler();
    private final Activity context;
    private int horizontalAlignment;
    private final int orientation;
    private int verticalAlignment;
    private final LinearLayout viewLayout;

    public HVArrangement(ComponentContainer componentcontainer, int i)
    {
        super(componentcontainer);
        context = componentcontainer.$context();
        orientation = i;
        viewLayout = new LinearLayout(context, i, Integer.valueOf(100), Integer.valueOf(100));
        viewLayout.setBaselineAligned(false);
        alignmentSetter = new AlignmentUtil(viewLayout);
        horizontalAlignment = 1;
        verticalAlignment = 1;
        alignmentSetter.setHorizontalAlignment(horizontalAlignment);
        alignmentSetter.setVerticalAlignment(verticalAlignment);
        componentcontainer.$add(this);
    }

    public void $add(AndroidViewComponent androidviewcomponent)
    {
        viewLayout.add(androidviewcomponent);
    }

    public Activity $context()
    {
        return context;
    }

    public Form $form()
    {
        return container.$form();
    }

    public int AlignHorizontal()
    {
        return horizontalAlignment;
    }

    public void AlignHorizontal(int i)
    {
        try
        {
            alignmentSetter.setHorizontalAlignment(i);
            horizontalAlignment = i;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            container.$form().dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public int AlignVertical()
    {
        return verticalAlignment;
    }

    public void AlignVertical(int i)
    {
        try
        {
            alignmentSetter.setVerticalAlignment(i);
            verticalAlignment = i;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            container.$form().dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public View getView()
    {
        return viewLayout.getLayoutManager();
    }

    public void setChildHeight(final AndroidViewComponent component, final int fHeight)
    {
        int j = container.$form().Height();
        if (j == 0)
        {
            androidUIHandler.postDelayed(new Runnable() {

                final HVArrangement this$0;
                final AndroidViewComponent val$component;
                final int val$fHeight;

                public void run()
                {
                    System.err.println("(HVArrangement)Height not stable yet... trying again");
                    setChildHeight(component, fHeight);
                }

            
            {
                this$0 = HVArrangement.this;
                component = androidviewcomponent;
                fHeight = i;
                super();
            }
            }, 100L);
        }
        int i = fHeight;
        if (fHeight <= -1000)
        {
            i = (-(fHeight + 1000) * j) / 100;
        }
        component.setLastHeight(i);
        if (orientation == 0)
        {
            ViewUtil.setChildHeightForHorizontalLayout(component.getView(), i);
            return;
        } else
        {
            ViewUtil.setChildHeightForVerticalLayout(component.getView(), i);
            return;
        }
    }

    public void setChildWidth(AndroidViewComponent androidviewcomponent, int i)
    {
        setChildWidth(androidviewcomponent, i, 0);
    }

    public void setChildWidth(final AndroidViewComponent component, final int fWidth, final int trycount)
    {
        int i = container.$form().Width();
        if (i == 0 && trycount < 2)
        {
            androidUIHandler.postDelayed(new Runnable() {

                final HVArrangement this$0;
                final AndroidViewComponent val$component;
                final int val$fWidth;
                final int val$trycount;

                public void run()
                {
                    System.err.println("(HVArrangement)Width not stable yet... trying again");
                    setChildWidth(component, fWidth, trycount + 1);
                }

            
            {
                this$0 = HVArrangement.this;
                component = androidviewcomponent;
                fWidth = i;
                trycount = j;
                super();
            }
            }, 100L);
        }
        trycount = fWidth;
        if (fWidth <= -1000)
        {
            System.err.println((new StringBuilder()).append("HVArrangement.setChildWidth(): width = ").append(fWidth).append(" parent Width = ").append(i).append(" child = ").append(component).toString());
            trycount = (-(fWidth + 1000) * i) / 100;
        }
        component.setLastWidth(trycount);
        if (orientation == 0)
        {
            ViewUtil.setChildWidthForHorizontalLayout(component.getView(), trycount);
            return;
        } else
        {
            ViewUtil.setChildWidthForVerticalLayout(component.getView(), trycount);
            return;
        }
    }
}
