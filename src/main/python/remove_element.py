def remove_element(nums:[], val:int):
    fast = 0
    slow = 0
    for index in range(len(nums)):
        if nums[fast] is not val:
            nums[slow] = nums[fast]
            slow += 1
        fast += 1
    return slow


if __name__ == '__main__':
    print(remove_element([2, 3, 4, 2, 6], 2))
