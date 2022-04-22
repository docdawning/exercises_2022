import java.util.HashMap;

// Write any import statements here

class Colourful {
  private static HashMap<Integer,String> isColourfulMap;

    private static int getSubSequenceProduct(String sequence) {
      int runningProduct = 1;
      for (int i=0;i<sequence.length();i++) {
        int component = Integer.valueOf(sequence.substring(i,i+1));
        runningProduct *= component;
      }
      return runningProduct;
    }

    private static boolean isColourful(String sequence) {
      isColourfulMap = new HashMap<Integer,String>();

      //first problem is to find the subsequences
      for (int sequenceSize=1;sequenceSize<=sequence.length();sequenceSize++) {
        //Example case:
        //how many segments of size "sequenceSize" exist within this length?

        /*
        sequenceSize == 1:
        1 2 3 4 5
        # of groups: 5

        sequenceSize == 2:
        12 23 34 45
        # of groups: 4

        sequenceSize == 3:
        123 234 345
        # of groups: 3

        sequenceSize == 4:
        1234 2345
        # of groups: 2

        sequenceSize == 5:
        12345
        # of groups: 1
        */

        int numberOfSequenceGroups = sequence.length() - sequenceSize + 1;

        //find each grouping of integers for the current sequenceSize and compute the product of each individual integer
        for (int sequenceGroup=0;sequenceGroup<numberOfSequenceGroups;sequenceGroup++) {
          String subSequence = sequence.substring(sequenceGroup,sequenceGroup+sequenceSize);
          
          //get product of individual elements in subSequence
          int subSequenceProduct = getSubSequenceProduct(subSequence);
          Integer product = new Integer(subSequenceProduct);

          //check if this subSequenceProduct is already in the map
          if (isColourfulMap.get(product) == null) {
            isColourfulMap.put(product, subSequence);
          } else {
            //we reach here if this product was already listed
            return false;
          }
        }
      }
      //never found a collision, therefore this entire sequence is colorful
      return true;
    }
    
    public static void main(String[] a) {

      //Not colorful
      String sequence = "12345";
      System.out.println(sequence+": "+isColourful(sequence));

      //Not colorful
      sequence = "326";
      System.out.println(sequence+": "+isColourful(sequence));

      //Is colorful
      sequence = "3245";
      System.out.println(sequence+": "+isColourful(sequence));

      //Is colorful
      sequence = "24753";
      System.out.println(sequence+": "+isColourful(sequence));

      //Is colorful
      sequence = "98746253";
      System.out.println(sequence+": "+isColourful(sequence));
    }
  }
  