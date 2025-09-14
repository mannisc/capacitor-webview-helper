package blue.schmidbartl.capacitorwebviewhelper;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;

public class WebViewHelperPlugin extends Plugin {

    public void setHeight(PluginCall call) {
        Integer height = call.getInt("height");

        getActivity().runOnUiThread(() -> {
            FrameLayout rootView = (FrameLayout) getActivity().getWindow().getDecorView()
                    .findViewById(android.R.id.content);
            if (rootView != null) {
                ViewGroup.LayoutParams params = rootView.getLayoutParams();
                params.height = height != null ? height : ViewGroup.LayoutParams.MATCH_PARENT;
                rootView.setLayoutParams(params);
            }
            JSObject ret = new JSObject();
            ret.put("success", true);
            call.resolve(ret);
        });
    }
}