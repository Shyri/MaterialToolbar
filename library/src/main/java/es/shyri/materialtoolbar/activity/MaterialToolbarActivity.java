package es.shyri.materialtoolbar.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import es.shyri.materialtoolbar.MaterialToolbar;
import es.shyri.materialtoolbar.MaterialToolbarContent;

/**
 * Created by Shyri on 03/03/2015.
 */
public class MaterialToolbarActivity extends ActionBarActivity {
    MaterialToolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void setMaterialToolbar(MaterialToolbar toolbar) {
        mToolBar = toolbar;
        setSupportActionBar(mToolBar);
    }

    public void setMaterialToolbarContent(MaterialToolbarContent content){
        mToolBar.setContent(content);
    }

    public void onMaterialToolbarAction(Object object){

    }
}
