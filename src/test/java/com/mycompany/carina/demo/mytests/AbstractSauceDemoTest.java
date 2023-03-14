package com.mycompany.carina.demo.mytests;

import com.mycompany.carina.demo.utils.AuthUtils;
import com.mycompany.carina.demo.utils.RandomUtils;
import com.qaprosoft.carina.core.foundation.IAbstractTest;

public abstract class AbstractSauceDemoTest implements IAbstractTest {
    protected RandomUtils randomUtils = new RandomUtils();

    protected AuthUtils authUtils = new AuthUtils();

}
