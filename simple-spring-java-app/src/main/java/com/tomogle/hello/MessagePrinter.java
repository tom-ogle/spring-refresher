package com.tomogle.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

  final private MessageService service;

  @Autowired
  public MessagePrinter(final MessageService service) {
    this.service = service;
  }

  public void printMessage() {
    System.out.println(this.service.getMessage());
  }
}
