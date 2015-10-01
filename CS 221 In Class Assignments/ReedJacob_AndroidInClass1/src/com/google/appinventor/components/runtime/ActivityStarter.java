// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, ActivityResultListener, Component, Deleteable, 
//            ComponentContainer, EventDispatcher, Form

public class ActivityStarter extends AndroidNonvisibleComponent
    implements ActivityResultListener, Component, Deleteable
{

    private String action;
    private String activityClass;
    private String activityPackage;
    private final ComponentContainer container;
    private String dataType;
    private String dataUri;
    private String extraKey;
    private String extraValue;
    private YailList extras;
    private int requestCode;
    private String result;
    private Intent resultIntent;
    private String resultName;

    public ActivityStarter(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        container = componentcontainer;
        result = "";
        Action("android.intent.action.MAIN");
        ActivityPackage("");
        ActivityClass("");
        DataUri("");
        DataType("");
        ExtraKey("");
        ExtraValue("");
        Extras(new YailList());
        ResultName("");
    }

    private Intent buildActivityIntent()
    {
        Intent intent;
        Object obj;
        int j;
        if (dataUri.length() != 0)
        {
            obj = Uri.parse(dataUri);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            intent = new Intent(action, ((Uri) (obj)));
        } else
        {
            intent = new Intent(action);
        }
        if (dataType.length() != 0)
        {
            if (obj != null)
            {
                intent.setDataAndType(((Uri) (obj)), dataType);
            } else
            {
                intent.setType(dataType);
            }
        }
        if (activityPackage.length() != 0 || activityClass.length() != 0)
        {
            intent.setComponent(new ComponentName(activityPackage, activityClass));
        }
        if (extraKey.length() != 0 && extraValue.length() != 0)
        {
            Log.i("ActivityStarter", (new StringBuilder()).append("Adding extra, key = ").append(extraKey).append(" value = ").append(extraValue).toString());
            intent.putExtra(extraKey, extraValue);
        }
        obj = ((Object) (extras.toArray()));
        j = obj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj1 = (YailList)obj[i];
            String s = ((YailList) (obj1)).getString(0);
            obj1 = ((YailList) (obj1)).getString(1);
            if (s.length() != 0 && ((String) (obj1)).length() != 0)
            {
                Log.i("ActivityStarter", (new StringBuilder()).append("Adding extra (pairs), key = ").append(s).append(" value = ").append(((String) (obj1))).toString());
                intent.putExtra(s, ((String) (obj1)));
            }
        }

        return intent;
    }

    public String Action()
    {
        return action;
    }

    public void Action(String s)
    {
        action = s.trim();
    }

    public void ActivityCanceled()
    {
        EventDispatcher.dispatchEvent(this, "ActivityCanceled", new Object[0]);
    }

    public String ActivityClass()
    {
        return activityClass;
    }

    public void ActivityClass(String s)
    {
        activityClass = s.trim();
    }

    public void ActivityError(String s)
    {
    }

    public String ActivityPackage()
    {
        return activityPackage;
    }

    public void ActivityPackage(String s)
    {
        activityPackage = s.trim();
    }

    public void AfterActivity(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterActivity", new Object[] {
            s
        });
    }

    public String DataType()
    {
        return dataType;
    }

    public void DataType(String s)
    {
        dataType = s.trim();
    }

    public String DataUri()
    {
        return dataUri;
    }

    public void DataUri(String s)
    {
        dataUri = s.trim();
    }

    public String ExtraKey()
    {
        return extraKey;
    }

    public void ExtraKey(String s)
    {
        extraKey = s.trim();
    }

    public String ExtraValue()
    {
        return extraValue;
    }

    public void ExtraValue(String s)
    {
        extraValue = s.trim();
    }

    public YailList Extras()
    {
        return extras;
    }

    public void Extras(YailList yaillist)
    {
        Object aobj[] = yaillist.toArray();
        int j = aobj.length;
        boolean flag;
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            boolean flag1 = obj instanceof YailList;
            if (flag1)
            {
                if (((YailList)obj).size() == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            if (!flag1 || !flag)
            {
                throw new YailRuntimeError("Argument to Extras should be a list of pairs", "ActivityStarter Error");
            }
        }

        extras = yaillist;
    }

    public String ResolveActivity()
    {
        Object obj = buildActivityIntent();
        obj = container.$context().getPackageManager().resolveActivity(((Intent) (obj)), 0);
        if (obj != null && ((ResolveInfo) (obj)).activityInfo != null)
        {
            return ((ResolveInfo) (obj)).activityInfo.name;
        } else
        {
            return "";
        }
    }

    public String Result()
    {
        return result;
    }

    public String ResultName()
    {
        return resultName;
    }

    public void ResultName(String s)
    {
        resultName = s.trim();
    }

    public String ResultType()
    {
        if (resultIntent != null)
        {
            String s = resultIntent.getType();
            if (s != null)
            {
                return s;
            }
        }
        return "";
    }

    public String ResultUri()
    {
        if (resultIntent != null)
        {
            String s = resultIntent.getDataString();
            if (s != null)
            {
                return s;
            }
        }
        return "";
    }

    public void StartActivity()
    {
        resultIntent = null;
        result = "";
        Object obj = buildActivityIntent();
        if (requestCode == 0)
        {
            requestCode = form.registerForActivityResult(this);
        }
        try
        {
            container.$context().startActivityForResult(((Intent) (obj)), requestCode);
            obj = container.$form().getOpenAnimType();
            AnimationUtil.ApplyOpenScreenAnimation(container.$context(), ((String) (obj)));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            form.dispatchErrorOccurredEvent(this, "StartActivity", 601, new Object[0]);
        }
    }

    public void onDelete()
    {
        form.unregisterForActivityResult(this);
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        if (i == requestCode)
        {
            Log.i("ActivityStarter", (new StringBuilder()).append("resultReturned - resultCode = ").append(j).toString());
            if (j == -1)
            {
                resultIntent = intent;
                if (resultName.length() != 0 && resultIntent != null && resultIntent.hasExtra(resultName))
                {
                    result = resultIntent.getStringExtra(resultName);
                } else
                {
                    result = "";
                }
                AfterActivity(result);
            } else
            if (j == 0)
            {
                ActivityCanceled();
                return;
            }
        }
    }
}
