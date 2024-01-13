class StackDLA<E>(initialCapacity: Int) : Stack<E>
{
    var size: Int = 0
        private set
    var capacity: Int = initialCapacity
        private set

    private var buffer: Array<E?> = arrayOfNulls<Any>(this.capacity) as Array<E?>;

    constructor() : this(20)

    override fun pop(): E?
    {
        if (this.size == 0)
            throw StackOperationException("Stack Empty, cannot pop!")
        if (this.size < this.capacity / 2)
            shrink()

        return this.buffer[(this.size--) -1]
    }

    override fun size(): Int = this.size

    override fun capacity(): Int = this.capacity

    override fun push(item: E?)
    {
        if (size == capacity)
            expand()
        this.buffer[size++] = item;
    }
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is StackDLA<*>) return false
        if (this.size != other.size) return false

        for (i in 0 until this.size)
            //if (this.buffer[i] != other.buffer[i])
                return false

        return true
    }




    override fun iterator(): Iterator<E?> = buffer.iterator()
    private fun expand()
    {
        this.capacity += 20;
        this.buffer = this.buffer.copyOf(this.capacity)
        println("expandend")
    }
    private fun shrink()
    {
        this.capacity /= 2
        this.buffer = this.buffer.copyOf(this.capacity)
        println("shrinked")
    }

    override fun toString(): String
    {
        val sb: StringBuilder = StringBuilder("[")

        for (i: Int in this.size - 1 downTo 0)
            sb.append(if (i < this.size - 1) ", " else "").append(this.buffer[i])

        return sb.append("]").toString()
    }
}