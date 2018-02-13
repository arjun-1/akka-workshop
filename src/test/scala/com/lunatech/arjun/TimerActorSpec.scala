package com.lunatech.arjun

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import com.lunatech.arjun.TestActor.Timeout
import com.lunatech.arjun.TimerActor.Register
import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpecLike

import scala.concurrent.duration._

class TimerActorSpec extends TestKit(ActorSystem()) with ImplicitSender with WordSpecLike with BeforeAndAfterAll {

  "foo" should {
    "bla" in {
      val timer = system.actorOf(TimerActor.props)
      timer ! Register(10 seconds)
      within(9.9 seconds, 10.1 seconds) {
        expectMsg(Timeout)
      }
    }
  }

}
