package es.shyri.materialtoolbar.sample.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.activity.MaterialToolbarActivity;
import es.shyri.materialtoolbar.interfaces.MaterialToolbarFragment;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.toolbarcontent.ToolbarContentOne;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentOne extends Fragment implements MaterialToolbarFragment {

    @Override
    public MaterialToolbarContent getToolbarContent(Context paramContext) {
        return new ToolbarContentOne(getActivity(), R.layout.toolba_search_code, R.menu.menu_main);
    }

    @Override
    public void onReceiveToolbarMessage(Object paramObject) {

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ((MaterialToolbarActivity) getActivity()).setMaterialToolbarContent(getToolbarContent(getActivity()));
    }
}
