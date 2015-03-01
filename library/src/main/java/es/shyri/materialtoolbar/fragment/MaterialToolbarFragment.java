package com.shyri.materialtoolbar.fragment;

import android.app.Fragment;
import android.content.Context;

import com.shyri.materialtoolbar.MaterialToolbarContent;
import com.shyri.materialtoolbar.interfaces.MaterialToolbarMessageReceiver;

/**
 * Created by Shyri on 27/02/2015.
 */
public abstract class MaterialToolbarFragment extends Fragment implements MaterialToolbarMessageReceiver {
    protected MaterialToolbarContent content;

    public abstract MaterialToolbarContent getToolbarContent(Context paramContext);
}
