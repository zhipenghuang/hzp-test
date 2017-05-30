package com.springmvc.utils;

import java.io.Serializable;

public class AbstractEntity implements Serializable {
    protected static long serialVersionUID = 1L;

    public AbstractEntity() {
    }

    public <T> T copyTo(Class<T> to) throws Exception {
        Object obj = ObjectCopy.copyTo(this, to);
        return (T) obj;
    }
}