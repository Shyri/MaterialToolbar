package es.shyri.materialtoolbar.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.fragment.MaterialToolbarFragment;
import es.shyri.materialtoolbar.sample.MainActivity;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.toolbarcontent.ToolbarContentOne;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentOne extends MaterialToolbarFragment {
    ToolbarContentOne content;

    @Override
    public MaterialToolbarContent onCreateMaterialToolbarContent(Bundle savedInstanceState) {
        content = new ToolbarContentOne(getActivity(), R.layout.toolba_search_code, R.menu.menu_main);
        content.findViewById(R.id.buttonSearchByCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).navigateTo(new FragmentTwo());
            }
        });
        return content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        return view;
    }
}
