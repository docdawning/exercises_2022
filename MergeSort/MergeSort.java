public class MergeSort {
    private static void mergeSort(int[] unsorted) {
        System.out.print("\nBefore: ");
        printArray(unsorted);
        mergeSort(unsorted, 0, unsorted.length);
        System.out.print("After: ");
        printArray(unsorted);
    }

    private static void mergeSort(int[] unsorted, int startIndex, int endIndex) {
        //System.out.print("["+startIndex+":"+endIndex+"] ");

        //recursion base case
        if ((endIndex - startIndex) <= 1) return;

        //sort halves separately
        int middle =((endIndex - startIndex) / 2)+startIndex;
        mergeSort(unsorted, startIndex, middle);
        mergeSort(unsorted, middle, endIndex);

        //merge sorted halves
        mergeHalves(unsorted, startIndex, middle, endIndex);
    }

/*
    private static void mergeHalves(int[] array, int startIndex, int middle, int endIndex) {

    }
*/
    private static void mergeHalves(int[] array, int startIndex, int middle, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = middle;

        //stage our sorting here
        int[] temp = new int[array.length];
        int tempIndex = startIndex;

        while (leftIndex < middle && rightIndex < endIndex) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++]; 
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }
        
        //copy any remaining uncopied values over to the temp array
        while(leftIndex < middle) {
            temp[tempIndex++] = array[leftIndex++];
        }

        while(rightIndex < endIndex) {
            temp[tempIndex++] = array[rightIndex++];
        }

        //copy over values that were staged in temp array to the main array
        for (int i=startIndex;i<endIndex;i++) {
            array[i] = temp[i];
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }

    public static void main(String[] argv) {
        int[] array1 = {3};
        mergeSort(array1);

        int[] array2 = {3,0};
        mergeSort(array2);

        int[] array3 = {0,-10,-1};
        mergeSort(array3);

        int[] array4 = {-1, -10, 5, 30034, 4, 35, 10, -300, 4};
        mergeSort(array4);

        int[] array5 = {0, 99, 42, 71, 1, 6, 9, 50, -4, 43, 100041};
        mergeSort(array5);
    }
}
