package com.lunatech.arjun

import akka.actor.{Actor, ActorRef}
import com.lunatech.arjun.AccountActorExercise.AccountActor.Send

object AccountActorExercise extends App {

  class AccountActor(val name: String, var money: Double) extends Actor {
    override def receive: Receive = {
      case Send(to, amount) => {
        money = money - amount

      }

    }
  }

  object AccountActor {
    case class Send(to: ActorRef, amount: Double)
  }
}
