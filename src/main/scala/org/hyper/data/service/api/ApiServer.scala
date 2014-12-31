package org.hyper.data.service.api

object ApiServer {
  def main(args: Array[String]): Unit = {
    val server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(new HttpHandler() {
      @Override
      public void handleRequest(final HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
      }
    }).build();
    server.start();
  }
}