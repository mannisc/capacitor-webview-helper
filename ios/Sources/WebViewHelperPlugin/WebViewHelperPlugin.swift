import Capacitor
import Foundation
import UIKit

@objc(WebViewHelperPlugin)
public class WebViewHelperPlugin: CAPPlugin {

    @objc func setHeight(_ call: CAPPluginCall) {
        let cssHeight = call.getInt("height")  // in CSS px (like Android)

        DispatchQueue.main.async {
            if let rootView = self.bridge?.viewController?.view {
                var frame = rootView.frame

                if let h = cssHeight {
                    // Convert CSS px to iOS points
                    let scale = UIScreen.main.scale
                    let points = CGFloat(h) / scale
                    frame.size.height = points
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

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": value
        ])
    }
}
