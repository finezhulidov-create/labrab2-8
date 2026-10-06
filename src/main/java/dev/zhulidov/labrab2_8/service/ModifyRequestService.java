package dev.zhulidov.labrab2_8.service;

import dev.zhulidov.labrab2_8.model.Request;

public interface ModifyRequestService {
     void modify(Request request);
    void modify(Request request, Long time);
}
