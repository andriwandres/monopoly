package ch.pureguys.monopoly;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.pureguys.monopoly.domain.User;
import ch.pureguys.monopoly.repository.impl.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping( "/demo" )
@RequiredArgsConstructor
public class DemoApi
{
	private final UserRepository userRepository;

	@GetMapping()
	public String hello ()
	{
		List<User> all = userRepository.findAll();

		System.out.println( all );

		User user = User.builder().name( "Test" ).build();

		userRepository.save( user );
		return "Hello World!";
	}
}
