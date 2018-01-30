package component.noahzu.github.io.uirouter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by zujinhao on 2018/1/24.
 */

public class UIRouterBuilder {
    private final UIRouter mUiRouter;
    private final UIRouterSpec mUIRouterSpec;


    public UIRouterBuilder(UIRouter uiRouter){
        this.mUiRouter = uiRouter;
        this.mUIRouterSpec = new UIRouterSpec();
    }


    public UIRouterBuilder url(String url){
        this.mUIRouterSpec.url = url;
        return this;
    }

    public UIRouterBuilder bundle(Bundle bundle){
        this.mUIRouterSpec.bundle = bundle;
        return this;
    }

    public UIRouterBuilder requestCode(int requestCode){
        this.mUIRouterSpec.requestCode = requestCode;
        return this;
    }


    public UIRouterSpec getmUIRouterSpec() {
        return mUIRouterSpec;
    }

    public boolean jump(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse(mUIRouterSpec.url));
        intent.putExtra("bundle",mUIRouterSpec.bundle);
        if (isIntentAvailable(mUiRouter.getContext().get(),intent)){
            mUiRouter.getContext().get().startActivity(intent);
            return true;
        }
        return false;
    }


    /**
     * 判断Intent是否可用
     * @param context
     * @param intent
     * @return
     */
    private static boolean isIntentAvailable(Context context, Intent intent) {
        if (context == null || intent == null)
            return false;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    /**
     * 寻找最合适的Activity
     * @param context
     * @param intent
     * @return
     */
    public static ResolveInfo queryActivity(Context context, Intent intent) {
        if (context == null || intent == null)
            return null;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfoList == null || resolveInfoList.size() == 0)
            return null;
        int size = resolveInfoList.size();
        if (size == 1)
            return resolveInfoList.get(0);
        String appPackageName = context.getApplicationContext().getPackageName();
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = resolveInfoList.get(i);
            String activityName = resolveInfo.activityInfo.name;
            if (TextUtils.isEmpty(activityName))
                continue;
            if (activityName.startsWith(appPackageName)) {
                return resolveInfo;
            }
        }
        return resolveInfoList.get(0);
    }
}
