package blue.schmidbartl.capacitorwebviewhelper;

import com.getcapacitor.Logger;

public class WebViewHelper {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }
}
