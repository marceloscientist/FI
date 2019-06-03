package br.senai.sc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Cliente;
import br.senai.sc.domain.Festa;
import br.senai.sc.domain.Tema;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.repositories.FestaRepository;
import br.senai.sc.repositories.TemaRepository;

@SpringBootApplication
public class FestasInfantisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FestasInfantisApplication.class, args);
	}
	
	@Autowired
	private ClienteRepository cliR;
	
	@Autowired
	private FestaRepository fesR;
	
	@Autowired
	private TemaRepository temR;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
		
		Cliente c1 = new Cliente(null, "João", 123456789);

		Tema t1 = new Tema(null, "Frozen", "Azul", "600");
		t1.getItens().add("Cosplay");
		t1.getItens().add("Bolo");
		
		Festa f1 = new Festa(null, "Rua gelada, nº 123", sdf.parse("22/04/2019"), stf.parse("20:36:30"), stf.parse("23:36:30"), 500.00, t1, c1);
		c1.getFestas().add(f1);
		t1.getFestas().add(f1);
		
		
		cliR.save(c1);
		temR.save(t1);
		fesR.save(f1);
		
	}
	

}
