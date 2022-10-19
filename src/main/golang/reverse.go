package main

import "fmt"

func reverse(x int) int {
    // 处理边界情况
    if x == 0 {
        return 0
    }

    // 标记正负号
    sign := 1
    if x < 0 {
        sign = -1
        x = -x
    }

    // 反转数字
    result := 0
    for x > 0 {
        digit := x % 10
        x /= 10

        // 检查溢出
        if result > (1<<31-1)/10 {
            return 0
        }

        result = result*10 + digit
    }

    return result * sign
}

func main() {
    // 测试示例
    fmt.Println(reverse(123))   // 输出: 321
    fmt.Println(reverse(-123))  // 输出: -321
    fmt.Println(reverse(120))   // 输出: 21
}