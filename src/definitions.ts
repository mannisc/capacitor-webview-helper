export interface WebViewHelperPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  setHeight(options: { height?: number }): Promise<{ success: boolean }>;
}
