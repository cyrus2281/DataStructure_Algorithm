class Merge:
    # sort in ascending
    def merge_sort(self, list):
        # Recursive base case
        if len(list) <= 1:
            return list

        # Divide: Find the midpoint of the list and divide into sublists
        left_half, right_half = self.split(list)

        # Conquer: Recursively sort the sublists created in previous step
        left = self.merge_sort(left_half)
        right = self.merge_sort(right_half)

        # Combine: Merge the sorted sublists created in previous step
        return self.merge(left, right)

    def split(self, list):
        # Divide the unsorted list at midpoint into sublists
        mid = len(list)//2
        left = list[:mid]
        right = list[mid:]

        # Return two sublists - left and right
        return left, right

    def merge(self, left, right):
        # Merges two lists (arrays), sorting them in the process
        lst = []
        i = 0
        j = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                lst.append(left[i])
                i += 1
            else:
                lst.append(right[j])
                j += 1

        # return a new merged list
        while i < len(left):
            lst.append(left[i])
            i += 1

        while j < len(right):
            lst.append(right[j])
            j += 1

        return lst

    # Runs at O(n log n)
    # Takes O(n)
    def main(self):
        unsortedList = [54, 62, 94, 12, 77, 21, 40, 49, 2, 31]
        sortedList = self.merge_sort(unsortedList)
        print(sortedList)


Merge().main()
