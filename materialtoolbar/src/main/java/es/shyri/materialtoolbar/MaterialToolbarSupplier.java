package es.shyri.materialtoolbar;

/**
 * Created by Shyri on 04/03/2015.
 * This interface is inteded to be implemented by a {@link android.app.Fragment} which wants to supply
 * specific view content for the {@link MaterialToolbar} when the are being showed to the user.
 */

public interface MaterialToolbarSupplier {
    /**
     * Tells the fragment what {@link MaterialPresenter} is taking care of showing it in the app
     * @param presenter
     */
    public void setPresenter(MaterialPresenter presenter);

    /**
     * The {@link android.app.Fragment} should prived a {@link MaterialToolbarContent} to be inserted
     * inside the Actionbar of the Activity
     * @return
     */
    public MaterialToolbarContent getToolbarContent();
}
