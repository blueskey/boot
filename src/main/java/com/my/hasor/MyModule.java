package com.my.hasor;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.core.Module;
import org.springframework.stereotype.Component;

@DimModule
@Component
public class MyModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {

    }
}
