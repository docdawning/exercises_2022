// Write any import statements here

class Cafeteria {
  
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

    private boolean someone_is_sitting_within_k_seats(long seat, long K, long[] S) {
      return false;
    }

    private long[] merge_sort(long[] S, long M) {
      /*
      long[] sorted_array = new long[M];
      for (long i=0;i<M;i++) {
        
      }
      */
      return null;
    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
      
      //0 1 2 3 4 5 6 7 8 9
      //x   x   x   x   x
        
      //0 1 2 3 4 5 6 7 8 9 A B C D E
      //          x         x     x   
      
      /*
      1 2 3 4 5 6 7 8 9 A
          x       x
      
      1. is i in S?
      2. is i+(1..k) in S?
      3. 
  
      
      */

      /*
      Algo will be:
      1. Loop through each seat, i
        - if there is no occupied seats within the next K seats, store this as a new_occupant, continue search at the next i+k'th seat
        - if there is an occupant already here, continue the search at i+k seats
      
      */

      long new_occupants = 0;

      //Lets sort S via merge sort
      //N = merge_sort(S, M)

      for (long i=1;i<N;i++) {
        if (!someone_is_sitting_within_k_seats(i, K, S)) {
          //we can use this seat
          System.out.println("Added sitter at seat #"+i);
          new_occupants++;
          i+=K;
        }
      }
      
      return new_occupants;
    }
    

    public static void main(String[] a) {
      Cafeteria sol = new Cafeteria();

      long N = 10;
      long K = 1;
      int M = 2;
      long[] S = {2, 6};
      long number_of_new_sitters = sol.getMaxAdditionalDinersCount(N, K, M, S);
      System.out.println("Found: "+String.valueOf(number_of_new_sitters));
    }
  }
  