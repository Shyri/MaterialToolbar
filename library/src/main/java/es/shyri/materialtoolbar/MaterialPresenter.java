package es.shyri.materialtoolbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Shyri on 23/09/2015.
 * Base class to use as a presenter actor in a MVP app. It provides an abstraction of the navigation
 * based in fragments to simplify the development with a simple hierarchical navigation
 * It holds a single instance of {@link AppCompatActivity}
 *
 */
public class MaterialPresenter implements FragmentManager.OnBackStackChangedListener {
    static MaterialPresenter instance;

    MaterialToolbar toolbar;
    int fragmentContainerId;
    Fragment currentFragent;

    FragmentManager fragmentManager;

    public void attachActivity(AppCompatActivity activity, int toolbarId, int fragmentContainerId){
        fragmentManager = activity.getFragmentManager();
        toolbar = (MaterialToolbar) activity.findViewById(toolbarId);
        activity.setSupportActionBar(toolbar);
        this.fragmentContainerId = fragmentContainerId;
        fragmentManager.addOnBackStackChangedListener(this);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(fragmentManager.getBackStackEntryCount() > 1);
    }

    public void detachActivity(){
        toolbar = null;
        fragmentManager.removeOnBackStackChangedListener(this);
    }

    public static MaterialPresenter getInstance() {
        if(instance == null) instance = new MaterialPresenter();
        return instance;
    }

    /**
     * Navigate to a given Fragment. This fragment will be added to the current backstack automatically
     * @param fragment
     */
    public void navigateTo(Fragment fragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        String fragmentTag = fragment.toString();
        ft.add(fragmentContainerId, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commit();

        currentFragent = fragment;
        ((MaterialToolbarSupplier) fragment).setPresenter(this);
    }

    public MaterialToolbar getToolbar() {
        return toolbar;
    }

    public boolean onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            boolean handledByFragment = false;

            if(currentFragent instanceof MaterialToolbarSupplier){
                handledByFragment = ((MaterialToolbarSupplier) currentFragent).onBackPressed();
            }

            if(!handledByFragment){
                fragmentManager.popBackStack();
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackStackChanged() {
        currentFragent = fragmentManager.findFragmentById(fragmentContainerId);
        if(currentFragent!=null){
            if(currentFragent instanceof MaterialToolbarSupplier) toolbar.setContent(((MaterialToolbarSupplier) currentFragent).getToolbarContent());
        }
    }
}
