package es.shyri.materialtoolbar.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.fragment.MaterialToolbarFragment;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.toolbarcontent.ToolbarContentOne;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentTwo extends MaterialToolbarFragment {
    ToolbarContentOne content;

    @Override
    public MaterialToolbarContent onCreateMaterialToolbarContent(Bundle savedInstance) {
        content = new ToolbarContentOne(getActivity(), R.layout.toolbar_content_two, R.menu.menu_main);
        return content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        return view;
    }
}
