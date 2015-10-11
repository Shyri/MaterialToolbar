package es.shyri.materialtoolbar.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.MaterialToolbarSupplier;
import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.model.CelestialBody;

/**
 * Created by Shyri on 01/03/2015.
 */
public class CelestialBodyDetailFragment extends Fragment implements MaterialToolbarSupplier{
    MaterialPresenter presenter;
    MaterialToolbarContent toolbarContent;

    TextView celestialBodyDescrtiption;
    CelestialBody celestialBody;

    public static CelestialBodyDetailFragment newInstance(CelestialBody celestialBody) {
        CelestialBodyDetailFragment f = new CelestialBodyDetailFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putParcelable("celestialBody", celestialBody);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        celestialBodyDescrtiption = (TextView) view.findViewById(R.id.celestialBodyDescrtiption);
        Bundle args = getArguments();
        celestialBody = args.getParcelable("celestialBody");
        celestialBodyDescrtiption.setText(celestialBody.getDescription());

        initToolbar();
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_two, menu);
    }

    @Override
    public void setPresenter(MaterialPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MaterialToolbarContent getToolbarContent() {
        return toolbarContent;
    }

    private void initToolbar() {
        toolbarContent = new MaterialToolbarContent(getActivity(), R.layout.toolbar_planet_detail);
        presenter.getToolbar().setContent(toolbarContent);

        ((TextView) toolbarContent.findViewById(R.id.bodyName)).setText(celestialBody.getName());
        ((ImageView) toolbarContent.findViewById(R.id.bodyImage)).setImageResource(celestialBody.getImageResourceId());
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
}
