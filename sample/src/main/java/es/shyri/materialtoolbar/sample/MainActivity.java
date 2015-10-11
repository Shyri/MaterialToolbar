package es.shyri.materialtoolbar.sample;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.shyri.materialtoolbar.MaterialPresenter;
import es.shyri.materialtoolbar.sample.fragment.FragmentPlanetsList;


public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    MaterialPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        presenter = MaterialPresenter.getInstance();

        getFragmentManager().addOnBackStackChangedListener(this);

        presenter.attachActivity(this, R.id.main_toolbar, R.id.fragmentContainer);
        if (getFragmentManager().findFragmentById(R.id.fragmentContainer) == null) {
            presenter.navigateTo(new FragmentPlanetsList());
        }
    }

    @Override
    public void onBackPressed(){
        if(!presenter.onBackPressed()) super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getFragmentManager().removeOnBackStackChangedListener(this);
        presenter.detachActivity();
    }

    @Override
    public void onBackStackChanged() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(getFragmentManager().getBackStackEntryCount() > 1);
    }
}
