import { WebPlugin } from '@capacitor/core';
import type { WebViewHelperPlugin } from './definitions';

export class WebViewHelperWeb extends WebPlugin implements WebViewHelperPlugin {

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async setHeight(): Promise<{ success: boolean }> {
    return { success: true };
  }
}