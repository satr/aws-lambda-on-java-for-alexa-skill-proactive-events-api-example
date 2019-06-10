package com.github.satr.ask.handlers;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

/* Skill manifest should contain subscription to the events, with needed proactive events in "publications"
    "permissions": [{"name": "alexa::devices:all:notifications:write"}],
    "events": {
      "publications": [
        { "eventName": "AMAZON.OrderStatus.Updated" },
        { "eventName": "AMAZON.MediaContent.Available" }
      ],
      "endpoint": {
        "uri": "arn:aws:lambda:YOUR-FUNCTION"
      },
      "subscriptions": [
        { "eventName": "SKILL_ENABLED" },
        { "eventName": "SKILL_DISABLED" },
        { "eventName": "SKILL_PERMISSION_ACCEPTED" },
        { "eventName": "SKILL_PERMISSION_CHANGED" },
        { "eventName": "SKILL_PROACTIVE_SUBSCRIPTION_CHANGED" }
      ]
    }
*/
// Main Lambda handler class for an Alexa skill example.
// Put to the Handler field:
//   com.github.satr.ask.handlers.SimpleAlexaSkillStreamHandler::handleRequest
// the method "handleRequest" is implemented in the super-class "SkillStreamHandler"
public class SimpleAlexaSkillStreamHandler extends SkillStreamHandler {

    public SimpleAlexaSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandler(new WelcomeRequestHandler())
                .addRequestHandler(new CustomLaunchRequestHandler())
                .addRequestHandler(new CustomProactiveSubscriptionChangedRequestHandler())
                .addRequestHandler(new CustomSkillEnabledRequestHandler())
                .addRequestHandler(new CustomSkillDisabledRequestHandler())
                .addRequestHandler(new CustomPermissionAcceptedRequestHandler())
                .addRequestHandler(new CustomPermissionChangedRequestHandler())
                .addRequestHandler(new CustomLaunchRequestHandler())
                .build());
    }
}
