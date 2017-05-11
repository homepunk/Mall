package homepunk.work.mall.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.MallHolder> {
    private List<MallViewModel> malls;
    private Context context;

    public MallAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<MallViewModel> malls) {
        this.malls = malls;
    }

    @Override
    public MallHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.item_mall, parent, false);

        return new MallHolder(root);
    }

    @Override
    public void onBindViewHolder(MallHolder holder, int position) {
        MallViewModel mall = malls.get(position);

        holder.showProgress();
        holder.setName(mall.getName());
        holder.setDescription(mall.getDescription());
        holder.loadImage(mall.getFullImagePath());
    }

    @Override
    public int getItemCount() {
        return malls.size();
    }

    public void updateMalls(List<MallViewModel> malls) {
        this.malls.clear();
        this.malls.addAll(malls);
        notifyDataSetChanged();
    }

    public class MallHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_mall_description)
        TextView description;
        @Bind(R.id.item_mall_image)
        ImageView image;
        @Bind(R.id.item_mall_name)
        TextView name;
        @Bind(R.id.item_mall_progress_bar)
        ProgressBar progress;

        public MallHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        public void setName(String name) {
            if (!TextUtils.isEmpty(name)) {
                this.name.setText(name);
            }
        }

        public void setDescription(String description) {
            if (!TextUtils.isEmpty(description)) {
                this.description.setText(description);
            }
        }

        public void loadImage(String imageUrl) {
            showProgress();

            Picasso.with(context)
                    .load(imageUrl)
                    .into(image, new Callback() {
                        @Override
                        public void onSuccess() {
                            hideProgress();
                        }

                        @Override
                        public void onError() {
                            hideProgress();
                            image.setImageResource(R.drawable.placeholder);
                        }
                    });
        }

        private void hideProgress() {
            progress.setVisibility(View.GONE);
        }

        private void showProgress() {
            progress.setVisibility(View.VISIBLE);
        }
    }
}
