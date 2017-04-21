package ir.coursio.daggertutorial.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.coursio.daggertutorial.BaseActivity;
import ir.coursio.daggertutorial.MainActivity;
import ir.coursio.daggertutorial.R;
import ir.coursio.daggertutorial.model.Subs.JokeStruct;


/**
 * Created by Taher on 11/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {

    private Picasso picasso;
    private Context mContext;
    private ArrayList<JokeStruct> mJokeList = new ArrayList<>(0);

    @Inject
    public JokeAdapter(MainActivity mContext, Picasso picasso) {
        this.mContext = mContext;
        this.picasso = picasso;
    }

    public void SwapData(ArrayList<JokeStruct> mJokeList) {
        this.mJokeList = mJokeList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_joke, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mJokeList != null) {
            holder.txtJoke.setText(mJokeList.get(position).getText());

            picasso.load("http://coursio.ir/wp-content/uploads/2017/04/logo.png")
                    .into(holder.imageView);
        }
    }


    @Override
    public int getItemCount() {
        return mJokeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtJoke)
        TextView txtJoke;

        @BindView(R.id.img)
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
