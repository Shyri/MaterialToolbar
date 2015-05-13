package es.shyri.materialtoolbar.fragment;

import android.app.Fragment;
import android.os.Bundle;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.MaterialToolbarContent;

/**
 * Created by Shyri on 04/03/2015.
 */

public interface MaterialToolbarSupplier {
    public void setPresenter(MaterialPresenter presenter);
    public boolean onBackPressed();
}
