package ir.coursio.daggertutorial;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.coursio.daggertutorial.api.ApiService;
import ir.coursio.daggertutorial.model.Responses.JokeListResponse;
import ir.coursio.daggertutorial.modules.MainActivityModule;
import ir.coursio.daggertutorial.qualifier.ApiServiceQualifier;
import ir.coursio.daggertutorial.view.JokeAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    Call<JokeListResponse> mCall;
    @Inject
    JokeAdapter mAdapter;

    @Inject
    @ApiServiceQualifier
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .daggerTutorialApplicationComponent(DaggerTutorialApplication.get(this).component())
                .build();
        component.injectMainActivity(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCall != null) {
            mCall.cancel();
        }
    }

    @OnClick(R.id.btnGetJoke)
    public void getJoke() {
        mCall = apiService.getJokes();
        mCall.enqueue(new Callback<JokeListResponse>() {
            @Override
            public void onResponse(Call<JokeListResponse> call, Response<JokeListResponse> response) {
                mAdapter.SwapData(response.body().getJokes());
            }

            @Override
            public void onFailure(Call<JokeListResponse> call, Throwable t) {

            }
        });
    }
}
