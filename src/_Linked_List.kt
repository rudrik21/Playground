fun main() {

//    Demonstration of Node
    var n1 = Node<Int>(1)
    var n2 = Node<Int>(2)
    var n3 = Node<Int>(3)
    n1.nextNode = n2
    n2.nextNode = n3

//    println("Demonstration of Node (1, 2, 3) n1 => $n1")


//    Appending using LinkedList
    var list = LinkedList<Int>()
    list.append(1)
    list.append(2)
    list.append(3)
    println(list)   //  1 -> 2 -> 3

    var afterNode = list.nodeAt(1)
    println("afterNode at idx 1 => ${afterNode?.value}")    //  1 => 2

    list.insert(7, afterNode)
    println(list)   //  1 -> 2 -> 7 -> 3

    afterNode = list.nodeAt(2)
    list.insert(8, afterNode)
    println(list)   //  1 -> 2 -> 7 -> 8 -> 3


    println(list.removeFirst())     //  2 -> 7 -> 8 -> 3
    println(list.removeLast())     //  2 -> 7 -> 8

    var removingNode = list.nodeAt(1 - 1) //  removing at index 1
    list.remove(removingNode)   //  remove node and update the list
    println(list)     //  2 -> 7 -> 8
}

data class Node<T>(var value: T, var nextNode: Node<T>? = null) {
    override fun toString(): String {
        return if (nextNode != null) {
            "$value -> $nextNode"
        } else {
            "$value"
        }
    }
}

class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0
        private set

    fun isEmpty() = (size == 0)
    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            "${head.toString()}"
        }
    }

    //    1 -> 2 -> 3   =>  3 -> 2 -> 1
    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    //    1 -> 2 -> 3   =>  1 -> 2 -> 3
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.nextNode = Node(value)    //  attaching tails
        tail = tail?.nextNode           //  making attached tail as end
        size++                          //  inc size
    }

    //    find node at index
    fun nodeAt(index: Int): Node<T>? {
        var curIdx = 0
        var curNode = head
        while (curIdx < index && curNode?.nextNode != null) {
            curNode = curNode.nextNode
            curIdx++
        }
        return curNode
    }

    //    Inserting value at afterNode
    fun insert(value: T, afterNode: Node<T>?) {
        tail = afterNode?.nextNode              //  take afterNode's next and make it tail
        afterNode?.nextNode = Node(value)       //  add value to the next of afterNode
        afterNode?.nextNode?.nextNode = tail    //  attaching the tail back to afterNode's next
    }

    //  Removing the first Node
    fun removeFirst(): LinkedList<T> {
        head = head?.nextNode
        size--
        return this
    }

    //  Removing the last node
    //  1 -> 2 -> 3
    fun removeLast(): LinkedList<T> {
        var curIdx = 0                  //  to keep track of curIdx
        var curNode = head              //  to keep track of curNode

        while (curIdx < size - 1) {       //  run until second last node
            curNode = curNode?.nextNode //  inc nodes/ traversing
            curIdx++                    //  inc curIdx
        }
        curNode?.nextNode = null        //  removing last node
        tail = curNode                  //  assigning new last node as tail
        size--
        return this
    }

    //    2 -> 7 -> 8 -> 3
    fun remove(node: Node<T>?) {
        val result = node?.nextNode?.value
//        println("Removing node ${node?.value}")
        if (node?.nextNode == tail) {
            tail = node
        }
        if (node?.nextNode != null) size--
        node?.nextNode = node?.nextNode?.nextNode
    }
}

