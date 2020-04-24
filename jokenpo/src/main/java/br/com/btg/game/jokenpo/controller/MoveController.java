package br.com.btg.game.jokenpo.controller;

import br.com.btg.game.jokenpo.dto.MoveRequest;
import br.com.btg.game.jokenpo.dto.api.ApiResponse;
import br.com.btg.game.jokenpo.exception.JokenpoException;
import br.com.btg.game.jokenpo.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/move")
@CrossOrigin(origins = "*")
public class MoveController {

    private MoveService moveService;

    @Autowired
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> insert(@Valid @RequestBody MoveRequest moveRequest)
            throws JokenpoException {
        return ResponseEntity.ok(
                new ApiResponse<>(this.moveService.insert(moveRequest)));
    }
/*
    @DeleteMapping(value = "{playerName}")
    public ResponseEntity<Object> delete(@PathVariable String playerName) throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>(this.moveService.deleteByPlayerName(playerName)));
    }
*/

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>(this.moveService.getAll()));
    }

}
