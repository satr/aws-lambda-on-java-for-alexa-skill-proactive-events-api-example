package com.github.satr.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.SkillEnabledRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.events.skillevents.SkillEnabledRequest;
import org.slf4j.Logger;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/* Skill manifest should contain subscription to the event "SKILL_ENABLED"
    "events": {
      "endpoint": {
        "uri": "arn:aws:lambda:YOUR-FUNCTION"
      },
      "subscriptions": [
        { "eventName": "SKILL_ENABLED" }
      ]
    }
*/
public class CustomSkillEnabledRequestHandler implements SkillEnabledRequestHandler {
    private static Logger logger = getLogger(CustomSkillEnabledRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput input, SkillEnabledRequest skillEnabledRequest) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input, SkillEnabledRequest skillEnabledRequest) {
        logger.info("User has enabled the skill.");
        OffsetDateTime eventCreationTime = skillEnabledRequest.getEventCreationTime();
        OffsetDateTime eventPublishingTime = skillEnabledRequest.getEventPublishingTime();
        String userId = input.getRequestEnvelope().getContext().getSystem().getUser().getUserId();

        //Put handling code here

        return Optional.empty();
    }

}

