package es.shyri.materialtoolbar.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.fragment.MaterialToolbarSupplier;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.toolbarcontent.ToolbarContentOne;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentOne extends Fragment implements MaterialToolbarSupplier {
    ToolbarContentOne toolbarContent;
    MaterialPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        presenter.setToolbarContent(getToolbarContent());
    }

    @Override
    public void setPresenter(MaterialPresenter presenter) {
        this.presenter = presenter;
    }

    public MaterialToolbarContent getToolbarContent() {
        if(toolbarContent == null) toolbarContent = new ToolbarContentOne(getActivity(), R.layout.toolba_search_code, R.menu.menu_main);
        toolbarContent.findViewById(R.id.buttonSearchByCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateTo(new FragmentTwo());
            }
        });
        return toolbarContent;
    }
}
