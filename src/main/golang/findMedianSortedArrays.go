package main

import "fmt"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	m, n := len(nums1), len(nums2)
	if m > n {
		nums1, nums2, m, n = nums2, nums1, n, m
	}

	iMin, iMax, halfLen := 0, m, (m+n+1)/2
	for iMin <= iMax {
		i := (iMin + iMax) / 2
		j := halfLen - i

		if i < m && nums2[j-1] > nums1[i] {
			// 增大 i
			iMin = i + 1
		} else if i > 0 && nums1[i-1] > nums2[j] {
			// 减小 i
			iMax = i - 1
		} else {
			// i 是完美的
			var maxLeft int
			if i == 0 {
				maxLeft = nums2[j-1]
			} else if j == 0 {
				maxLeft = nums1[i-1]
			} else {
				maxLeft = max(nums1[i-1], nums2[j-1])
			}

			if (m+n)%2 == 1 {
				return float64(maxLeft)
			}

			var minRight int
			if i == m {
				minRight = nums2[j]
			} else if j == n {
				minRight = nums1[i]
			} else {
				minRight = min(nums1[i], nums2[j])
			}

			return float64(maxLeft+minRight) / 2.0
		}
	}

	return 0.0
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	// 测试示例
	nums1 := []int{1, 3}
	nums2 := []int{2}
	result := findMedianSortedArrays(nums1, nums2)
	fmt.Println(result) // 输出: 2.0
}
