package es.shyri.materialtoolbar.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.MaterialToolbarSupplier;
import es.shyri.materialtoolbar.sample.R;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentCityDetail extends Fragment implements MaterialToolbarSupplier {
    MaterialPresenter presenter;
    MaterialToolbarContent toolbarContent;
    CollapsingToolbarLayout


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        toolbarContent = new MaterialToolbarContent(getActivity());
        toolbarContent.setToolbarBackground(R.drawable.new_york);
        presenter.getToolbar().setContent(toolbarContent);
        return view;
    }

    @Override
    public void setPresenter(MaterialPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_two, menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        switch (id) {
//            case android.R.id.home:
//                getActivity().onBackPressed();
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public MaterialToolbarContent getToolbarContent() {
        return null;
    }
}
