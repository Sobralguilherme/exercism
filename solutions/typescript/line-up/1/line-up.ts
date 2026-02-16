export function format(name: unknown, number: unknown): string {
  if (typeof name !== 'string') {
    throw new TypeError('Name must be a string');
  }

  if (typeof number !== 'number' || !Number.isInteger(number)) {
    throw new TypeError('Number must be an integer');
  }

  if (number < 1 || number > 999) {
    throw new RangeError('Number must be between 1 and 999');
  }

  const n = Math.abs(number);
  const lastTwo = n % 100;
  const lastOne = n % 10;

  let suffix = 'th';
  if (lastTwo < 11 || lastTwo > 13) {
    if (lastOne === 1) suffix = 'st';
    else if (lastOne === 2) suffix = 'nd';
    else if (lastOne === 3) suffix = 'rd';
  }

  return `${name}, you are the ${n}${suffix} customer we serve today. Thank you!`;
}
