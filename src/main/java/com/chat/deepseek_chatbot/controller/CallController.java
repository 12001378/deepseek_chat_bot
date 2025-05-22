package com.chat.deepseek_chatbot.controller;

import com.twilio.type.Twiml;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CallController {

    @GetMapping("/call_home")
    public String callHome(){
        return "Call_home welcomes You !";
    }

    @PostMapping("/call")
    public ResponseEntity<Call> aiVoice(){

        Twilio.init("AC8554dae1a9278573f9d1d406e2313440", "2aa121490188258c664956afa7227c0a");
        Call call = Call.creator(new com.twilio.type.PhoneNumber("+33753333839"),
                        new com.twilio.type.PhoneNumber("+13365710617"),
                        new com.twilio.type.Twiml("<Response><Gather numDigits=\"1\" action=\"https://your-server.com/handle-choice\">" +
                        "<Say>Welcome to XYZ Company! Press 1 to opt for our premium service. Press 2 for support.</Say></Gather>" +
                        "<Say>We didn't receive any input. Goodbye!</Say></Response>")).create();

        System.out.println(call.getSid());

        return ResponseEntity.ok(call);
    }
}
