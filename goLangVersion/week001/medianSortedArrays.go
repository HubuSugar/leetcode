package main

import "fmt"

func main() {

}
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	var res float64 = 0.0
	if (nums1 == nil || len(nums1) == 0) && (nums2 == nil || len(nums2) == 0) {
		return res
	}
	var m = len(nums1)
	var n = len(nums2)

	var maxLength = 0

	if (m+n)%2 == 0 {
		maxLength = (m + n) / 2
	} else {
		maxLength = (m + n - 1) / 2
	}
	fmt.Println(maxLength)

	var j = 0
	var k = 0
	for j+k < maxLength {

	}

	return res
}
