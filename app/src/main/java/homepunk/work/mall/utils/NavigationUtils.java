package homepunk.work.mall.utils;

import android.content.Context;
import android.content.Intent;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.presentation.main.views.MallDetailsActivity;
import homepunk.work.mall.presentation.main.views.MallsActivity;

import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.User.USER_KEY_ID;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class NavigationUtils {
    public static void navigateToHomeScreen(Context context, UserLogin user) {
        Intent intent = new Intent(context, MallsActivity.class);

        intent.putExtra(USER_KEY_ID, user);
        context.startActivity(intent);
    }

    public static void navigateToMallDetails(Context context, int id) {
        Intent intent = new Intent(context, MallDetailsActivity.class);

        intent.putExtra(MALL_KEY_ID, id);
        context.startActivity(intent);
    }
}
