package com.languages.demo.LanguageRepository;
import com.languages.demo.models.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();


}
