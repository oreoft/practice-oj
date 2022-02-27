package main

import (
	"fmt"
	"math/rand"
	"os"
	"os/exec"
	"time"
)

func main() {

	months := []string{
		"Jan", "Feb", "Mar", "Apr", "May", "Jun",
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
	}
	// 初始化随机数生成器
	rand.Seed(time.Now().UnixNano())
	// 随机取一个月份
	randomMonth := months[rand.Intn(len(months))]
	// 初始化随机数生成器
	rand.Seed(time.Now().UnixNano())
	// 生成1到28之间的随机数
	randomNumber := rand.Intn(25)
	// 获取当前时间
	currentTime := time.Now()
	sprintDate := fmt.Sprintf("%s %d %d %s +0800", randomMonth, 2022, randomNumber, currentTime.Format("15:04:05"))
	fmt.Printf("生成的日期是: %s", sprintDate)
	err := os.Setenv("GIT_COMMITTER_DATE", sprintDate)
	if err != nil {
		fmt.Println("设置 GIT_COMMITTER_DATE 失败:", err)
		return
	}
	err2 := os.Setenv("GIT_AUTHOR_DATE", sprintDate)
	if err2 != nil {
		fmt.Println("设置 GIT_AUTHOR_DATE 失败:", err)
		return
	}
	// 执行 git commit 命令
	commitCmd := exec.Command("git", "commit", "--date=\" "+sprintDate+"\"", "-am", "feat(go): add isValid")
	commitCmd.Stdout = os.Stdout
	commitCmd.Stderr = os.Stderr

	err = commitCmd.Run()
	if err != nil {
		fmt.Println("执行 git commit 失败:", err)
		return
	}

	// 执行 git push 命令
	pushCmd := exec.Command("git", "push")
	pushCmd.Stdout = os.Stdout
	pushCmd.Stderr = os.Stderr

	err = pushCmd.Run()
	if err != nil {
		fmt.Println("执行 git push 失败:", err)
		return
	}

	fmt.Println("所有命令执行成功！")
}
