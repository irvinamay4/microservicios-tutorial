package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.modelos.Carro;

//Se llama al microservicio y se agrega el request mapping de acceso
@FeignClient(name = "carro-service", url = "http://localhost:8082")
@RequestMapping("/carro")
public interface CarroFeignClient {
	
	//Para guardarlo
	@PostMapping()
	public Carro save(@RequestBody Carro carro);
	
	//Para obtenerlo
	@GetMapping("/usuario/{usuarioId}")
	public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
