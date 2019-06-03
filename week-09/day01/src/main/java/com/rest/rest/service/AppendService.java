package com.rest.rest.service;

import com.rest.rest.model.Append;
import org.springframework.stereotype.Service;

@Service
public class AppendService {
  public AppendService() {
  }

  public Object appendChar (String appendable) {
    Append myAppend = new Append();
    myAppend.setAppended(appendable + 'a');
    return myAppend;
  }
}
