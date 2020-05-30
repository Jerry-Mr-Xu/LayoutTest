package com.jerry.layouttest;

import android.content.Context;
import android.view.View;

public class Utils {
    public static String getViewIdStr(View targetView) {
        final int viewId = targetView.getId();
        if (View.NO_ID == viewId) {
            return null;
        }

        return getIdResEntryName(targetView.getContext(), viewId);
    }

    private static String getIdResEntryName(Context context, int id) {
        if (id == 0) {
            return null;
        }
        String name = null;
        try {
            name = context.getResources().getResourceEntryName(id);
        } catch (Exception e) {
            return null;
        }
        return name;
    }
}
