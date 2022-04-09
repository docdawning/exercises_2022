// Write any import statements here

class Solution {
  
    private boolean array_contains_element(long[] array, long element) {
      for (int i=0;i<array.length;i++) {
        if (array[i] == element) return true;
      }
      return false;
    }
    
    // Return true if there are K+1 empty seats to the right of seat_index
    private boolean seats_to_the_right_are_clear(long number_of_seats, long seat_index, long seat_margin, int number_of_current_diners, long[] current_diners) {
      for (long i=seat_index;i<=seat_margin+1;i++) {
        if (array_contains_element(current_diners, i)) { return false; }       
      }
      
      //No conflicts found
      return true;
    }
    
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
      
      //0 1 2 3 4 5 6 7 8 9
      //x   x   x   x   x
        
      //0 1 2 3 4 5 6 7 8 9 A B C D E
      //          x         x     x   
       
      long new_occupants = 0;
      for (int seat=0;seat<N;seat++) {
        //decide if there are enough clear spaces to the right to seat someone
        if (seats_to_the_right_are_clear(N, seat, K, M, S)) {
          //are there enough clear seats to the right of that candidate seat as well?
          if (seats_to_the_right_are_clear(N, seat+K, K, M, S)) {
            new_occupants++;
          }
        }
          
      }
      
      return new_occupants;
    }
    
  }
  