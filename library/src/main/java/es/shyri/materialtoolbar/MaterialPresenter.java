package es.shyri.materialtoolbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Shyri on 23/09/2015.
 * The intention of this class is to play the role as a Presenter in a MVP pattern built application.
 *
 * Usage:
 * The use of this class is recommended for a single main {@link AppCompatActivity} based
 * application, in which navigation flows through different fragments hold by the same
 * {@link AppCompatActivity}. You should attach/detach your {@link AppCompatActivity} to the
 * {@link MaterialPresenter} and use the specified method to navigate through Fragments. {@link MaterialPresenter}
 * will handle the fragment backstack and back button events. Normal {@link Fragment} are compatible
 * with the presenter howver it's necessary to use {@link MaterialToolbar}
 * in order to have beautiful animations and custom toolbar view layout. To do that, just make your {@link Fragment}
 * implement the {@link MaterialToolbarSupplier} interface to provide the presenter the needed information.
 */
public class MaterialPresenter implements FragmentManager.OnBackStackChangedListener {
    /**
     * Singleton instance
     */
    static MaterialPresenter instance;

    /**
     * MaterialToolbar object in which insert views to.
     */
    MaterialToolbar toolbar;

    /**
     * Id of the view that will hold the fragments.
     */
    int fragmentContainerId;

    /**
     * Instance of the current fragment showing in the fragment container layout.
     */
    Fragment currentFragent;

    /**
     * Instance of the fragment manager holding the {@link Fragment} backstack
     */
    FragmentManager fragmentManager;

    /**
     *
     * @param activity to attach to the {@link MaterialPresenter}
     * @param toolbarId id of the {@link MaterialToolbar} hold by the {@param activity} layout.
     * @param fragmentContainerId id of the {@link android.view.View} that will hold the {@link Fragment} stack
     */
    public void attachActivity(AppCompatActivity activity, int toolbarId, int fragmentContainerId){
        fragmentManager = activity.getFragmentManager();                    // Get the FragmentManager instance
        toolbar = (MaterialToolbar) activity.findViewById(toolbarId);       // get the MaterialToolbar Instance
        activity.setSupportActionBar(toolbar);                              // assign MaterialToolbar to the activity
        activity.getSupportActionBar().setDisplayShowCustomEnabled(true);                             // assign MaterialToolbar to the activity
        this.fragmentContainerId = fragmentContainerId;
        fragmentManager.addOnBackStackChangedListener(this);                // We want to know of backstack change events
        // Show back arrow on the actionbar when the backstack has more than one fragment.
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(fragmentManager.getBackStackEntryCount() > 1);
    }

    /**
     * When activity wants to be detached fro the Presenter we free the toolbar instance and
     * Remove {@link MaterialPresenter} from the backstack change events listener.
     */
    public void detachActivity(){
        toolbar = null;
        fragmentManager.removeOnBackStackChangedListener(this);
    }

    /**
     *
     * @return the singleton instance of {@link MaterialPresenter}
     */
    public static MaterialPresenter getInstance() {
        if(instance == null) instance = new MaterialPresenter();
        return instance;
    }

    /**
     * Navigate to a given Fragment. This fragment will be added to the current backstack automatically
     *
     * @param fragment to navitage to.
     */
    public void navigateTo(Fragment fragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        String fragmentTag = fragment.toString();
        ft.add(fragmentContainerId, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commit();

        currentFragent = fragment;
        if(fragment instanceof  MaterialToolbarSupplier) ((MaterialToolbarSupplier) fragment).setPresenter(this);
    }

    /**
     *
     * @return the {@link MaterialToolbar}
     */
    public MaterialToolbar getToolbar() {
        return toolbar;
    }

    /**
     * Will handle back button press events.
     * The recommended use is to override your {@link AppCompatActivity#onBackPressed()} method
     * in order to check if {@link MaterialPresenter} handles this even before. If not, this method
     * will return false and {@link AppCompatActivity} will do what it wants to.
     * @return true if its more than one {@link Fragment} on the backstack, false otherwise.
     */
    public boolean onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            boolean handledByFragment = false;

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
            else toolbar.setContent(null);
        }
    }
}
