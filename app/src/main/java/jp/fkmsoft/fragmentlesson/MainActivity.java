package jp.fkmsoft.fragmentlesson;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import jp.fkmsoft.fragmentlesson.page.title.TitleFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new TitleFragment())
                    .commit();
        }
    }
}
