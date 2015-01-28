package jp.fkmsoft.fragmentlesson.page.title;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.fkmsoft.fragmentlesson.R;
import jp.fkmsoft.fragmentlesson.page.login.LoginFragment;
import jp.fkmsoft.fragmentlesson.page.main.MainFragment;

/**
 * タイトル画面
 */
public class TitleFragment extends Fragment {
    private static final int REQUEST_LOGIN = 1000;

    private static final String STATE_NAME = "name";

    @InjectView(R.id.edit_name)
    EditText mNameEdit;

    private String mName = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mName = "";
        } else {
            mName = savedInstanceState.getString(STATE_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.inject(this, root);
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case REQUEST_LOGIN: {
            if (resultCode != Activity.RESULT_OK) { return; }

            mName = data.getStringExtra(LoginFragment.EXTRA_NAME);
            if (isResumed()) {
                mNameEdit.setText(mName);
            }

            return;
        }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
        mNameEdit.setText(mName);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_NAME, mName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.button_start)
    void startClicked() {
        // Lesson 3と5 の回答
        String name = mNameEdit.getText().toString();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack("tag");
        transaction.replace(R.id.container, MainFragment.newInstance(name));
        transaction.commit();
    }

    @OnClick(R.id.button_continue)
    void continueClicked() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack("tag");
        transaction.replace(R.id.container, LoginFragment.newInstance(this, REQUEST_LOGIN));
        transaction.commit();
    }


}
