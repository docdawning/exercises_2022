import math

def print_array(array):
    array_str = ""
    for element in array:
        array_str += "{} ".format(element)
    print("[{}]".format(array_str))

def merge_sort(array, left_idx, right_idx):
    # recursion base case
    if (right_idx - left_idx <= 1):
        return

    # split halves and recurse
    middle = math.floor((right_idx - left_idx)/2 + left_idx)
    merge_sort(array, left_idx, middle)
    merge_sort(array, middle, right_idx)

    # merge halves
    merge_halves(array, left_idx, middle, right_idx)

def merge_halves(array, left_idx, middle, right_idx):
    #print("Merging {} to {}".format(left_idx, right_idx))
    temp_array = []
    for each in array:
        temp_array.append("-")
    
    left = left_idx
    right = middle
    temp_idx = left_idx

    while (left < middle and right < right_idx):
        if (array[left] < array[right]):
            temp_array[temp_idx] = array[left]
            left += 1
        else:
            temp_array[temp_idx] = array[right]
            right += 1
        temp_idx += 1

    # Copy any left over elements from either half
    while (left < middle):
        temp_array[temp_idx] = array[left]
        left += 1
        temp_idx += 1

    while (right < right_idx):
        temp_array[temp_idx] = array[right]
        right += 1
        temp_idx += 1

    #copy temp to array and return
    for i in range(left_idx, right_idx):
        array[i] = temp_array[i]

def do_merge_sort():
    array1 = [1, -3, 100, 2, 5, 99, 72, -9, 0, 5, 0, 1, 3, -10, 100, -100, 2, 4]
    print_array(array1)
    merge_sort(array1, 0, len(array1))
    print_array(array1)

if __name__ == "__main__":
    do_merge_sort()