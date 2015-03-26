package es.shyri.materialtoolbar.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import es.shyri.materialtoolbar.MaterialToolbar;
import es.shyri.materialtoolbar.MaterialToolbarContent;

/**
 * Created by Shyri on 03/03/2015.
 */
public class MaterialToolbarActivity extends ActionBarActivity {
    MaterialToolbar mToolBar;
    int layoutContentId;

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

    protected void setLayoutContentId(int layoutContentId){
        this.layoutContentId = layoutContentId;
    }

    public void navigateTo(Fragment fragment){
        if(layoutContentId==0) throw new IllegalStateException("setLayoutContentId not called in activity onCreate");
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(layoutContentId, fragment); // f1_container is your FrameLayout container
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
