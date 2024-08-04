public class Person
{
    String name;
    int age;
    long salary;
    public Person(String name,int age,long salary)
    {
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public String toString()
    {
        return "name :"+name+" age :"+age+" salary :"+salary;
    }

}