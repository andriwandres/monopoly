package ch.pureguys.monopoly;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/demo" )
public class DemoApi
{
	@GetMapping()
	public String hello ()
	{
		return "Hello World!";
	}
}
