package es.shyri.materialtoolbar;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Shyri on 27/02/2015.
 */
public abstract class MaterialToolbarContent extends LinearLayout{
    Context mContext;
    View toolbarView;
    protected UIToolbarContentListener mUIToolbarContentListener;
    Integer mMenuId;

    public MaterialToolbarContent(Context context, int layoutId, Integer menuId) {
        super(context);
        this.mContext = context;
        LayoutInflater factory = LayoutInflater.from(this.mContext);
        this.toolbarView = factory.inflate(layoutId, this, true);
        this.toolbarView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mMenuId = menuId;
    }

    public View getView()
    {
        return this.toolbarView;
    }

    public void setSmartToolbarComponentListener(UIToolbarContentListener uiToolbarContentListener) {
        this.mUIToolbarContentListener = uiToolbarContentListener;
    }

    public void configureActionBar(ActionBarActivity paramActionBarActivity){
        restoreActionbar(paramActionBarActivity.getSupportActionBar());
    }

    public int getMenuId()
    {
        return this.mMenuId == null ? 0 : this.mMenuId.intValue();
    }

    public static abstract interface UIToolbarContentListener {
        public abstract void onToolbarComponentMessage(Object paramObject);
    }

    private void restoreActionbar(ActionBar actionBar){
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }
}
