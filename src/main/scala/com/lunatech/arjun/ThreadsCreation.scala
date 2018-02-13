package com.lunatech.arjun

object ThreadsCreation extends App {
  class MyThread extends Thread {
    override def run(): Unit = {
      println("New thread running.")
    } }
  val t = new MyThread
  val name = t.getName
  println(s"I am the thread $name")
  t.start()
  t.join()
  println("New thread joined.")
}