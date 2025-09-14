// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorWebviewHelper",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorWebviewHelper",
            targets: ["WebViewHelperPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "WebViewHelperPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/WebViewHelperPlugin"),
        .testTarget(
            name: "WebViewHelperPluginTests",
            dependencies: ["WebViewHelperPlugin"],
            path: "ios/Tests/WebViewHelperPluginTests")
    ]
)