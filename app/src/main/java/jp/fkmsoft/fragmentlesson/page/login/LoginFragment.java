package jp.fkmsoft.fragmentlesson.page.login;

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
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

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

        // Lesson 6
        // このユーザー名を呼び出し元(TitleFragment)のFragmentに伝えよう
        // 呼び出し元は、EditTextにその値をセットしてみよう

        getFragmentManager().popBackStack();
    }
}
