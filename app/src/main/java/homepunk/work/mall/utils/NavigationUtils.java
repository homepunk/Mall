package homepunk.work.mall.utils;

import android.content.Context;
import android.content.Intent;

import homepunk.work.mall.presentation.activity.MallDetailsActivity;
import homepunk.work.mall.presentation.activity.MallListActivity;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;

import static homepunk.work.mall.presentation.viewmodel.MallViewModel.MALL_KEY_ID;
import static homepunk.work.mall.presentation.viewmodel.UserLoginViewModel.USER_KEY_ID;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class NavigationUtils {
    public static void navigateToHomeScreen(Context context, UserLoginViewModel user) {
        Intent intent = new Intent(context, MallListActivity.class);

        intent.putExtra(USER_KEY_ID, user);
        context.startActivity(intent);
    }

    public static void navigateToMallDetails(Context context, MallViewModel mall) {
        Intent intent = new Intent(context, MallDetailsActivity.class);

        intent.putExtra(MALL_KEY_ID, mall);
        context.startActivity(intent);
    }
}
