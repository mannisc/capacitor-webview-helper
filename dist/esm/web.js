import { WebPlugin } from '@capacitor/core';
export class WebViewHelperWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async setHeight() {
        return { success: true };
    }
}
//# sourceMappingURL=web.js.map