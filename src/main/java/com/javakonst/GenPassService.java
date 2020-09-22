package com.javakonst;

import java.util.Set;

public interface GenPassService {
    public void setConfigPassGenerator(PassConfig passConfig);

    public String getSinglePass();
    public Set<String> getPassList();

}
