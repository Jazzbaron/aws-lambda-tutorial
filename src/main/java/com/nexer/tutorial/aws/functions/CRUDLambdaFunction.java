package com.nexer.tutorial.aws.functions;

import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class CRUDLambdaFunction implements RequestHandler<Void, String> {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleLambdaFunction.class);
    private static final SdkHttpClient httpClient = ApacheHttpClient.builder().build();
    private AmazonDynamoDB ddb;

    @Override
    public String handleRequest(Void input, Context context) {
        if (ddb == null) {
            ddb = AmazonDynamoDBClientBuilder.defaultClient();
        }

        // For querying database, initialize dynamoDB client:
        // DynamoDB dynamoDB = new DynamoDB(ddb);
        // dynamoDB.getTable("");
        // ...

        try {

            // TODO (Workshop Day 2):
            // Task 1: Get the total table count of your account (should be 1).
            // Use the currentTablesInUse method to do this.
            // Make sure the table is created! Check the SAM cloudformation template and Management Console.
            // You will need to setup the lambda function in template.yml and API in api.yml
            // Use SimpleLambdaFunction as inspiration

            // Task 2: Querying "myDynamoDBTable" (the one we created)
            // Read a record
            // Create a record
            // Delete a record

            // Task 3: Create CRUD-operation APIs' for each operation

        } catch(Exception e) {
            LOG.error("Exception: Could not check for account settings: " + e);
        }
        return null;
    }

    // TODO (Workshop 2) fill in the missing part of the method stub:
    // Hint: More reading on the ListTable API -- https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_ListTables.html
    public int currentTablesInUse() {
        int tableCount = 0;
        String lastEvaluatedTableName = null;

        do {
            // Create a new request:
            ListTablesRequest request = new ListTablesRequest()
                    .withExclusiveStartTableName(lastEvaluatedTableName);

            // Get all the tables:
            // ...

            // Count them:
            // ...

        } while (lastEvaluatedTableName != null);

        return tableCount;
    }
}
