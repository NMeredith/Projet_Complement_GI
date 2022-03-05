package com.tt.back;

import com.tt.back.entity.Nomenclature;
import com.tt.back.entity.Tva;
import com.tt.back.repository.NomenclatureRepository;
import com.tt.back.repository.TvaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Seeder {

    private static final Logger log = LoggerFactory.getLogger(Seeder.class);

    @Bean
    // Seeding de la table TVA
    public CommandLineRunner seedingTva(TvaRepository tvaRepository) {
        return args -> {
            log.info("Début du seeding de la table TVA");
            tvaRepository.save(new Tva(20f,"Taux Normal - 20%"));
            tvaRepository.save(new Tva(10f,"Taux Intermédiaire - 10%"));
            tvaRepository.save(new Tva(5.5f,"Taux Réduit - 5.5%"));
            tvaRepository.save(new Tva(2.1f,"Taux Particulier - 2.1%"));
            tvaRepository.save(new Tva(0f,"Exonération - 0%"));
            log.info("Fin du seeding de la table TVA");
        };
    }

    @Bean
    // Seeding de la table Nomenclature
    public CommandLineRunner seedingNomenclature(NomenclatureRepository nomenclatureRepository) {
        return args -> {
            log.info("Début du seeding de la table NOMENCLATURE");
            nomenclatureRepository.save(new Nomenclature("Epicerie salée"));
            nomenclatureRepository.save(new Nomenclature("Epicerie sucrée"));
            nomenclatureRepository.save(new Nomenclature("PFT"));
            nomenclatureRepository.save(new Nomenclature("Produits ménagers"));
            nomenclatureRepository.save(new Nomenclature("Textile"));
            nomenclatureRepository.save(new Nomenclature("Electronique"));
            nomenclatureRepository.save(new Nomenclature("DVD / CD"));
            nomenclatureRepository.save(new Nomenclature("Livre"));
            log.info("Fin du seeding de la table NOMENCLATURE");
        };
    }

}
