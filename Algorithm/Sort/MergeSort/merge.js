class Merge {
  // sort in ascending
  merge_sort(list) {
    // Recursive base case
    if (list.length <= 1) return list;

    // Divide: Find the midpoint of the list and divide into sublists
    const [left_half, right_half] = this.split(list);

    // Conquer: Recursively sort the sublists created in previous step
    const left = this.merge_sort(left_half);
    const right = this.merge_sort(right_half);

    // Combine: Merge the sorted sublists created in previous step
    return this.merge(left, right);
  }

  split(list) {
    // Divide the unsorted list at midpoint into sublists
    const mid = list.length / 2;
    const left = list.slice(0, mid);
    const right = list.slice(mid);

    // Return two sublists - left and right
    return [left, right];
  }

  merge(left, right) {
    // Merges two lists (arrays), sorting them in the process
    const lst = [];
    let i = 0;
    let j = 0;

    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        lst.push(left[i]);
        i += 1;
      } else {
        lst.push(right[j]);
        j += 1;
      }
    }
    // return a new merged list
    while (i < left.length) {
      lst.push(left[i]);
      i += 1;
    }
    while (j < right.length) {
      lst.push(right[j]);
      j += 1;
    }
    return lst;
  }

  /**
   * Runs at O(n log n)
   * Takes O(n)
   */
  main() {
    const unsortedList = [54, 62, 94, 12, 77, 21, 40, 49, 2, 31];
    const sortedList = this.merge_sort(unsortedList);
    console.log(sortedList);
  }
}

new Merge().main();
