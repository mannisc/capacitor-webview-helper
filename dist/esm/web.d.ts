import { WebPlugin } from '@capacitor/core';
import type { WebViewHelperPlugin } from './definitions';
export declare class WebViewHelperWeb extends WebPlugin implements WebViewHelperPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    setHeight(): Promise<{
        success: boolean;
    }>;
}
