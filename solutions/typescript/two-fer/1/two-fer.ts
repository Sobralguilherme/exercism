export function twoFer(name?: string): string {
  // If name is undefined or an empty string, default to "you"
  const person = name || 'you';
  return `One for ${person}, one for me.`;
}