package com.nexer.tutorial.aws.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class AddSQSMessageLambdaFunction implements RequestHandler<Void, Void> {
        private static final Logger LOG = LoggerFactory.getLogger(SimpleLambdaFunction.class);
        private static final SdkHttpClient httpClient = ApacheHttpClient.builder().build();

        private static final String QUEUE_URL = "https://sqs.eu-north-1.amazonaws.com/<your_queue_ARN>/tutorial-eu-alt-aws-tutorial-queue";

        @Override
        public Void handleRequest(Void input, Context context) {

            final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

            // Add message to queue (example):
            SendMessageRequest send_msg_request = new SendMessageRequest()
                    .withQueueUrl(QUEUE_URL)
                    .withMessageBody("Hello Nexer!")
                    .withDelaySeconds(5);
            sqs.sendMessage(send_msg_request);

            // TODO Workshop 3: Delete message from queue

            return null;
        }
}
