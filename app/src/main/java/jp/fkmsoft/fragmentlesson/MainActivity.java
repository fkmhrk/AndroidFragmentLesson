package jp.fkmsoft.fragmentlesson;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    // Lesson 1. 最初に表示されるFragmentをTitleFragmentにしてみよう
                    .add(R.id.container, null)
                    .commit();
        }
    }
}
