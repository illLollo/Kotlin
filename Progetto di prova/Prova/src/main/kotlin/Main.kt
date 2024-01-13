fun main(args: Array<String>) : Unit
{
    val p: CentralPoint = CentralPoint(10.0, 11.1);
    p.y = 0.0

    p.operazionePunto(Point(1.0, 20.0)) { lhs: Point, rhs: Point -> Point(lhs.x + rhs.x, lhs.y + rhs.y) }

    val per: Persona = Persona(17, "Lorenzo", "Gambaro");

    //println(per.getCompleteName())

    var st: StackDLA<Int> = StackDLA(2);

    st.push(10)
    st.push(12)
    st.push(123)
    st.push(123)
    st.push(123)

    println(st.size)

    println(st)

}
open class Point(xin: Double, yin: Double)
{
    var x: Double = xin
        get() = field + 10
        set(value: Double)
        {
            field = 0.0
        }
    var y: Double = yin
            get() = field
            set(value: Double)
            {
                field = 0.0
            };
}
class CentralPoint(xin: Double, yin: Double) : Point(xin, yin)
{
    val center: Point = Point(xin, yin)

    fun operazionePunto(other: Point, function: (Point, Point) -> Point): Point
    {
        return function(this.center, other);
    }
}
