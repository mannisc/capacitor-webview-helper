import Foundation

@objc public class WebViewHelper: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
