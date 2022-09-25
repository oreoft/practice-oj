package main

import "fmt"

func maxArea(height []int) int {
	maxArea := 0
	left := 0
	right := len(height) - 1

	for left < right {
		h := min(height[left], height[right])
		w := right - left
		area := h * w

		if area > maxArea {
			maxArea = area
		}

		// 移动较短的边界，以期望找到更高的线段
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}

	return maxArea
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	heights := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	result := maxArea(heights)
	fmt.Println(result)
}
