// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn36 extends ModuleBody
{

    Object elt;
    final ModuleMethod lambda$Fn36;
     staticLink;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 34)
        {
            return lambda53(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda53(Object obj)
    {
        return staticLink.Eq.apply2(obj, elt);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 34)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 34, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1490");
        lambda$Fn36 = modulemethod;
    }
}
