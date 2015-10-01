// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Form

public static final class  extends Enum
{

    private static final WIDTH $VALUES[];
    public static final WIDTH HEIGHT;
    public static final WIDTH WIDTH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/appinventor/components/runtime/Form$PercentStorageRecord$Dim, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HEIGHT = new <init>("HEIGHT", 0);
        WIDTH = new <init>("WIDTH", 1);
        $VALUES = (new .VALUES[] {
            HEIGHT, WIDTH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
