package es.shyri.materialtoolbar;

/**
 * Created by Shyri on 04/03/2015.
 */

public interface MaterialToolbarSupplier {
    /**
     * Gives the presenter using this materialtoolbarsupplier
     * @param presenter
     */
    public void setPresenter(MaterialPresenter presenter);
     /**
     * Returns
     * @return
     */
    public MaterialToolbarContent getToolbarContent();
    public MaterialPresenter getPresenter();
    public boolean onBackPressed();
}
