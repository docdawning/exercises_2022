import math

def merge_sort(my_array, start_index, end_index):

    # Handle recurse base case
    if ((end_index - start_index) <= 1):
        return

    middle = math.floor(((end_index - start_index) / 2) + start_index)
    #print("my_array[{}:{}], middle: {}".format(start_index, end_index, middle))
    merge_sort(my_array, start_index, middle)
    merge_sort(my_array, middle, end_index)

    #merge halves
    merge_halves(my_array, start_index, middle, end_index)


def merge_halves(my_array, start_index, middle, end_index):
    temp_array = [None] * len(my_array)
    temp_index = start_index
    left_index = start_index
    right_index = middle

    while ((left_index < middle) and (right_index < end_index)):
        if (my_array[left_index] < my_array[right_index]):
            temp_array[temp_index] = my_array[left_index]
            left_index += 1
        else:
            temp_array[temp_index] = my_array[right_index]
            right_index += 1
        temp_index += 1

    # now copy any outstanding elements
    while (left_index < middle):
        temp_array[temp_index] = my_array[left_index]
        temp_index += 1
        left_index += 1

    while (right_index < end_index):
        temp_array[temp_index] = my_array[right_index]
        temp_index += 1
        right_index += 1

    # Now copy the temp array values in to the real one
    temp_index = start_index
    while (temp_index < end_index):
        my_array[temp_index] = temp_array[temp_index]
        temp_index += 1

def begin_merge_sort(my_array):
    print("Before: {}".format(my_array.__str__()))
    merge_sort(my_array, 0, len(my_array))
    print("After: {}".format(my_array.__str__()))

def run_merge_sort():
    my_array = [3, 5, 0, -1, 45, 89]
    begin_merge_sort(my_array)
    
    my_array = [7, -1241231, -3 -342, 1134, 9, 0, 35, -90, 467, 23, 11, 0, 10, 345677654]
    begin_merge_sort(my_array)

if __name__ == "__main__":
    run_merge_sort()