package com.lunatech.arjun

import akka.actor.{Actor, ActorSystem}
import akka.actor.Props
import com.lunatech.arjun.TestActor.Timeout
import com.lunatech.arjun.TimerActor.Register

import scala.concurrent.Await
import scala.concurrent.duration._

class TimerActor extends Actor {
  implicit val ec = context.system.dispatcher

  override def receive = {
    case Register(t) =>
      println(s"REGISTER MESSAGE (timeout = $t) from $sender")
      context.system.scheduler.scheduleOnce(t, sender, Timeout)
  }
}

object TimerActor {
  case class Register(t: FiniteDuration)
  def props = Props(new TimerActor)
}

class TestActor(t: FiniteDuration) extends Actor {
  val timerActor = context.actorOf(TimerActor.props, name = "TimerActor")
  timerActor ! Register(t)

  override def receive = {
    case Timeout => println(s"TIMEOUT MESSAGE from $sender")
  }
}

object TestActor {
  case object Timeout
  def props(t: FiniteDuration) = Props(new TestActor(t))
}

object TimerActorExercise extends App {

  val system = ActorSystem()
  val testActor = system.actorOf(TestActor.props(10 seconds), "TestActor")

  Thread.sleep(12000)
  Await.result(system.terminate(), 10 seconds)

}
