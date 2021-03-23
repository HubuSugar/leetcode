package main

import "fmt"

func main() {
	var s = "abcabcbb"
	substring := lengthOfLongestSubstring(s)
	fmt.Println(substring)
}

func lengthOfLongestSubstring(s string) int {
	var maxCount = 0
	if len(s) == 0 {
		return maxCount
	}

	for index, value := range s {
		valueMap := make(map[int]int)
		fmt.Println(index, value)
		var j = index + 1
		if j >= len(s) {
			break
		}

		for ; j < len(s); j++ {
			var curVal = s[j]
			if _, ok := valueMap[int(curVal)]; ok {
				count := j - index + 1
				if count >= maxCount {
					break
				}
			} else {
				valueMap[int(curVal)] = j
			}

		}
		if j == len(s)-1 {
			maxCount = j - index + 1
			break
		}

	}

	return maxCount
}
