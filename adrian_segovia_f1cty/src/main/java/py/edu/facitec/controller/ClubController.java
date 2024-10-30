package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Club;

import py.edu.facitec.repository.ClubRepository;


@RestController
@RequestMapping("base")
public class ClubController {
	@Autowired
	private ClubRepository clubRepository;

	@GetMapping("/club/registrar")
	public ResponseEntity<List<Club>> getClub(){
		List<Club> clubs = clubRepository.findAll();
		System.out.println("Ingrese a Club");
		return new ResponseEntity<List<Club>>(clubs, HttpStatus.OK);
	}

	@PostMapping("/club/registrar")
	public ResponseEntity<Club> saveBlub(@RequestBody Club club){

		System.out.println("Ingresé en registrar agendas: "+club.toString()

				);

		try {
			Club clubRegistrado = clubRepository.save(club);
			return new ResponseEntity<>(clubRegistrado, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/clubs/lista")
	public ResponseEntity<Club> getClub(@PathVariable("club") Integer codigo){

		System.out.println("Ingresé!");

		Optional<Club> retornoConsulta = clubRepository.findById(codigo);

		if (retornoConsulta.isPresent()) {
			return new ResponseEntity<Club>(retornoConsulta.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	}

