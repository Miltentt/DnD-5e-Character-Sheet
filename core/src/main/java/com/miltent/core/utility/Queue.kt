package com.miltent.core.utility

class Queue<T>(private val maxLimit: Int) {
    private val deque = ArrayDeque<T>()

    fun enqueue(element: T) {
        if (deque.size == maxLimit) {
            deque.removeFirst() // Remove oldest element
        }
        deque.addLast(element)
    }
}