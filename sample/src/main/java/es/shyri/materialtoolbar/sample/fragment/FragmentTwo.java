package es.shyri.materialtoolbar.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.fragment.MaterialToolbarInterface;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.toolbarcontent.ToolbarContentOne;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentTwo extends Fragment implements MaterialToolbarInterface {
    ToolbarContentOne toolbarContent;
    MaterialPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        presenter.setToolbarContent(getToolbarContent());
    }

    public MaterialToolbarContent getToolbarContent() {
        toolbarContent = new ToolbarContentOne(getActivity(), R.layout.toolbar_content_two, null);
        return toolbarContent;
    }

    @Override
    public void setPresenter(MaterialPresenter presenter) {
        this.presenter = presenter;
    }
}
