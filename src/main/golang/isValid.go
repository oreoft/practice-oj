package main

import "fmt"

func isValid(s string) bool {
	stack := make([]rune, 0)

	mapping := map[rune]rune{
		')': '(',
		'}': '{',
		']': '[',
	}

	for _, char := range s {
		if closing, exists := mapping[char]; exists {
			// 如果栈为空或者栈顶元素不匹配
			if len(stack) == 0 || stack[len(stack)-1] != closing {
				return false
			}
			stack = stack[:len(stack)-1] // 出栈
		} else {
			stack = append(stack, char) // 入栈
		}
	}

	return len(stack) == 0
}

func main() {
	// 测试示例
	fmt.Println(isValid("()"))     // 输出: true
	fmt.Println(isValid("()[]{}")) // 输出: true
	fmt.Println(isValid("(]"))     // 输出: false
	fmt.Println(isValid("([)]"))   // 输出: false
	fmt.Println(isValid("{[]}"))   // 输出: true
}
