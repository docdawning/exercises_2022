from typing import List
# Write any import statements here

def getHitProbability(R: int, C: int, G: List[List[int]]) -> float:
  number_of_ships = 0.0
  number_of_cells = R*C

  for row in range(R):
      for column in range(C):
          if G[row][column] == 1:
              number_of_ships += 1
        
  return number_of_ships/number_of_cells

if __name__ == "__main__":
    grid=[[1,0,1],[0,0,1],[0,0,0]]
    print(getHitProbability(3, 3, grid))