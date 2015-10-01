// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package appinventor.ai_deadman3332.ReedJacob_AndroidInClass1;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

public class Screen1 extends Form
    implements Runnable
{

    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("Screen1")).readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("getMessage")).readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol)(new SimpleSymbol("FontSize")).readResolve();
    static final DFloNum Lit11 = DFloNum.make(20);
    static final SimpleSymbol Lit12 = (SimpleSymbol)(new SimpleSymbol("number")).readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol)(new SimpleSymbol("Width")).readResolve();
    static final IntNum Lit14 = IntNum.make(-2);
    static final SimpleSymbol Lit15 = (SimpleSymbol)(new SimpleSymbol("Text")).readResolve();
    static final FString Lit16 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit17 = (SimpleSymbol)(new SimpleSymbol("SIU_Image")).readResolve();
    static final SimpleSymbol Lit18 = (SimpleSymbol)(new SimpleSymbol("Visible")).readResolve();
    static final SimpleSymbol Lit19 = (SimpleSymbol)(new SimpleSymbol("Show_Button$Click")).readResolve();
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("*the-null-value*")).readResolve();
    static final SimpleSymbol Lit20 = (SimpleSymbol)(new SimpleSymbol("Click")).readResolve();
    static final FString Lit21 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit22 = (SimpleSymbol)(new SimpleSymbol("Height")).readResolve();
    static final SimpleSymbol Lit23 = (SimpleSymbol)(new SimpleSymbol("Picture")).readResolve();
    static final SimpleSymbol Lit24 = (SimpleSymbol)(new SimpleSymbol("ScalePictureToFit")).readResolve();
    static final FString Lit25 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit26 = (SimpleSymbol)(new SimpleSymbol("android-log-form")).readResolve();
    static final SimpleSymbol Lit27 = (SimpleSymbol)(new SimpleSymbol("add-to-form-environment")).readResolve();
    static final SimpleSymbol Lit28 = (SimpleSymbol)(new SimpleSymbol("lookup-in-form-environment")).readResolve();
    static final SimpleSymbol Lit29 = (SimpleSymbol)(new SimpleSymbol("is-bound-in-form-environment")).readResolve();
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("AppName")).readResolve();
    static final SimpleSymbol Lit30 = (SimpleSymbol)(new SimpleSymbol("add-to-global-var-environment")).readResolve();
    static final SimpleSymbol Lit31 = (SimpleSymbol)(new SimpleSymbol("add-to-events")).readResolve();
    static final SimpleSymbol Lit32 = (SimpleSymbol)(new SimpleSymbol("add-to-components")).readResolve();
    static final SimpleSymbol Lit33 = (SimpleSymbol)(new SimpleSymbol("add-to-global-vars")).readResolve();
    static final SimpleSymbol Lit34 = (SimpleSymbol)(new SimpleSymbol("add-to-form-do-after-creation")).readResolve();
    static final SimpleSymbol Lit35 = (SimpleSymbol)(new SimpleSymbol("send-error")).readResolve();
    static final SimpleSymbol Lit36 = (SimpleSymbol)(new SimpleSymbol("dispatchEvent")).readResolve();
    static final SimpleSymbol Lit37 = (SimpleSymbol)(new SimpleSymbol("lookup-handler")).readResolve();
    static final SimpleSymbol Lit4 = (SimpleSymbol)(new SimpleSymbol("text")).readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol)(new SimpleSymbol("Title")).readResolve();
    static final FString Lit6 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit7 = (SimpleSymbol)(new SimpleSymbol("Show_Button")).readResolve();
    static final SimpleSymbol Lit8 = (SimpleSymbol)(new SimpleSymbol("FontBold")).readResolve();
    static final SimpleSymbol Lit9 = (SimpleSymbol)(new SimpleSymbol("boolean")).readResolve();
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn6;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public Image SIU_Image;
    public Button Show_Button;
    public final ModuleMethod Show_Button$Click;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;

    public Screen1()
    {
        ModuleInfo.register(this);
        frame frame1 = new frame();
        frame1.main = this;
        android$Mnlog$Mnform = new ModuleMethod(frame1, 1, Lit26, 4097);
        add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame1, 2, Lit27, 8194);
        lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame1, 3, Lit28, 8193);
        is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame1, 5, Lit29, 4097);
        add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame1, 6, Lit30, 8194);
        add$Mnto$Mnevents = new ModuleMethod(frame1, 7, Lit31, 8194);
        add$Mnto$Mncomponents = new ModuleMethod(frame1, 8, Lit32, 16388);
        add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame1, 9, Lit33, 8194);
        add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame1, 10, Lit34, 4097);
        send$Mnerror = new ModuleMethod(frame1, 11, Lit35, 4097);
        process$Mnexception = new ModuleMethod(frame1, 12, "process-exception", 4097);
        dispatchEvent = new ModuleMethod(frame1, 13, Lit36, 16388);
        lookup$Mnhandler = new ModuleMethod(frame1, 14, Lit37, 8194);
        ModuleMethod modulemethod = new ModuleMethod(frame1, 15, null, 0);
        modulemethod.setProperty("source-location", "/tmp/runtime5978226587714037759.scm:542");
        lambda$Fn1 = modulemethod;
        $define = new ModuleMethod(frame1, 16, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame1, 17, null, 0);
        lambda$Fn3 = new ModuleMethod(frame1, 18, null, 0);
        lambda$Fn4 = new ModuleMethod(frame1, 19, null, 0);
        Show_Button$Click = new ModuleMethod(frame1, 20, Lit19, 0);
        lambda$Fn5 = new ModuleMethod(frame1, 21, null, 0);
        lambda$Fn6 = new ModuleMethod(frame1, 22, null, 0);
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object aobj[])
    {
        Object obj = LList.makeList(aobj, 0);
        gnu.kawa.functions.Apply apply = Scheme.apply;
        ModuleMethod modulemethod = strings.string$Mnappend;
        aobj = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                aobj = ((Object []) (apply.apply2(modulemethod, LList.reverseInPlace(((Object) (aobj))))));
                Object obj1;
                Symbol symbol;
                try
                {
                    obj = (CharSequence)aobj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string->symbol", 1, ((Object) (aobj)));
                }
                return misc.string$To$Symbol(((CharSequence) (obj)));
            }
            try
            {
                obj1 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "arg0", -2, obj);
            }
            obj = ((Pair) (obj1)).getCdr();
            obj1 = ((Pair) (obj1)).getCar();
            try
            {
                symbol = (Symbol)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "symbol->string", 1, obj1);
            }
            aobj = Pair.make(misc.symbol$To$String(symbol), ((Object) (aobj)));
        } while (true);
    }

    static Object lambda2()
    {
        return null;
    }

    static Object lambda3()
    {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "ReedJacob_AndroidInClass1", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit5, "Screen1", Lit4);
    }

    static Object lambda4()
    {
        runtime.setAndCoerceProperty$Ex(Lit7, Lit8, Boolean.TRUE, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit7, Lit10, Lit11, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit7, Lit13, Lit14, Lit12);
        return runtime.setAndCoerceProperty$Ex(Lit7, Lit15, "Show / Hide", Lit4);
    }

    static Object lambda5()
    {
        runtime.setAndCoerceProperty$Ex(Lit7, Lit8, Boolean.TRUE, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit7, Lit10, Lit11, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit7, Lit13, Lit14, Lit12);
        return runtime.setAndCoerceProperty$Ex(Lit7, Lit15, "Show / Hide", Lit4);
    }

    static Object lambda6()
    {
        runtime.setAndCoerceProperty$Ex(Lit17, Lit22, Lit14, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit17, Lit13, Lit14, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit17, Lit23, "siu-logo.png", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit17, Lit24, Boolean.TRUE, Lit9);
    }

    static Object lambda7()
    {
        runtime.setAndCoerceProperty$Ex(Lit17, Lit22, Lit14, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit17, Lit13, Lit14, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit17, Lit23, "siu-logo.png", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit17, Lit24, Boolean.TRUE, Lit9);
    }

    public void $define()
    {
        Object obj;
        Object obj1;
        Language.setDefaults(Scheme.getInstance());
        try
        {
            run();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            androidLogForm(((Exception) (obj)).getMessage());
            processException(obj);
        }
        Screen1 = this;
        addToFormEnvironment(Lit0, this);
        obj = events$Mnto$Mnregister;
_L12:
        if (obj != LList.Empty) goto _L2; else goto _L1
_L1:
        addToGlobalVars(Lit2, lambda$Fn1);
        obj = lists.reverse(global$Mnvars$Mnto$Mncreate);
_L13:
        if (obj != LList.Empty) goto _L4; else goto _L3
_L3:
        obj = lists.reverse(form$Mndo$Mnafter$Mncreation);
_L14:
        if (obj != LList.Empty) goto _L6; else goto _L5
_L5:
        obj = lists.reverse(components$Mnto$Mncreate);
        obj1 = obj;
_L15:
        if (obj1 != LList.Empty) goto _L8; else goto _L7
_L7:
        obj1 = obj;
_L16:
        if (obj1 != LList.Empty) goto _L10; else goto _L9
_L9:
        obj1 = LList.Empty;
        if (obj == obj1)
        {
            return;
        }
          goto _L11
_L2:
        ClassCastException classcastexception;
        Object obj2;
        Object obj3;
        Object obj4;
        Symbol symbol;
        try
        {
            obj2 = (Pair)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "arg0", -2, obj);
        }
        obj1 = ((Pair) (obj2)).getCar();
        obj = lists.car.apply1(obj1);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        obj1 = lists.cdr.apply1(obj1);
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj1.toString();
        }
        EventDispatcher.registerEventForDelegation(this, ((String) (obj)), ((String) (obj1)));
        obj = ((Pair) (obj2)).getCdr();
          goto _L12
_L4:
        try
        {
            obj1 = (Pair)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            try
            {
                throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                processException(obj);
            }
            return;
        }
        obj2 = ((Pair) (obj1)).getCar();
        obj = lists.car.apply1(obj2);
        obj2 = lists.cadr.apply1(obj2);
        obj3 = (Symbol)obj;
        addToGlobalVarEnvironment(((Symbol) (obj3)), Scheme.applyToArgs.apply1(obj2));
        obj = ((Pair) (obj1)).getCdr();
          goto _L13
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "add-to-global-var-environment", 0, obj);
_L6:
        obj1 = (Pair)obj;
        misc.force(((Pair) (obj1)).getCar());
        obj = ((Pair) (obj1)).getCdr();
          goto _L14
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
_L8:
        obj2 = (Pair)obj1;
        obj4 = ((Pair) (obj2)).getCar();
        obj1 = lists.caddr.apply1(obj4);
        lists.cadddr.apply1(obj4);
        obj3 = lists.cadr.apply1(obj4);
        obj4 = lists.car.apply1(obj4);
        symbol = (Symbol)obj4;
        obj4 = lookupInFormEnvironment(symbol);
        obj3 = Invoke.make.apply2(obj3, obj4);
        SlotSet.set$Mnfield$Ex.apply3(this, obj1, obj3);
        obj4 = (Symbol)obj1;
        addToFormEnvironment(((Symbol) (obj4)), obj3);
        obj1 = ((Pair) (obj2)).getCdr();
          goto _L15
        obj;
        throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj1);
        obj;
        throw new WrongType(((ClassCastException) (obj)), "lookup-in-form-environment", 0, obj4);
        obj;
        throw new WrongType(((ClassCastException) (obj)), "add-to-form-environment", 0, obj1);
_L10:
        obj2 = (Pair)obj1;
        obj1 = ((Pair) (obj2)).getCar();
        lists.caddr.apply1(obj1);
        obj1 = lists.cadddr.apply1(obj1);
        if (obj1 != Boolean.FALSE)
        {
            Scheme.applyToArgs.apply1(obj1);
        }
        obj1 = ((Pair) (obj2)).getCdr();
          goto _L16
        obj;
        throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj1);
_L11:
        obj1 = (Pair)obj;
        obj = ((Pair) (obj1)).getCar();
        obj2 = lists.caddr.apply1(obj);
        lists.cadddr.apply1(obj);
        callInitialize(SlotGet.field.apply2(this, obj2));
        obj = ((Pair) (obj1)).getCdr();
          goto _L9
        classcastexception;
        throw new WrongType(classcastexception, "arg0", -2, obj);
          goto _L12
    }

    public Object Show_Button$Click()
    {
        runtime.setThisForm();
        if (runtime.getProperty$1(Lit17, Lit18) != Boolean.FALSE)
        {
            return runtime.setAndCoerceProperty$Ex(Lit17, Lit18, Boolean.FALSE, Lit9);
        } else
        {
            return runtime.setAndCoerceProperty$Ex(Lit17, Lit18, Boolean.TRUE, Lit9);
        }
    }

    public void addToComponents(Object obj, Object obj1, Object obj2, Object obj3)
    {
        components$Mnto$Mncreate = lists.cons(LList.list4(obj, obj1, obj2, obj3), components$Mnto$Mncreate);
    }

    public void addToEvents(Object obj, Object obj1)
    {
        events$Mnto$Mnregister = lists.cons(lists.cons(obj, obj1), events$Mnto$Mnregister);
    }

    public void addToFormDoAfterCreation(Object obj)
    {
        form$Mndo$Mnafter$Mncreation = lists.cons(obj, form$Mndo$Mnafter$Mncreation);
    }

    public void addToFormEnvironment(Symbol symbol, Object obj)
    {
        androidLogForm(Format.formatToString(0, new Object[] {
            "Adding ~A to env ~A with value ~A", symbol, form$Mnenvironment, obj
        }));
        form$Mnenvironment.put(symbol, obj);
    }

    public void addToGlobalVarEnvironment(Symbol symbol, Object obj)
    {
        androidLogForm(Format.formatToString(0, new Object[] {
            "Adding ~A to env ~A with value ~A", symbol, global$Mnvar$Mnenvironment, obj
        }));
        global$Mnvar$Mnenvironment.put(symbol, obj);
    }

    public void addToGlobalVars(Object obj, Object obj1)
    {
        global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(obj, obj1), global$Mnvars$Mnto$Mncreate);
    }

    public void androidLogForm(Object obj)
    {
    }

    public boolean dispatchEvent(Component component, String s, String s1, Object aobj[])
    {
        boolean flag = false;
        SimpleSymbol simplesymbol = misc.string$To$Symbol(s);
        if (isBoundInFormEnvironment(simplesymbol))
        {
            if (lookupInFormEnvironment(simplesymbol) == component)
            {
                component = ((Component) (lookupHandler(s, s1)));
                try
                {
                    Scheme.apply.apply2(component, LList.makeList(aobj, 0));
                }
                // Misplaced declaration of an exception variable
                catch (Component component)
                {
                    androidLogForm(component.getMessage());
                    component.printStackTrace();
                    processException(component);
                    return false;
                }
                flag = true;
            }
            return flag;
        } else
        {
            EventDispatcher.unregisterEventForDelegation(this, s, s1);
            return false;
        }
    }

    public boolean isBoundInFormEnvironment(Symbol symbol)
    {
        return form$Mnenvironment.isBound(symbol);
    }

    public Object lookupHandler(Object obj, Object obj1)
    {
        Object obj2 = null;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        if (obj1 == null)
        {
            obj1 = obj2;
        } else
        {
            obj1 = obj1.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(((String) (obj)), ((String) (obj1)))));
    }

    public Object lookupInFormEnvironment(Symbol symbol)
    {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public Object lookupInFormEnvironment(Symbol symbol, Object obj)
    {
        int i;
        if (form$Mnenvironment == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i = i + 1 & 1;
        if (i == 0 ? i != 0 : form$Mnenvironment.isBound(symbol))
        {
            obj = form$Mnenvironment.get(symbol);
        }
        return obj;
    }

    public void processException(Object obj)
    {
        Object obj1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(obj, Lit1));
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj1.toString();
        }
        if (obj instanceof YailRuntimeError)
        {
            obj = ((YailRuntimeError)obj).getErrorType();
        } else
        {
            obj = "Runtime Error";
        }
        RuntimeErrorAlert.alert(this, ((String) (obj1)), ((String) (obj)), "End Application");
    }

    public void run()
    {
        CallContext callcontext;
        gnu.lists.Consumer consumer;
        callcontext = CallContext.getInstance();
        consumer = callcontext.consumer;
        callcontext.consumer = VoidConsumer.instance;
        run(callcontext);
        Throwable throwable = null;
_L2:
        ModuleBody.runCleanup(callcontext, throwable, consumer);
        return;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void run(CallContext callcontext)
    {
        gnu.lists.Consumer consumer = callcontext.consumer;
        callcontext = ((CallContext) (require.find("com.google.youngandroid.runtime")));
        Runnable runnable;
        try
        {
            runnable = (Runnable)callcontext;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "java.lang.Runnable.run()", 1, callcontext);
        }
        runnable.run();
        $Stdebug$Mnform$St = Boolean.FALSE;
        form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
        callcontext = strings.stringAppend(new Object[] {
            misc.symbol$To$String(Lit0), "-global-vars"
        });
        if (callcontext == null)
        {
            callcontext = null;
        } else
        {
            callcontext = callcontext.toString();
        }
        global$Mnvar$Mnenvironment = Environment.make(callcontext);
        Screen1 = null;
        form$Mnname$Mnsymbol = Lit0;
        events$Mnto$Mnregister = LList.Empty;
        components$Mnto$Mncreate = LList.Empty;
        global$Mnvars$Mnto$Mncreate = LList.Empty;
        form$Mndo$Mnafter$Mncreation = LList.Empty;
        callcontext = ((CallContext) (require.find("com.google.youngandroid.runtime")));
        try
        {
            runnable = (Runnable)callcontext;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "java.lang.Runnable.run()", 1, callcontext);
        }
        runnable.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "ReedJacob_AndroidInClass1", Lit4);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit5, "Screen1", Lit4), consumer);
        } else
        {
            addToFormDoAfterCreation(new Promise(lambda$Fn2));
        }
        Show_Button = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit6, Lit7, lambda$Fn3), consumer);
        } else
        {
            addToComponents(Lit0, Lit16, Lit7, lambda$Fn4);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit19, Show_Button$Click);
        } else
        {
            addToFormEnvironment(Lit19, Show_Button$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Show_Button", "Click");
        } else
        {
            addToEvents(Lit7, Lit20);
        }
        SIU_Image = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit21, Lit17, lambda$Fn5), consumer);
        } else
        {
            addToComponents(Lit0, Lit25, Lit17, lambda$Fn6);
        }
        runtime.initRuntime();
    }

    public void sendError(Object obj)
    {
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        RetValManager.sendError(((String) (obj)));
    }


    private class frame extends ModuleBody
    {

        Screen1 $main;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply0(modulemethod);

            case 15: // '\017'
                return Screen1.lambda2();

            case 16: // '\020'
                $main.$define();
                return Values.empty;

            case 17: // '\021'
                return Screen1.lambda3();

            case 18: // '\022'
                return Screen1.lambda4();

            case 19: // '\023'
                return Screen1.lambda5();

            case 20: // '\024'
                return $main.Show_Button$Click();

            case 21: // '\025'
                return Screen1.lambda6();

            case 22: // '\026'
                return Screen1.lambda7();
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            case 2: // '\002'
            case 4: // '\004'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            default:
                return super.apply1(modulemethod, obj);

            case 1: // '\001'
                $main.androidLogForm(obj);
                return Values.empty;

            case 3: // '\003'
                modulemethod = $main;
                Symbol symbol;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
                }
                return modulemethod.lookupInFormEnvironment(symbol);

            case 5: // '\005'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "is-bound-in-form-environment", 1, obj);
                }
                if (modulemethod.isBoundInFormEnvironment(symbol))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }

            case 10: // '\n'
                $main.addToFormDoAfterCreation(obj);
                return Values.empty;

            case 11: // '\013'
                $main.sendError(obj);
                return Values.empty;

            case 12: // '\f'
                $main.processException(obj);
                return Values.empty;
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 5: // '\005'
            case 8: // '\b'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            default:
                return super.apply2(modulemethod, obj, obj1);

            case 2: // '\002'
                modulemethod = $main;
                Symbol symbol;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "add-to-form-environment", 1, obj);
                }
                modulemethod.addToFormEnvironment(symbol, obj1);
                return Values.empty;

            case 3: // '\003'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
                }
                return modulemethod.lookupInFormEnvironment(symbol, obj1);

            case 6: // '\006'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "add-to-global-var-environment", 1, obj);
                }
                modulemethod.addToGlobalVarEnvironment(symbol, obj1);
                return Values.empty;

            case 7: // '\007'
                $main.addToEvents(obj, obj1);
                return Values.empty;

            case 9: // '\t'
                $main.addToGlobalVars(obj, obj1);
                return Values.empty;

            case 14: // '\016'
                return $main.lookupHandler(obj, obj1);
            }
        }

        public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply4(modulemethod, obj, obj1, obj2, obj3);

            case 8: // '\b'
                $main.addToComponents(obj, obj1, obj2, obj3);
                return Values.empty;

            case 13: // '\r'
                modulemethod = $main;
                break;
            }
            Component component;
            try
            {
                component = (Component)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "dispatchEvent", 1, obj);
            }
            try
            {
                obj = (String)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "dispatchEvent", 2, obj1);
            }
            try
            {
                obj1 = (String)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "dispatchEvent", 3, obj2);
            }
            try
            {
                obj2 = ((Object) ((Object[])obj3));
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "dispatchEvent", 4, obj3);
            }
            if (modulemethod.dispatchEvent(component, ((String) (obj)), ((String) (obj1)), ((Object []) (obj2))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match0(modulemethod, callcontext);

            case 22: // '\026'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 21: // '\025'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 20: // '\024'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 19: // '\023'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 18: // '\022'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 17: // '\021'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 16: // '\020'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 15: // '\017'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            int i = 0xfff40001;
            modulemethod.selector;
            JVM INSTR tableswitch 1 12: default 72
        //                       1 190
        //                       2 72
        //                       3 166
        //                       4 72
        //                       5 142
        //                       6 72
        //                       7 72
        //                       8 72
        //                       9 72
        //                       10 125
        //                       11 108
        //                       12 84;
               goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L1 _L1 _L1 _L5 _L6 _L7
_L1:
            i = super.match1(modulemethod, obj, callcontext);
_L9:
            return i;
_L7:
            if (!(obj instanceof Screen1)) goto _L9; else goto _L8
_L8:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L6:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L5:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L4:
            if (!(obj instanceof Symbol)) goto _L9; else goto _L10
_L10:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L3:
            if (!(obj instanceof Symbol)) goto _L9; else goto _L11
_L11:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L2:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 5: // '\005'
            case 8: // '\b'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            default:
                return super.match2(modulemethod, obj, obj1, callcontext);

            case 14: // '\016'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 9: // '\t'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 7: // '\007'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 6: // '\006'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.value2 = obj1;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 2;
                    return 0;
                }

            case 3: // '\003'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.value2 = obj1;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 2;
                    return 0;
                }

            case 2: // '\002'
                break;
            }
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }

        public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

            case 13: // '\r'
                if (!(obj instanceof Screen1))
                {
                    return 0xfff40001;
                }
                callcontext.value1 = obj;
                if (!(obj1 instanceof Component))
                {
                    return 0xfff40002;
                }
                callcontext.value2 = obj1;
                if (!(obj2 instanceof String))
                {
                    return 0xfff40003;
                }
                callcontext.value3 = obj2;
                if (!(obj3 instanceof String))
                {
                    return 0xfff40004;
                } else
                {
                    callcontext.value4 = obj3;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 4;
                    return 0;
                }

            case 8: // '\b'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            }
        }

        public frame()
        {
        }
    }

}
