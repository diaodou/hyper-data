package org.hyper.data.service.api

import org.json4s.DefaultFormats
import org.json4s.native.Serialization._
import unfiltered.netty.cycle

import unfiltered.request._
import unfiltered.response._
import unfiltered.directives._
import unfiltered.directives.Directives._
import unfiltered.netty._

object UserIntent extends MemDomainModel {
  implicit val fmt = DefaultFormats

  def intent = Directive.Intent.Path {
    case Seg(List("api", "users")) =>
      for {
        _ <- GET
//        _ <- Accepts.Json
      } yield {
        println("go here")
        Ok ~> JsonContent ~> ResponseString(write(userRepo.list))
      }
  }
}

object ApiServer {
  def main(args: Array[String]): Unit = {
    val plan = cycle.Planify(UserIntent.intent)
    Http(8080).plan(plan).run
  }
}