package gr.hua.dit.referenceLetterApp.controller;

import gr.hua.dit.referenceLetterApp.model.RecommendationReqLetter;
import gr.hua.dit.referenceLetterApp.service.ReqLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReqLetterRestController {
        @Autowired
        ReqLetterService reqLetterService;

        @GetMapping("/requests")
        public ResponseEntity<List<RecommendationReqLetter>> getAllReqLetters() {
            return ResponseEntity.ok().body(reqLetterService.findAllReqLetters());

        }

        @GetMapping("/requests/owned")
        @PostFilter("filterObject.createdBy==authentication.name")
        public List<RecommendationReqLetter> getReqLettersOwnedBy() {
            return reqLetterService.findAllReqLetters();

        }

        @PostMapping("/requests")
        public ResponseEntity<RecommendationReqLetter> saveReqLetter(@RequestBody RecommendationReqLetter newReqLetter, Authentication auth) {
            System.out.println((newReqLetter.getId()+1)+"  "+auth.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body((reqLetterService.saveReqLetter(newReqLetter)));

        }

        @GetMapping("/requests/createdBy/{id}")
        public ResponseEntity<RecommendationReqLetter> getReqLetterByCreatedId(@PathVariable("id") String createdBy) {
            return ResponseEntity.ok().body(reqLetterService.findReqLetterByCreatedBy(createdBy));

        }

        @GetMapping("/requests/sendTo/{id}")
        public ResponseEntity<RecommendationReqLetter> getReqLetterBySendId(@PathVariable("id") String sendTo) {
            return ResponseEntity.ok().body(reqLetterService.findReqLetterBySendTo(sendTo));

        }

        @PutMapping("/requests/{id}")
        public ResponseEntity<RecommendationReqLetter> updateReqLetter(@PathVariable("id")  String createdBy,@RequestBody RecommendationReqLetter newReqLetter) {
            return ResponseEntity.ok().body(reqLetterService.updateReqLetter(createdBy,newReqLetter));

        }

        @GetMapping("/request/email/{email}")
        public String sendEmail(@PathVariable (value="email")String email){

            return "";
        }
}
