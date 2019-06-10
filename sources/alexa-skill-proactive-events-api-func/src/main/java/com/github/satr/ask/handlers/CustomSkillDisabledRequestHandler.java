package com.github.satr.ask.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.SkillDisabledRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.events.skillevents.SkillDisabledRequest;
import org.slf4j.Logger;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/* Skill manifest should contain subscription to the event "SKILL_DISABLED"
    "events": {
      "endpoint": {
        "uri": "arn:aws:lambda:YOUR-FUNCTION"
      },
      "subscriptions": [
        { "eventName": "SKILL_DISABLED" }
      ]
    }
*/
public class CustomSkillDisabledRequestHandler implements SkillDisabledRequestHandler {
    private static Logger logger = getLogger(CustomSkillDisabledRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput input, SkillDisabledRequest skillDisabledRequest) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input, SkillDisabledRequest skillDisabledRequest) {
        logger.info("User has disabled the skill.");
        OffsetDateTime eventCreationTime = skillDisabledRequest.getEventCreationTime();
        OffsetDateTime eventPublishingTime = skillDisabledRequest.getEventPublishingTime();
        String userId = input.getRequestEnvelope().getContext().getSystem().getUser().getUserId();

        //Put handling code here

        return Optional.empty();
    }

}
