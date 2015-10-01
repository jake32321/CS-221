// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.common.version;


public final class GitBuildId
{

    public static final String ACRA_URI = "https://acra2.appinventor.mit.edu/acra/";
    public static final String ANT_BUILD_DATE = "September 11 2015";
    public static final String GIT_BUILD_FINGERPRINT = "4ef230c8af4a304148d73d228fc98c0fe143fed0";
    public static final String GIT_BUILD_VERSION = "nb145i";

    private GitBuildId()
    {
    }

    public static String getAcraUri()
    {
        if ("https://acra2.appinventor.mit.edu/acra/".equals("${acra.uri}"))
        {
            return "";
        } else
        {
            return "https://acra2.appinventor.mit.edu/acra/".trim();
        }
    }

    public static String getDate()
    {
        return "September 11 2015";
    }

    public static String getFingerprint()
    {
        return "4ef230c8af4a304148d73d228fc98c0fe143fed0";
    }

    public static String getVersion()
    {
        String s = "nb145i";
        if ("nb145i" == "" || "nb145i".contains(" "))
        {
            s = "none";
        }
        return s;
    }
}
