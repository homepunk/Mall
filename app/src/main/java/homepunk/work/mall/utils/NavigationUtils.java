package homepunk.work.mall.utils;

import android.content.Context;
import android.content.Intent;

import homepunk.work.mall.presentation.activity.MallActivity;
import homepunk.work.mall.presentation.activity.MallListActivity;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

import static homepunk.work.mall.data.Constants.Keys.KEY_MALL;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class NavigationUtils {
    public static void navigateToHomeScreen(Context context) {
        Intent intent = new Intent(context, MallListActivity.class);

        context.startActivity(intent);
    }

    public static void navigateToMallActivity(Context context, MallViewModel mall) {
        Intent intent = new Intent(context, MallActivity.class);

        intent.putExtra(KEY_MALL, mall);
        context.startActivity(intent);
    }
}
