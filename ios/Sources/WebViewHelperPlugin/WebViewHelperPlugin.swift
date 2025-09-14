import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */

@objc(WebViewHelperPlugin)
public class WebViewHelperPlugin: CAPPlugin {

    @objc func setHeight(_ call: CAPPluginCall) {
        let height = call.getInt("height") // optional, in points

        DispatchQueue.main.async {
            if let rootView = self.bridge?.viewController?.view {
                var frame = rootView.frame
                if let h = height {
                    frame.size.height = CGFloat(h)
                } else {
                    frame.size.height = UIScreen.main.bounds.height
                }
                rootView.frame = frame
            }

            call.resolve([
                "success": true
            ])
        }
    }
}