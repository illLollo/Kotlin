class Persona(age: Int, name: String, surname: String)
{
    var age: Int = age
        set(value)
        {
            if (field > 0)
                field = value;
        }
    var name: String = name
    var surname: String = surname
}