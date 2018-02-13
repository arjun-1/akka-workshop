package com.lunatech.arjun

import scala.concurrent._
object ExecutorsCreate extends App {
  val executor = new forkjoin.ForkJoinPool
  executor.execute(
    new Runnable {
      def run() = println("This task is run asynchronously.")
    }
  )
  Thread.sleep(500)
}