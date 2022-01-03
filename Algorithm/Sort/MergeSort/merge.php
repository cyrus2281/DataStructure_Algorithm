<?php

class Merge {
        // sort in ascending
        function merge_sort($list) {
            // Recursive base case
            if (count($list) <= 1)
                return $list;
    
            // Divide: Find the midpoint of the list and divide into sublists
            $left_right_halves = $this->split($list);
    
            // Conquer: Recursively sort the sublists created in previous step
            $left = $this->merge_sort($left_right_halves[0]);
            $right = $this->merge_sort($left_right_halves[1]);
    
            // Combine: Merge the sorted sublists created in previous step
            return $this->merge($left, $right);
        }
    
        function split($list) {
            // Divide the unsorted list at midpoint into sublists
            $mid = count($list) / 2;
            $left = array_slice($list, 0, $mid);
            $right = array_slice($list, $mid, count($list));
    
            // Return two sublists - left and right
            return [$left, $right];
        }
    
        function merge($left, $right) {
            // Merges two lists (arrays), sorting them in the process
            $lst = array();
            $i = 0;
            $j = 0;
    
            while ($i < count($left) && $j < count($right)) {
                if ($left[$i] < $right[$j]) {
                    array_push($lst, $left[$i]);
                    $i++;
                } else {
                    array_push($lst, $right[$j]);
                   $j++;
                }
            }
            // return a new merged list
            while ($i < count($left)) {
                array_push($lst, $left[$i]);
                $i++;
            }
            while ($j < count($right)) {
                array_push($lst, $right[$j]);
                $j++;
            }
            return $lst;
        }


    /**
     * Runs at O(n log n)
     * Takes O(n)
     */
    function main()
    {
        $unsortedList = [4, 62, 94, 12, 77, 21, 40, 49, 2, 31];
        $sortedList = $this->merge_sort($unsortedList);
        print_r($sortedList);
    }
}

(new Merge()) -> main();