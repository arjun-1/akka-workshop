package com.lunatech.arjun

object ThreadsSleep extends App {

  val t = new Thread {
    override def run() = {
      Thread.sleep(1000)
      println("New thread running.")
      Thread.sleep(1000)
      println("Still running.")
      Thread.sleep(1000)
      println("Completed.")
    }
  }
  t.start()
  t.join()
  println("New thread joined.")
}

