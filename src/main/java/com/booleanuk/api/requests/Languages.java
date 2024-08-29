package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("languages")
public class Languages {
    private List<Language> languages = new ArrayList<>() {{
        add(new Language("Java"));
        add(new Language("C#"));
    }};

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Language create(@RequestBody Language language) {
        this.languages.add(language);

        return language;
    }

    @GetMapping
    public List<Language> getAll() {
        return this.languages;
    }

    @GetMapping("{name}")
    public Language get(@PathVariable String name) {
        for (int i = 0; i < this.languages.size(); ++i) {
            if (this.languages.get(i).getName().equals(name)) return this.languages.get(i);
        }
        return null;
    }

    @PutMapping("{name}")
    public Language update(@PathVariable String name, @RequestBody Language language) {
        for (int i = 0; i < this.languages.size(); ++i) {
            if (this.languages.get(i).getName().equals(name)) {
                this.languages.get(i).setName(language.getName());
                return this.languages.get(i);
            }
        }
        return null;
    }

    @DeleteMapping("{name}")
    public Language delete(@PathVariable String name) {
        for (int i = 0; i < this.languages.size(); ++i) {
            if (this.languages.get(i).getName().equals(name)) return this.languages.remove(i);
        }
        return null;
    }

}
