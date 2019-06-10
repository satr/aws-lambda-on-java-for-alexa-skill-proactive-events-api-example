package com.github.satr.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.PermissionChangedRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Session;
import com.amazon.ask.model.User;
import com.amazon.ask.model.events.skillevents.Permission;
import com.amazon.ask.model.events.skillevents.PermissionBody;
import com.amazon.ask.model.events.skillevents.PermissionChangedRequest;
import org.slf4j.Logger;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/* Skill manifest should contain subscription to the event "SKILL_PERMISSION_CHANGED"
    "events": {
      "endpoint": {
        "uri": "arn:aws:lambda:YOUR-FUNCTION"
      },
      "subscriptions": [
        { "eventName": "SKILL_PERMISSION_CHANGED" }
      ]
    }
*/
public class CustomPermissionChangedRequestHandler implements PermissionChangedRequestHandler {
    private static Logger logger = getLogger(CustomPermissionChangedRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput input, PermissionChangedRequest permissionChangedRequest) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input, PermissionChangedRequest permissionChangedRequest) {
        logger.info("User has changed permission(s).");
        PermissionBody requestBody = permissionChangedRequest.getBody();
        List<Permission> acceptedPermissions = requestBody != null ? requestBody.getAcceptedPermissions() : new ArrayList<>();
        OffsetDateTime eventCreationTime = permissionChangedRequest.getEventCreationTime();
        OffsetDateTime eventPublishingTime = permissionChangedRequest.getEventPublishingTime();
        String userId = input.getRequestEnvelope().getContext().getSystem().getUser().getUserId();

        //Put handling code here

        return Optional.empty();
    }
}
