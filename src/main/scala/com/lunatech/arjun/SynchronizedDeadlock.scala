package com.lunatech.arjun

object SynchronizedDeadlock extends App {
  class Account(val name: String, var money: Int)
  def send(a: Account, b: Account, n: Int) = a.synchronized {
    b.synchronized {
      a.money -= n
      b.money += n
    }
  }
  val a = new Account("Jack", 1000)
  val b = new Account("Jill", 2000)
  val t1 = new Thread {
    override def run() = for (_ <- 0 until 100) send(a, b, 1)
  }
  t1.start()
  val t2 = new Thread {
    override def run() = for (_ <- 0 until 100) send(b, a, 1)
  }
  t2.start()
  t1.join(); t2.join()
  println(s"a = ${a.money}, b = ${b.money}")
}
