package com.lunatech.arjun

object ThreadsNondeterminism extends App {
  val t = new Thread {
    override def run() = {
      println("New thread running.")
    }
  }
  t.start()
  println("...")
  println("...")
  t.join()
  println("New thread joined.")
}