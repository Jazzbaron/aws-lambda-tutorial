package com.nexer.tutorial.aws.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.lambda.LambdaClient;
//import software.amazon.awssdk.services.lambda.model.GetAccountSettingsResponse;

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

      String message = "Hello Nexer!";

      return message;

      // TODO [Optional] (Before Workshop):
      //  Modify Code to return input parameter from user

      // TODO (Workshop):
      //  Get account settings
      //  > Publish total lambda storage to CloudWatch
      //  > Publish current usage of lambda storage to CloudWatch
      //  > Publish Remaining usage of lambda storage to CloudWatch
      //  Hint: Use the commented out library GetAccountSettingsResponse together with the lambda client.
      //  you will also need an embeddedMetricsLogger
    } catch(Exception e) {
      LOG.error("Exception: could not greet world" + e);
    }
    return null;
  }
}