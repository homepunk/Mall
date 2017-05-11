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
import homepunk.work.mall.presentation.viewmodel.ShopViewModel;
import timber.log.Timber;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopHolder> {
    private final Context context;
    private List<ShopViewModel> shops;

    public ShopAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<ShopViewModel> shops) {
        this.shops = shops;
    }

    @Override
    public ShopHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.item_shop, parent, false);

        return new ShopHolder(root);
    }

    @Override
    public void onBindViewHolder(ShopHolder holder, int position) {
        ShopViewModel shop = shops.get(position);

        holder.loadImage(shop.getIamgeUrl());
        holder.setName(shop.getName());
        holder.setDescription(shop.getDescription());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public void updateShops(List<ShopViewModel> shops) {
        this.shops.clear();
        this.shops.addAll(shops);
        notifyDataSetChanged();
    }

    class ShopHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_shop_image)
        ImageView image;
        @Bind(R.id.item_shop_name)
        TextView name;
        @Bind(R.id.item_shop_description)
        TextView description;
        @Bind(R.id.item_shop_progress)
        ProgressBar progress;

        public ShopHolder(View root) {
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

            if (!TextUtils.isEmpty(imageUrl)) {
                Timber.i(imageUrl);
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
                                loadPlaceholder();
                            }
                        });
            } else {
                hideProgress();
                loadPlaceholder();
            }
        }

        private void loadPlaceholder() {
            image.setImageResource(R.drawable.placeholder);
        }

        private void hideProgress() {
            progress.setVisibility(View.GONE);
        }

        private void showProgress() {
            progress.setVisibility(View.VISIBLE);
        }
    }
}
