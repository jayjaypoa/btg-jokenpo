package br.com.btg.game.jokenpo.controller;

import br.com.btg.game.jokenpo.dto.api.ApiResponse;
import br.com.btg.game.jokenpo.dto.PlayerRequest;
import br.com.btg.game.jokenpo.exception.JokenpoException;
import br.com.btg.game.jokenpo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> insert(@Valid @RequestBody PlayerRequest playerRequest)
            throws JokenpoException {
        return ResponseEntity.ok(
                new ApiResponse<>(this.playerService.insert(playerRequest)));
    }

    @DeleteMapping(value = "{name}")
    public ResponseEntity<Object> delete(@PathVariable String name) throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>(this.playerService.deleteByName(name)));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>(this.playerService.getAll()));
    }

}
