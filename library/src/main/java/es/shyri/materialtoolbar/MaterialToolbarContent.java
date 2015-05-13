package es.shyri.materialtoolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    Integer mMenuId;
    Drawable actionbarBackground;

    protected MaterialToolbarContent(Context context, int layoutId) {
        super(context);
        this.mContext = context;
        LayoutInflater factory = LayoutInflater.from(this.mContext);
        this.toolbarView = factory.inflate(layoutId, this, true);
        this.toolbarView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public View getView() {
        return this.toolbarView;
    }

    public void configureActionBar(ActionBarActivity paramActionBarActivity){
        restoreActionbar(paramActionBarActivity.getSupportActionBar());
    }

    public void setmMenuId(Integer mMenuId) {
        this.mMenuId = mMenuId;
    }

    public void setActionbarBackground(Drawable actionbarBackground) {
        this.actionbarBackground = actionbarBackground;
    }

    public Integer getMenuId() {
        return this.mMenuId;
    }

    public Drawable getActionbarBackground() {
        return actionbarBackground;
    }

    public void restoreActionbar(ActionBar actionBar){
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }
}
