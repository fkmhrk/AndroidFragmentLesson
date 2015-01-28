package jp.fkmsoft.fragmentlesson.page.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.fkmsoft.fragmentlesson.R;

/**
 * ログイン画面
 */
public class LoginFragment extends Fragment {
    public static final String EXTRA_NAME = "name";

    public static LoginFragment newInstance(Fragment target, int requestCode) {
        LoginFragment fragment = new LoginFragment();
        fragment.setTargetFragment(target, requestCode);

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.inject(this, root);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.reset(this);
    }

    // UI event

    @OnClick(R.id.button_login)
    void loginClicked() {
        String username = "dummyUsername";

        // Lesson 6の回答
        Fragment target = getTargetFragment();
        if (target == null) {
            close();
            return;
        }

        Intent it = new Intent();
        it.putExtra(EXTRA_NAME, username);
        target.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, it);

        close();
    }

    private void close() {
        getFragmentManager().popBackStack();
    }
}
