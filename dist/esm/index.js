import { registerPlugin } from '@capacitor/core';
const WebViewHelper = registerPlugin('WebViewHelper', {
    web: () => import('./web').then((m) => new m.WebViewHelperWeb()),
});
export * from './definitions';
export { WebViewHelper };
//# sourceMappingURL=index.js.map