package es.shyri.materialtoolbar.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.MaterialToolbarSupplier;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.adapter.CitiesAdapter;

/**
 * Created by Shyri on 01/03/2015.
 */
public class FragmentCityList extends Fragment implements MaterialToolbarSupplier {
    MaterialPresenter presenter;
    MaterialToolbarContent toolbarContent;

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        myRecyclerView = (RecyclerView) view.findViewById(R.id.myRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        myRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager  = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new CitiesAdapter(new ArrayList<>(Arrays.asList(new String[]{"hola", "ola"})), new CitiesAdapter.OnCityClickListener() {
            @Override
            public void onClick(View v, int position) {
                presenter.navigateTo(new FragmentCityDetail());
            }
        });

        myRecyclerView.setAdapter(mAdapter);
        initToolbar();

        return view;
    }

    @Override
    public void setPresenter(MaterialPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MaterialToolbarContent getToolbarContent() {
        return toolbarContent;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case android.R.id.home:
                getActivity().onBackPressed();
                break;

        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolbar(){
        toolbarContent = new MaterialToolbarContent(getActivity(), R.layout.toolbar_city_list);
        presenter.getToolbar().setContent(toolbarContent);

//        toolbarContent.findViewById(R.id.buttonSearchByCode).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                presenter.navigateTo(new FragmentCityDetail());
//            }
//        });
    }
}
