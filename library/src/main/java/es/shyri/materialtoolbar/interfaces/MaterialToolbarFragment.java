package es.shyri.materialtoolbar.interfaces;

import android.content.Context;

import es.shyri.materialtoolbar.MaterialToolbarContent;

/**
 * Created by Shyri on 01/03/2015.
 */
public interface MaterialToolbarFragment extends MaterialToolbarMessageReceiver{
    public abstract MaterialToolbarContent getToolbarContent(Context paramContext);

}
