import { registerPlugin } from '@capacitor/core';

import type { WebViewHelperPlugin } from './definitions';

const WebViewHelper = registerPlugin<WebViewHelperPlugin>('WebViewHelper', {
  web: () => import('./web').then((m) => new m.WebViewHelperWeb()),
});

export * from './definitions';
export { WebViewHelper };
