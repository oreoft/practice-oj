package main

import (
	"fmt"
	"unicode"
)

func myAtoi(str string) int {
	result := 0
	sign := 1
	i := 0

	// 跳过空白字符
	for i < len(str) && str[i] == ' ' {
		i++
	}

	// 处理正负号
	if i < len(str) && (str[i] == '+' || str[i] == '-') {
		if str[i] == '-' {
			sign = -1
		}
		i++
	}

	// 解析数字
	for i < len(str) && unicode.IsDigit(rune(str[i])) {
		digit := int(str[i] - '0')

		// 检查是否越界
		if result > (1<<31-1)/10 || (result == (1<<31-1)/10 && digit > 7) {
			if sign == 1 {
				return 1<<31 - 1
			} else {
				return -1 << 31
			}
		}

		result = result*10 + digit
		i++
	}

	return result * sign
}

func main() {
	str := "   -42"
	result := myAtoi(str)
	fmt.Println(result)
}
