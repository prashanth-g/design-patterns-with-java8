package com.prashanth.os.design.patterns.registry.model;

import com.prashanth.os.design.patterns.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);

}
