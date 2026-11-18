package com.backend.service.modules.people;

import com.backend.service.kernel.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "*")
public class PeopleController {

    private final PeopleServices peopleServices;

    public PeopleController(PeopleServices peopleServices) {
        this.peopleServices = peopleServices;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> obtenerPerson() {
        return ResponseEntity.ok(
                new ApiResponse("Personas", peopleServices.obtenerTodos(), false, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> registrarPerson(@RequestBody Person person) {

        Person registrada = peopleServices.registrar(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Persona registrada", registrada, false, HttpStatus.CREATED));
    }
}
