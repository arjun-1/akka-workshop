package com.lunatech.arjun


object ThreadsProtectedUid extends App {
  var uidCount = 0L


  def getUniqueId() = this.synchronized {
    val freshUid = uidCount + 1
    uidCount = freshUid
    freshUid
  }
  def printUniqueIds(n: Int): Unit = {
    val uids = for (_ <- 0 until n) yield getUniqueId()
    println(s"Generated uids: $uids")
  }
  val t = new Thread {
    override def run() = printUniqueIds(5)
  }
  t.start()
  printUniqueIds(5)
  t.join()
}