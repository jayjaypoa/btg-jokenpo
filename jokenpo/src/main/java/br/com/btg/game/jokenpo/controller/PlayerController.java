package br.com.btg.game.jokenpo.controller;

import br.com.btg.game.jokenpo.dto.api.ApiResponse;
import br.com.btg.game.jokenpo.dto.player.PlayerRequest;
import br.com.btg.game.jokenpo.exception.JokenpoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    @PostMapping(value = "")
    public ResponseEntity<Object> insert(@Valid @RequestBody PlayerRequest playerRequest)
            throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>("SUCESSO"));
    }

}
