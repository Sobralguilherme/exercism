export function count(diagram) {
  if (!diagram || diagram.length === 0) return 0;

  const rows = diagram.length;
  const cols = diagram[0].length;
  let rectangleCount = 0;

  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      if (diagram[r][c] === '+') {
        
        for (let nextC = c + 1; nextC < cols; nextC++) {
          if (diagram[r][nextC] === '+') {
            if (!hasHorizontalLine(diagram, r, c, nextC)) break;

            for (let nextR = r + 1; nextR < rows; nextR++) {
              if (diagram[nextR][c] === '+' && diagram[nextR][nextC] === '+') {
                if (hasVerticalLine(diagram, c, r, nextR) &&
                    hasVerticalLine(diagram, nextC, r, nextR) &&
                    hasHorizontalLine(diagram, nextR, c, nextC)) {
                  rectangleCount++;
                }
              }
              
              if (!isVerticalPoint(diagram[nextR][c]) || !isVerticalPoint(diagram[nextR][nextC])) {
                break;
              }
            }
          } else if (diagram[r][nextC] !== '-') {
            break;
          }
        }
      }
    }
  }
  return rectangleCount;
}

function hasHorizontalLine(diagram, r, start, end) {
  for (let i = start + 1; i < end; i++) {
    if (diagram[r][i] !== '-' && diagram[r][i] !== '+') return false;
  }
  return true;
}

function hasVerticalLine(diagram, c, start, end) {
  for (let i = start + 1; i < end; i++) {
    if (diagram[i][c] !== '|' && diagram[i][c] !== '+') return false;
  }
  return true;
}

function isVerticalPoint(char) {
  return char === '|' || char === '+';
}
