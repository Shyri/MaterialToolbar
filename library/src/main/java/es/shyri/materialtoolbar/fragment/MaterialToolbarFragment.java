package es.shyri.materialtoolbar.fragment;

import android.app.Fragment;
import android.os.Bundle;

import es.shyri.materialtoolbar.MaterialToolbarContent;
import es.shyri.materialtoolbar.activity.MaterialToolbarActivity;

/**
 * Created by Shyri on 04/03/2015.
 */
public class MaterialToolbarFragment extends Fragment {
    MaterialToolbarContent mToolbarContent;

    public MaterialToolbarContent onCreateMaterialToolbarContent(Bundle savedInstanceState){
        return null;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mToolbarContent = onCreateMaterialToolbarContent(savedInstanceState);
        if(mToolbarContent!=null) ((MaterialToolbarActivity) getActivity()).setMaterialToolbarContent(mToolbarContent);
    }
}
