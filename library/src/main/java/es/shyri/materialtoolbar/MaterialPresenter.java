package es.shyri.materialtoolbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * Created by Shyri on 23/09/2015.
 * Base class to use as a presenter actor in a MVP app. It provides an abstraction of the navigation
 * based in fragments to simplify the development with a simple hierarchical navigation
 * It holds a single instance of {@link AppCompatActivity}
 *
 */
public class MaterialPresenter {
    AppCompatActivity activity;
    MaterialToolbar toolbar;
    int fragmentContainerId;
    Fragment currentFragent;

    Stack<String> fragmentNames = new Stack<>();

    /**
     * Navigate to a given Fragment. This fragment will be added to the current backstack automatically
     * @param fragment
     */
    public void navigateTo(Fragment fragment) {
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        String fragmentTag = fragment.toString();
        ft.replace(fragmentContainerId, fragment, fragmentTag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentNames.push(fragmentTag);
        ft.addToBackStack(fragmentTag);
        currentFragent = fragment;
        ft.commit();
        ((MaterialToolbarSupplier) fragment).setPresenter(this);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(fragmentNames.size() > 1);
    }

    public MaterialToolbar getToolbar() {
        return toolbar;
    }

    public boolean onBackPressed(){
        FragmentManager fm = activity.getFragmentManager();
        if (fm.getBackStackEntryCount() > 0 && fragmentNames.size() > 1) {
            boolean handledByFragment = false;

            if(currentFragent instanceof MaterialToolbarSupplier){
                handledByFragment = ((MaterialToolbarSupplier) currentFragent).onBackPressed();
            }

            if(!handledByFragment){
                fm.popBackStack();
                fragmentNames.pop();
                currentFragent = fm.findFragmentByTag(fragmentNames.peek());
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(fragmentNames.size() > 1);
                if(currentFragent instanceof MaterialToolbarSupplier) toolbar.setContent(((MaterialToolbarSupplier) currentFragent).getToolbarContent());
            }

            return true;
        } else {
            return false;
        }
    }

    public Context getContext(){
        return activity;
    }

    public static class Builder {
        MaterialPresenter presenter = new MaterialPresenter();

        public Builder(){}

        public Builder withActivity(AppCompatActivity activity){
            presenter.activity = activity;
            return this;
        }

        public Builder withToolBar(int resource){
            presenter.toolbar = (MaterialToolbar) presenter.activity.findViewById(resource);
            return this;
        }

        public Builder withFragmentContainer(int resource){
            presenter.fragmentContainerId = resource;
            return this;
        }

        public MaterialPresenter build(){
            presenter.activity.setSupportActionBar(presenter.toolbar);
            return presenter;
        }
    }
}
