// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Form, AndroidViewComponent

public static class dim
{
    public static final class Dim extends Enum
    {

        private static final Dim $VALUES[];
        public static final Dim HEIGHT;
        public static final Dim WIDTH;

        public static Dim valueOf(String s)
        {
            return (Dim)Enum.valueOf(com/google/appinventor/components/runtime/Form$PercentStorageRecord$Dim, s);
        }

        public static Dim[] values()
        {
            return (Dim[])$VALUES.clone();
        }

        static 
        {
            HEIGHT = new Dim("HEIGHT", 0);
            WIDTH = new Dim("WIDTH", 1);
            $VALUES = (new Dim[] {
                HEIGHT, WIDTH
            });
        }

        private Dim(String s, int i)
        {
            super(s, i);
        }
    }


    AndroidViewComponent component;
    Dim dim;
    int length;

    public Dim(AndroidViewComponent androidviewcomponent, int i, Dim dim1)
    {
        component = androidviewcomponent;
        length = i;
        dim = dim1;
    }
}
