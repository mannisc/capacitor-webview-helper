export interface WebViewHelperPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
