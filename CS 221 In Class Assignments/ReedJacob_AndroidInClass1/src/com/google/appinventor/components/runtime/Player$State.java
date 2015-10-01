// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Player

public static final class  extends Enum
{

    private static final PAUSED_BY_EVENT $VALUES[];
    public static final PAUSED_BY_EVENT INITIAL;
    public static final PAUSED_BY_EVENT PAUSED_BY_EVENT;
    public static final PAUSED_BY_EVENT PAUSED_BY_USER;
    public static final PAUSED_BY_EVENT PLAYING;
    public static final PAUSED_BY_EVENT PREPARED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/appinventor/components/runtime/Player$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INITIAL = new <init>("INITIAL", 0);
        PREPARED = new <init>("PREPARED", 1);
        PLAYING = new <init>("PLAYING", 2);
        PAUSED_BY_USER = new <init>("PAUSED_BY_USER", 3);
        PAUSED_BY_EVENT = new <init>("PAUSED_BY_EVENT", 4);
        $VALUES = (new .VALUES[] {
            INITIAL, PREPARED, PLAYING, PAUSED_BY_USER, PAUSED_BY_EVENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
