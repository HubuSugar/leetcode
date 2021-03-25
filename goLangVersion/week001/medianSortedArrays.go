package main

import "fmt"

func main() {
	nums1 := []int{1, 6, 7, 9}
	nums2 := []int{2, 3, 8}
	arrays := findMedianSortedArrays(nums1, nums2)
	fmt.Println(arrays)
}

// O(log(m + n))算法，假设第k个元素是中位数，则在nums1和nums2的混合集合中找到第k个元素
// 在nums1和nums2中各拿出k/2个元素，比较各自中最大的一个，这样每比较一次就会找到k/2个比k小的元素
// 此时在剩下的集合中查找第k/2个元素，以此类推，当k为0时就找到了中位数（但是k不会为0，只会是1，所以当k为1时比较两个序列中首元素小的那个）
// 当某个序列中所有元素都比第k个元素小时，就返回另一个队列中的第k个元素
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	//len := len(nums2) + len(nums1)
	//k := len / 2
	//if len % 2 == 0 {
	//	return (helper(nums1, 0, nums2, 0, k + 1) + helper(nums1, 0, nums2, 0, k)) / 2.0
	//} else {
	//	return helper(nums1, 0, nums2, 0, k + 1)
	//}
	//
	//int m = A.length;
	//int n = B.length;
	//
	//if ((m + n) % 2 != 0) {
	//	// 两个数组的元素总个数为奇数
	//	return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
	//} else {
	//	// 两个数组的元素总个数为偶数
	//	return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A, B,
	//		(m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
	//}

	m := len(nums1)
	n := len(nums2)
	if (m+n)%2 != 0 {
		return float64(helper(nums1, nums2, (m+n)/2, 0, m-1, 0, n-1))
	} else {
		return float64((helper(nums1, nums2, (m+n)/2, 0, m-1, 0, n-1) + helper(nums1, nums2, (m+n)/2-1, 0, m-1, 0, n-1)) / 2.0)
	}

}

/*
      public static int findKth(int A[], int B[], int k, int aStart, int aEnd,
                              int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        if (aLen == 0) {
            return B[bStart + k];
        }
        if (bLen == 0) {
            return A[aStart + k];
        }
        if (k == 0) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = aLen * k / (aLen + bLen);
        int bMid = k - aMid - 1;

        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
* 依据上面的算法查找中位数
* n,m分别记录nums1和nums2在哪个位置之前的数据已被筛选
*/
func helper(a []int, b []int, k int, aStart int, aEnd int, bStart int, bEnd int) int {
	aLen := aEnd - aStart + 1
	bLen := bEnd - bStart + 1
	if aLen == 0 {
		return b[bStart+k]
	}

	if bLen == 0 {
		return a[aStart+k]
	}

	if k == 0 {
		if a[aStart] > b[bStart] {
			return b[bStart]
		}
		return a[aStart]
	}

	aMid := aLen * k / (aLen + bLen)
	bMid := k - aMid - 1

	aMid = aMid + aStart
	bMid = bMid + bStart
	if a[aMid] > b[bMid] {
		k = k - (bMid - bStart + 1)
		aEnd = aMid
		bStart = bMid + 1
	} else {
		k = k - (aMid - aStart + 1)
		bEnd = bStart
		aStart = aMid + 1
	}

	return helper(a, b, k, aStart, aEnd, bStart, bEnd)
}
