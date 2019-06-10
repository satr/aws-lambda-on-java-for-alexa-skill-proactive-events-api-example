package com.github.satr.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.PermissionAcceptedRequestHandler;
import com.amazon.ask.dispatcher.request.handler.impl.PermissionChangedRequestHandler;
import com.amazon.ask.dispatcher.request.handler.impl.SkillEnabledRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Session;
import com.amazon.ask.model.User;
import com.amazon.ask.model.events.skillevents.*;
import org.slf4j.Logger;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/* Skill manifest should contain subscription to the event "SKILL_PERMISSION_ACCEPTED"
    "events": {
      "endpoint": {
        "uri": "arn:aws:lambda:YOUR-FUNCTION"
      },
      "subscriptions": [
        { "eventName": "SKILL_PERMISSION_ACCEPTED" }
      ]
    }
*/
public class CustomPermissionAcceptedRequestHandler implements PermissionAcceptedRequestHandler {
    private static Logger logger = getLogger(CustomPermissionAcceptedRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput input, PermissionAcceptedRequest permissionAcceptedRequest) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input, PermissionAcceptedRequest permissionAcceptedRequest) {
        logger.info("User has accepted permission(s).");
        PermissionBody requestBody = permissionAcceptedRequest.getBody();
        List<Permission> acceptedPermissions = requestBody != null ? requestBody.getAcceptedPermissions() : new ArrayList<>();
        OffsetDateTime eventCreationTime = permissionAcceptedRequest.getEventCreationTime();
        OffsetDateTime eventPublishingTime = permissionAcceptedRequest.getEventPublishingTime();
        String userId = input.getRequestEnvelope().getContext().getSystem().getUser().getUserId();

        //Put handling code here

        return Optional.empty();
    }
}

