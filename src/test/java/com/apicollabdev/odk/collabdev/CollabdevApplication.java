package com.apicollabdev.odk.collabdev;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication // Annotation principale qui indique une application Spring Boot

public class CollabdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollabdevApplication.class, args); // Démarre l'application
	}
}

// Classe marquée comme composant Spring qui s'exécute automatiquement au démarrage
@Component
class AdminInitializer implements CommandLineRunner {

	@Autowired // Injection automatique du repository des administrateurs
	private AdministrateurRepository administrateurRepository;

	// Déclaration d'un encodeur de mot de passe basé sur l'algorithme BCrypt
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public void run(String... args) {
		// Définition de l'email et du mot de passe de l'admin par défaut
		String emailAdmin = "admincollabdev@gmail.com";
		String password = "admin1234";

		// Recherche si un administrateur avec cet email existe déjà en base
		Optional<Administrateur> adminOpt = administrateurRepository.findByEmail(emailAdmin);

		// Si aucun admin trouvé, on le crée et on l'enregistre
		if (adminOpt.isEmpty()) {
			Administrateur admin = new Administrateur();
			admin.setEmail(emailAdmin);
			admin.setPassword(passwordEncoder.encode(password)); // Mot de passe hashé
			administrateurRepository.save(admin); // Sauvegarde en base

			// Affichage de confirmation dans la console
			System.out.println("Admin par défaut créé avec succès !");
			System.out.println("Identifiants :");
			System.out.println("✉ Email : " + emailAdmin);
			System.out.println("🔒 Mot de passe : " + password);
		} else {
			// Si un admin existe déjà, on affiche un message et on lance une pseudo-connexion
			System.out.println(" Un administrateur existe déjà.");
			System.out.println("Veuillez vous connecter avec vos identifiants.");
			connexionAdmin(adminOpt.get());
		}
	}

	// Méthode simulant une tentative de connexion en console
	private void connexionAdmin(Administrateur admin) {
		Scanner scanner = new Scanner(System.in);

		// Lecture de l'email saisi par l'utilisateur
		System.out.print("Entrez votre email : ");
		String emailInput = scanner.nextLine();

		// Lecture du mot de passe saisi
		System.out.print("Entrez votre mot de passe : ");
		String passwordInput = scanner.nextLine();

		// Vérification de l'email
		if (!emailInput.equals(admin.getEmail())) {
			System.out.println(" Email incorrect !");
			return;
		}

		// Vérification du mot de passe via BCrypt
		if (passwordEncoder.matches(passwordInput, admin.getPassword())) {
			System.out.println(" Connexion réussie !");
			System.out.println("BIENVENU ! " + admin.getEmail());
		} else {
			System.out.println("Mot de passe ou email incorrect !");
		}
	}
}
