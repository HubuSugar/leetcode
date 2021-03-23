package main

import "fmt"

func main() {
	var s = "abcb"
	substring := lengthOfLongestSubstring(s)
	fmt.Println(substring)
}

func lengthOfLongestSubstring(s string) int {
	var maxCount = 0
	if len(s) == 0 || len(s) == 1 {
		return len(s)
	}

	for index := range s {
		valueMap := make(map[byte]int)
		valueMap[s[index]] = index
		var j = index + 1
		if j >= len(s) {
			break
		}

		for ; j < len(s); j++ {
			var curVal = s[j]
			if _, ok := valueMap[curVal]; ok {
				count := j - index
				if count >= maxCount {
					maxCount = count
				}
				break
			} else {
				valueMap[curVal] = j
			}

		}
		if j == len(s) {
			count := j - index
			if count > maxCount {
				maxCount = count
			}
			break
		}

	}

	return maxCount
}
