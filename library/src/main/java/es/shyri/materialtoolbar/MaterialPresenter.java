package es.shyri.materialtoolbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.Stack;

import es.shyri.materialtoolbar.fragment.MaterialToolbarSupplier;


/**
 * Created by Shyri on 27/04/2015.
 */
public class MaterialPresenter {
    ActionBarActivity activity;

    MaterialToolbar toolbar;

    int fragmentContainerId;

    Fragment currentFragent;

    private MaterialPresenter(){}

    Stack<String> fragmentNames = new Stack<>();

    public void navigateTo(Fragment fragment){
        navigateTo(fragment, true);
    }

    public void navigateTo(Fragment fragment, boolean addToBackStack){
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        String fragmentTag = fragment.toString();
        ft.replace(fragmentContainerId, fragment, fragmentTag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentNames.push(fragmentTag);
        if(addToBackStack){
            ft.addToBackStack(fragmentTag);
        }
        currentFragent = fragment;

        if(fragment instanceof MaterialToolbarSupplier) initInterface((MaterialToolbarSupplier) fragment);

        ft.commit();
    }


//    public void setToolbarContent(MaterialToolbarFragment toolbarFragment){
//        toolbar.setContent(toolbarFragment.getToolbarContent());
//    }

    public static class Presenter{
        MaterialPresenter presenter = new MaterialPresenter();

        public Presenter(){}

        public Presenter withActivity(ActionBarActivity activity){
            presenter.activity = activity;
            return this;
        }

        public Presenter withToolBar(int resource){
            presenter.toolbar = (MaterialToolbar) presenter.activity.findViewById(resource);
            return this;
        }

        public Presenter withFragmentContainer(int resource){
            presenter.fragmentContainerId = resource;
            return this;
        }

        public MaterialPresenter build(){
            presenter.activity.setSupportActionBar(presenter.toolbar);
            return presenter;
        }
    }

    public boolean onBackPressed(){
        FragmentManager fm = activity.getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            boolean handledByFragment = false;

            if(currentFragent instanceof MaterialToolbarSupplier){
                handledByFragment = ((MaterialToolbarSupplier) currentFragent).onBackPressed();
            }

            if(!handledByFragment){
                fm.popBackStack();
                fragmentNames.pop();
                currentFragent = fm.findFragmentByTag(fragmentNames.peek());
            }

            return true;
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            return false;
        }
    }

    public Fragment getCurrentFragment() {
        return currentFragent;
    }

    public void setToolbarContent(MaterialToolbarContent materialToolbarContent){
        toolbar.setContent(materialToolbarContent);
    }

    private void initInterface(MaterialToolbarSupplier toolbarInterface){
        toolbarInterface.setPresenter(this);
    }
}
