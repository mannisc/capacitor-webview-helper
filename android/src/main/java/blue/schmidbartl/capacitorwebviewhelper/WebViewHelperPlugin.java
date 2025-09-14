package blue.schmidbartl.capacitorwebviewhelper;

import android.view.View;
import android.view.ViewGroup;
import android.util.DisplayMetrics;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "WebViewHelper")
public class WebViewHelperPlugin extends Plugin {

    @PluginMethod
    public void setHeight(PluginCall call) {
        Integer cssHeight = call.getInt("height");

        getActivity().runOnUiThread(() -> {
            try {
                // Root view of the activity
                View rootView = getActivity().findViewById(android.R.id.content);

                // Find first ViewGroup inside root (usually your layout container)
                ViewGroup target = findFirstViewGroup(rootView);

                if (target != null) {
                    ViewGroup.LayoutParams params = target.getLayoutParams();

                    if (cssHeight != null) {
                        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
                        int devicePixels = Math.round(cssHeight * metrics.density);
                        params.height = devicePixels;
                    } else {
                        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    }

                    target.setLayoutParams(params);
                }

                JSObject ret = new JSObject();
                ret.put("success", true);
                call.resolve(ret);

            } catch (Exception e) {
                JSObject ret = new JSObject();
                ret.put("success", false);
                ret.put("error", e.getMessage());
                call.resolve(ret);
            }
        });
    }

    // Recursively find first ViewGroup (ignoring WebView)
    private ViewGroup findFirstViewGroup(View view) {
        if (view instanceof ViewGroup && !(view instanceof android.webkit.WebView)) {
            return (ViewGroup) view;
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                ViewGroup result = findFirstViewGroup(group.getChildAt(i));
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }
}