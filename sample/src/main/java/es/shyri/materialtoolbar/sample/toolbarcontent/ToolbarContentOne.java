package es.shyri.materialtoolbar.sample.toolbarcontent;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;

import es.shyri.materialtoolbar.MaterialToolbarContent;

/**
 * Created by Shyri on 03/03/2015.
 */
public class ToolbarContentOne extends MaterialToolbarContent {

    public ToolbarContentOne(Context context, int layoutId, Integer menuId) {
        super(context, layoutId, menuId);
    }

    @Override

    public void configureActionBar(ActionBarActivity paramActionBarActivity) {

    }
}
