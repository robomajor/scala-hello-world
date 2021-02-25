package example

object Main extends App {
  val ages = Seq(42, 61, 29, 64)
  println("Hello World")
  println(s"The oldest person is ${ages.max}")

  val fruits = List("apple", "banana", "lime", "orange")

  val fruitLengths = for {
    f <- fruits
    if f.length > 4
  } yield f.length

  println(fruitLengths)

  val p = new Person("Julia", "Kern")
  println(p.firstName)
  p.lastName = "Manes"
  p.printFullName()

  def sum(a: Int, b: Int) = a + b
  def concatenate(s1: String, s2: String) = s1 + s2

  val x = sum(1, 2)
  val y = concatenate("foo", "bar")

  println(x)
  println(y)

  val dogo = new Dog("Pimpek")
  println(dogo.speak())
  dogo.startRunning()

  //populating lists
  val nums2 = List.range(0, 10)
  val nums = (1 to 10 by 2).toList
  val letters = ('a' to 'f').toList
  val letters2 = ('a' to 'f' by 2).toList
  val names = List("joel", "ed", "chris", "maurice")

  names.foreach(println)
  nums.filter(_ < 4).foreach(println)

  val doubles = nums.map(_ * 2)
  val capNames = names.map(_.capitalize)
  val lessThanFive = nums.map(_ < 5)

  println(doubles)
  println(capNames)
  println(lessThanFive)

  println(nums.foldLeft(0)(_ + _))
  println(nums.foldLeft(1)(_ * _))

  val t = (11, "Eleven", new Person("Eleven", "Names"))
  t._1



}

class Person(var firstName: String, var lastName: String) {
  def printFullName(): Unit = println(s"$firstName $lastName")
}

trait Speaker {
  def speak(): String  // has no body, so it’s abstract
}

trait TailWagger {
  def startTail(): Unit = println("tail is wagging")
  def stopTail(): Unit = println("tail is stopped")
}

trait Runner {
  def startRunning(): Unit = println("I’m running")
  def stopRunning(): Unit = println("Stopped running")
}

class Dog(name: String) extends Speaker with TailWagger with Runner {
  def speak(): String = s"Woof! - says dog named $name"
}

class Cat extends Speaker with TailWagger with Runner {
  def speak(): String = "Meow"
  override def startRunning(): Unit = println("Yeah ... I don’t run")
  override def stopRunning(): Unit = println("No need to stop")
}