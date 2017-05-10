package homepunk.work.mall.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import homepunk.work.mall.R;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PicassoUtils {

    public static void load(Context context, String imagePath, ImageView into) {
        if (TextUtils.isEmpty(imagePath)) {
            into.setImageResource(R.drawable.placeholder);
        } else {
            Picasso.with(context)
                    .load(imagePath)
                    .into(into, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            into.setImageResource(R.drawable.placeholder);
                        }
                    });
        }
    }
}
