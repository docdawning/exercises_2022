public class MergeSort {
    private static void mergeSort(int[] unsorted) {
        System.out.print("\n\nBefore: ");
        printArray(unsorted);
        mergeSort(unsorted, 0, unsorted.length);
        System.out.print("\nAfter: ");
        printArray(unsorted);
    }

    private static void mergeSort(int[] array, int startIndex, int endIndex) {
        //recursion base case is when startIndex and endIndex are equal
        if ((endIndex-startIndex) <= 1) return;

        //split array sections to sort in to halves
        int middle = ((endIndex - startIndex) / 2) + startIndex;
        mergeSort(array, startIndex, middle);
        mergeSort(array, middle, endIndex);

        //merge the respective halves back together
        mergeHalves(array, startIndex, middle, endIndex);
    }

    private static void mergeHalves(int[] array, int startIndex, int middle, int endIndex) {
        int[] temp = new int[array.length];
        int tempIndex = startIndex;

        int leftIndex = startIndex;
        int rightIndex = middle;

        while (leftIndex < middle && rightIndex < endIndex) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }

        //any left over elements from either side can now be copied over to temp
        while (leftIndex < middle) temp[tempIndex++] = array[leftIndex++];
        while (rightIndex < endIndex) temp[tempIndex++] = array[rightIndex++];

        //now copy over the elements from temp back to array
        for (int i=startIndex;i<endIndex;i++)
            array[i] = temp[i];
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i=0;i<array.length-1;i++) {
            System.out.print(array[i]+", ");
        }
        System.out.print(array[array.length-1]+"]");
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
