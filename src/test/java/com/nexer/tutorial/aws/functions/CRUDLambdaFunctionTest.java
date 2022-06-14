package com.nexer.tutorial.aws.functions;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CRUDLambdaFunctionTest {

    @Mock
    CRUDLambdaFunction crudLambdaFunction = new CRUDLambdaFunction();

    @BeforeClass
    public static void setupClass() {
    }

    @Test
    public void ShouldLogAccountSettingsTest() {
    }

    @Test
    public void TestRetrieveTables() {

     //   when(AmazonDynamoDB.listTables(any(ListTablesRequest.class))).thenReturn();

        //crudLambdaFunction.currentTablesInUse();
    }

}