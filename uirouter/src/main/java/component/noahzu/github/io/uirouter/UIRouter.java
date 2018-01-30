package component.noahzu.github.io.uirouter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by zujinhao on 2018/1/24.
 */

public class UIRouter {

    private WeakReference<Context> context;
    private UIRouterBuilder builder;

    public static UIRouterBuilder from(Context context){
        UIRouter uiRouter = new UIRouter();
        uiRouter.builder = new UIRouterBuilder(uiRouter);
        uiRouter.context = new WeakReference<Context>(context);
        return uiRouter.builder;
    }


    public WeakReference<Context> getContext() {
        return context;
    }
}
