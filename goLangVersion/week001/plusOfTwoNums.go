package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	var l1 = new(ListNode)
	var l2 = new(ListNode)
	var tmp1 = l1
	var tmp2 = l2
	l1.Val = 9
	l2.Val = 4

	for i := 0; i < 10; i++ {
		tmp1.Next = new(ListNode)
		tmp1 = tmp1.Next
		tmp1.Val = i

		tmp2.Next = new(ListNode)
		tmp2 = tmp2.Next
		tmp2.Val = i
	}

	sun := addTwoNumbers(l1, l2)

	for sun != nil {
		fmt.Print(sun.Val)
		sun = sun.Next
	}

}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := new(ListNode)
	cur := head
	futher := false //是否存在进位
	sum := 0

	for l1 != nil && l2 != nil {
		if futher {
			sum = l1.Val + l2.Val + 1
			futher = false
		} else {
			sum = l1.Val + l2.Val
		}
		if sum >= 10 {
			futher = true
			sum -= 10
		}

		l1 = l1.Next
		l2 = l2.Next
		curNode := new(ListNode)
		curNode.Val = sum
		cur.Next = curNode
		cur = cur.Next
	}

	for l1 != nil {
		if futher {
			sum = l1.Val + 1
			futher = false
		} else {
			sum = l1.Val
		}
		if sum >= 10 {
			futher = true
			sum -= 10
		}
		l1 = l1.Next
		curNode := new(ListNode)
		curNode.Val = sum
		cur.Next = curNode
		cur = cur.Next
	}

	for l2 != nil {
		if futher {
			sum = l2.Val + 1
			futher = false
		} else {
			sum = l2.Val
		}
		if sum >= 10 {
			futher = true
			sum -= 10
		}
		l2 = l2.Next
		curNode := new(ListNode)
		curNode.Val = sum
		cur.Next = curNode
		cur = cur.Next
	}

	if futher {
		curNode := new(ListNode)
		curNode.Val = 1
		cur.Next = curNode
		cur = cur.Next
	}

	return head.Next
}
