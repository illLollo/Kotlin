interface Stack<E> : Iterable<E?>
{
    fun push(item : E?);
    fun pop() : E?;
    fun size(): Int;
    fun capacity(): Int

}