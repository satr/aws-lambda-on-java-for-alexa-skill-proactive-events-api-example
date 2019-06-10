package com.github.satr.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.ProactiveSubscriptionChangedRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.events.skillevents.ProactiveSubscriptionChangedBody;
import com.amazon.ask.model.events.skillevents.ProactiveSubscriptionChangedRequest;
import com.amazon.ask.model.events.skillevents.ProactiveSubscriptionEvent;
import org.slf4j.Logger;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class CustomProactiveSubscriptionChangedRequestHandler implements ProactiveSubscriptionChangedRequestHandler {
    private static Logger logger = getLogger(CustomProactiveSubscriptionChangedRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput input, ProactiveSubscriptionChangedRequest proactiveSubscriptionChangedRequest) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input, ProactiveSubscriptionChangedRequest proactiveSubscriptionChangedRequest) {
        logger.info("User has changed subscription to proactive event(s).");
        logger.info("UserId: " + getUserId(input));
        logSubscriptionList(proactiveSubscriptionChangedRequest);
        logger.info("Request: " + input.getRequestEnvelopeJson());
        return Optional.empty();
    }

    private String getUserId(HandlerInput input) {
        //there is no session - take a user-id from the context-system
        return input.getRequestEnvelope().getContext().getSystem().getUser().getUserId();
    }

    private void logSubscriptionList(ProactiveSubscriptionChangedRequest proactiveSubscriptionChangedRequest) {
        ProactiveSubscriptionChangedBody requestBody = proactiveSubscriptionChangedRequest.getBody();
        if(requestBody == null) {
            //when there is no subscriptions to any events - the request-body is null
            logger.info("No subscriptions");
            return;
        }
        //The string contains a list of subscribed event-names, separated by new-lines
        String subscriptionList = requestBody.getSubscriptions().stream()
                                                                .map(ProactiveSubscriptionEvent::getEventName)
                                                                .collect(Collectors.joining("\n"));
        logger.info("User subscriptions:\n" + subscriptionList);
    }
}
