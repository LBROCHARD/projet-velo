package com.formation.velo.controllers;

import com.formation.velo.model.Compost;
import com.formation.velo.model.User;
import com.formation.velo.service.CompostService;
import com.formation.velo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class CompostController {
    private final CompostService compostService;

	public CompostController(CompostService compostService) {
		this.compostService = compostService;
	}


	@GetMapping("composts")
	public ResponseEntity<List<Compost>> getAll(){
		List<Compost> composts = compostService.findAll();

		return ResponseEntity.ok(composts);
	}

	@GetMapping("composts/{id}")
	public ResponseEntity<Optional<Compost>> getCompostById(@PathVariable Integer id){
		Optional<Compost> composts = compostService.findById(id);
		
		return ResponseEntity.ok(composts);
	}

	@DeleteMapping("composts/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		compostService.deleteById(id);
		return ResponseEntity.ok("deleted");
	}

	@PostMapping("composts/update")
	public ResponseEntity<String> update(@RequestBody Compost compost){
		compostService.save(compost);
		return ResponseEntity.ok("updated");
	}
}
