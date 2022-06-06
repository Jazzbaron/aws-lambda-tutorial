package com.nexer.tutorial.aws.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.lambda.LambdaClient;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;

/**
 * This class showcases a simple lambda function
 */
public class SimpleLambdaFunction implements RequestHandler<Void, String> {
  private static final Logger LOG = LoggerFactory.getLogger(SimpleLambdaFunction.class);
  private static final SdkHttpClient httpClient = ApacheHttpClient.builder().build();
  private LambdaClient lambdaClient;

  @Override
  public String handleRequest(Void input, Context context) {
    if (lambdaClient == null) {
      lambdaClient = LambdaClient.builder().httpClient(httpClient).build();
    }
    try {

      // TODO [Optional] (Before Workshop):
      // Modify Code to return input parameter from user
      String message = "Hello Nexer!";

      return message;

      // TODO (Workshop Day 1):
      //  Get account settings
      //  > Publish total lambda storage to CloudWatch
      //  > Publish current usage of lambda storage to CloudWatch
      //  > Publish Remaining usage of lambda storage to CloudWatch
      //  Hint: Use the commented out library GetAccountSettingsResponse together with the lambda client.
      //  you will also need an embeddedMetricsLoggerç

    } catch(Exception e) {
      LOG.error("Exception: could not greet world" + e);
    }
    return null;
  }

}