package message_instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messaging", produces = "application/json")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody MessageInstance message) {
        messageRepository.save(message);

        return ResponseEntity.status(HttpStatus.OK).body("Posted");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity put(@RequestBody MessageInstance message) {
        messageRepository.save(message);

        return ResponseEntity.status(HttpStatus.OK).body("Edited");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestBody MessageInstance message) {
        messageRepository.delete(message);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

}
