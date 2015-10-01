// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public final class Spinner extends AndroidViewComponent
    implements android.widget.AdapterView.OnItemSelectedListener
{

    private ArrayAdapter adapter;
    private YailList items;
    private int oldAdapterCount;
    private int oldSelectionIndex;
    private final android.widget.Spinner view;

    public Spinner(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        items = new YailList();
        view = new android.widget.Spinner(componentcontainer.$context());
        adapter = new ArrayAdapter(componentcontainer.$context(), 0x1090008);
        adapter.setDropDownViewResource(0x1090009);
        view.setAdapter(adapter);
        view.setOnItemSelectedListener(this);
        componentcontainer.$add(this);
        Prompt("");
        oldSelectionIndex = SelectionIndex();
    }

    private void setAdapterData(String as[])
    {
        oldAdapterCount = adapter.getCount();
        adapter.clear();
        for (int i = 0; i < as.length; i++)
        {
            adapter.add(as[i]);
        }

    }

    public void AfterSelecting(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterSelecting", new Object[] {
            s
        });
    }

    public void DisplayDropdown()
    {
        view.performClick();
    }

    public YailList Elements()
    {
        return items;
    }

    public void Elements(YailList yaillist)
    {
        if (yaillist.size() != 0) goto _L2; else goto _L1
_L1:
        SelectionIndex(0);
_L4:
        items = ElementsUtil.elements(yaillist, "Spinner");
        setAdapterData(yaillist.toStringArray());
        return;
_L2:
        if (yaillist.size() < items.size() && SelectionIndex() == items.size())
        {
            SelectionIndex(yaillist.size());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void ElementsFromString(String s)
    {
        Elements(ElementsUtil.elementsFromString(s));
    }

    public String Prompt()
    {
        return view.getPrompt().toString();
    }

    public void Prompt(String s)
    {
        view.setPrompt(s);
    }

    public String Selection()
    {
        if (SelectionIndex() == 0)
        {
            return "";
        } else
        {
            return (String)view.getItemAtPosition(SelectionIndex() - 1);
        }
    }

    public void Selection(String s)
    {
        SelectionIndex(ElementsUtil.setSelectedIndexFromValue(s, items));
    }

    public int SelectionIndex()
    {
        return ElementsUtil.selectionIndex(view.getSelectedItemPosition() + 1, items);
    }

    public void SelectionIndex(int i)
    {
        oldSelectionIndex = SelectionIndex();
        view.setSelection(ElementsUtil.selectionIndex(i, items) - 1);
    }

    public View getView()
    {
        return view;
    }

    public void onItemSelected(AdapterView adapterview, View view1, int i, long l)
    {
        if (oldAdapterCount == 0 && adapter.getCount() > 0 && oldSelectionIndex == 0 || oldAdapterCount > adapter.getCount() && oldSelectionIndex > adapter.getCount())
        {
            SelectionIndex(i + 1);
            oldAdapterCount = adapter.getCount();
            return;
        } else
        {
            SelectionIndex(i + 1);
            AfterSelecting(Selection());
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        view.setSelection(0);
    }
}
