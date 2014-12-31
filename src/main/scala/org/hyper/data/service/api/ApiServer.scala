package org.hyper.data.service.api

import io.undertow.Undertow
import io.undertow.server.{HttpServerExchange, HttpHandler}
import io.undertow.util.Headers

object ApiServer {
  def main(args: Array[String]): Unit = {
    val server = Undertow.builder
      .addHttpListener(8080, "0.0.0.0")
      .setHandler(new HttpHandler {
      override def handleRequest(exchange: HttpServerExchange): Unit = {
        exchange.getResponseHeaders.put(Headers.CONTENT_TYPE, "text/plain")
        exchange.getResponseSender.send("Hello World")
      }
    }).build()
    server.start
  }
}