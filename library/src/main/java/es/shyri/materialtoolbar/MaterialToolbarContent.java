package com.shyri.materialtoolbar;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Shyri on 27/02/2015.
 */
public abstract class MaterialToolbarContent
{
    Context mContext;
    LinearLayout toolbarView;
    protected UIToolbarContentListener mUIToolbarContentListener;
    Integer mMenuId;

    public MaterialToolbarContent(Context context, int layoutId, Integer menuId)
    {
        this.mContext = context;
        LayoutInflater factory = LayoutInflater.from(this.mContext);
        this.toolbarView = ((LinearLayout)factory.inflate(layoutId, null));
        this.toolbarView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mMenuId = menuId;
    }

    public View getView()
    {
        return this.toolbarView;
    }

    public void setSmartToolbarComponentListener(UIToolbarContentListener uiToolbarContentListener)
    {
        this.mUIToolbarContentListener = uiToolbarContentListener;
    }

    public abstract void configureActionBar(ActionBarActivity paramActionBarActivity);

    public int getMenuId()
    {
        return this.mMenuId == null ? 0 : this.mMenuId.intValue();
    }

    public static abstract interface UIToolbarContentListener
    {
        public abstract void onToolbarComponentMessage(Object paramObject);
    }
}
