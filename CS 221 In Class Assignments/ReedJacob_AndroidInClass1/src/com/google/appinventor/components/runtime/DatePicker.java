// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.DatePickerDialog;
import android.os.Handler;
import com.google.appinventor.components.runtime.util.Dates;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ButtonBase, ComponentContainer, EventDispatcher, Form

public class DatePicker extends ButtonBase
{

    private Handler androidUIHandler;
    private boolean customDate;
    private DatePickerDialog date;
    private android.app.DatePickerDialog.OnDateSetListener datePickerListener;
    private int day;
    private Form form;
    private Calendar instant;
    private int javaMonth;
    private String localizedMonths[];
    private int month;
    private int year;

    public DatePicker(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        localizedMonths = (new DateFormatSymbols()).getMonths();
        customDate = false;
        datePickerListener = new android.app.DatePickerDialog.OnDateSetListener() {

            final DatePicker this$0;

            public void onDateSet(android.widget.DatePicker datepicker, int i, int j, int k)
            {
                if (datepicker.isShown())
                {
                    year = i;
                    javaMonth = j;
                    month = javaMonth + 1;
                    day = k;
                    date.updateDate(year, javaMonth, day);
                    instant = Dates.DateInstant(year, month, day);
                    androidUIHandler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            AfterDateSet();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = DatePicker.this;
                super();
            }
        };
        form = componentcontainer.$form();
        componentcontainer = Calendar.getInstance();
        year = componentcontainer.get(1);
        javaMonth = componentcontainer.get(2);
        month = javaMonth + 1;
        day = componentcontainer.get(5);
        instant = Dates.DateInstant(year, month, day);
        date = new DatePickerDialog(container.$context(), datePickerListener, year, javaMonth, day);
        androidUIHandler = new Handler();
    }

    public void AfterDateSet()
    {
        EventDispatcher.dispatchEvent(this, "AfterDateSet", new Object[0]);
    }

    public int Day()
    {
        return day;
    }

    public Calendar Instant()
    {
        return instant;
    }

    public void LaunchPicker()
    {
        click();
    }

    public int Month()
    {
        return month;
    }

    public String MonthInText()
    {
        return localizedMonths[javaMonth];
    }

    public void SetDateToDisplay(int i, int j, int k)
    {
        int l = j - 1;
        try
        {
            GregorianCalendar gregoriancalendar = new GregorianCalendar(i, l, k);
            gregoriancalendar.setLenient(false);
            gregoriancalendar.getTime();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "SetDateToDisplay", 2401, new Object[0]);
        }
        date.updateDate(i, l, k);
        instant = Dates.DateInstant(i, j, k);
        customDate = true;
    }

    public void SetDateToDisplayFromInstant(Calendar calendar)
    {
        int i = Dates.Year(calendar);
        int j = Dates.Month(calendar);
        int k = Dates.Day(calendar);
        date.updateDate(i, j, k);
        Dates.DateInstant(i, j, k);
        customDate = true;
    }

    public int Year()
    {
        return year;
    }

    public void click()
    {
        if (!customDate)
        {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int j = calendar.get(2);
            int k = calendar.get(5);
            date.updateDate(i, j, k);
            instant = Dates.DateInstant(i, j + 1, k);
        } else
        {
            customDate = false;
        }
        date.show();
    }



/*
    static int access$002(DatePicker datepicker, int i)
    {
        datepicker.year = i;
        return i;
    }

*/



/*
    static int access$102(DatePicker datepicker, int i)
    {
        datepicker.javaMonth = i;
        return i;
    }

*/



/*
    static int access$202(DatePicker datepicker, int i)
    {
        datepicker.month = i;
        return i;
    }

*/



/*
    static int access$302(DatePicker datepicker, int i)
    {
        datepicker.day = i;
        return i;
    }

*/



/*
    static Calendar access$502(DatePicker datepicker, Calendar calendar)
    {
        datepicker.instant = calendar;
        return calendar;
    }

*/

}
