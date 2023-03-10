package com.mycompany.carina.demo.mytests;

import com.mycompany.carina.demo.api.dummyjson.DeleteProductMethod;
import com.mycompany.carina.demo.api.dummyjson.GetProductMethods;
import com.mycompany.carina.demo.api.dummyjson.PostProductMethod;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class APITests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateProduct() throws Exception {
        PostProductMethod api = new PostProductMethod();
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetProducts() {
        GetProductMethods getProductMethods = new GetProductMethods();
        getProductMethods.callAPIExpectSuccess();
        getProductMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteProducts() {
        DeleteProductMethod deleteProductMethod = new DeleteProductMethod();
        deleteProductMethod.callAPIExpectSuccess();
    }
}
