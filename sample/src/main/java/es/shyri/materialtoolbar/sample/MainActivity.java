package es.shyri.materialtoolbar.sample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import es.shyri.materialtoolbar.MaterialToolbar;
import es.shyri.materialtoolbar.activity.MaterialToolbarActivity;
import es.shyri.materialtoolbar.sample.fragment.FragmentOne;


public class MainActivity extends MaterialToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayoutContentId(R.id.mainFragment);
        setMaterialToolbar((MaterialToolbar) findViewById(R.id.main_toolbar));
        navigateTo(new FragmentOne());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
