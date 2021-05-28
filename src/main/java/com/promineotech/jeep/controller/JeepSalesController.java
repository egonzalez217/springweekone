package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jeep.entity.Jeep;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/jeeps")
@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server")
})
public interface JeepSalesController {
	//Formatter:off
	@Operation(
		summary = "Returns a list of Jeeps",
		description = "REturns a list of Jeeps given an optional model",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "List of jeeps returned",
							content = @Content(
									mediaType = "aplication/json", 
									schema = @Schema(
											implementation = Jeep.class))),
					@ApiResponse(
							responseCode = "400",
							description = "List of jeeps The request parameters are invalid"),
					@ApiResponse(
							responseCode = "404", 
							description = "No jeeps were found with the input criteria"),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured")

			},
			parameters = {
					@Parameter(
							name = "model",
							allowEmptyValue = false, 
							required = false, 
							description = "The model name (ex. 'WRANGLER')"),
					@Parameter(
							name = "trim", 
							allowEmptyValue = false, 
							required = false, 
							description = "Them tri level (ex. 'SPORT')"),
			})
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Jeep> fetchJeeps(
			@RequestParam(required = false) 
		String model, 
			@RequestParam(required = false)
		String trim);
	//@Formatter:on		
}
