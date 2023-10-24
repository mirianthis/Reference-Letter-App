package gr.hua.dit.referenceLetterApp.controller;

import gr.hua.dit.referenceLetterApp.model.ThirdParty;
import gr.hua.dit.referenceLetterApp.service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ThirdPartyRestController {
        @Autowired
        ThirdPartyService thirdPartyService;

        @GetMapping("/thirdparty")
        public ResponseEntity<List<ThirdParty>> getAllThirdParties() {
            return ResponseEntity.ok().body(thirdPartyService.findAllThirdParties());

        }

        @PostMapping("/thirdparty")
        public ResponseEntity<ThirdParty> saveThirdParty(@RequestBody ThirdParty newThirdParty, Authentication auth) {
            System.out.println(newThirdParty.getName()+"  "+auth.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body((thirdPartyService.saveThirdParty(newThirdParty)));

        }

        @GetMapping("/thirdparty/{id}")
        public ResponseEntity<ThirdParty> getThirdPartyByField(@PathVariable("id") String field) {
            return ResponseEntity.ok().body(thirdPartyService.findThirdPartyByField(field));

        }




}
