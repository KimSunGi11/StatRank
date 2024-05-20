package com.example.statRank.service;

import com.example.statRank.dto.CharacterDTO;
import com.example.statRank.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO createCharacter(CharacterDTO character) {
        return characterRepository.save(character);
    }

    public List<CharacterDTO> getAllCharacters() {
        return characterRepository.findAll();
    }

    public CharacterDTO getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public CharacterDTO updateCharacter(Long id, CharacterDTO characterDetails) {
        CharacterDTO character = characterRepository.findById(id);
        if (character != null) {
            character.setName(characterDetails.getName());
            character.setImage(characterDetails.getImage());
            character.setContent(characterDetails.getContent());
            character.setStat1(characterDetails.getStat1());
            character.setStat2(characterDetails.getStat2());
            character.setStat3(characterDetails.getStat3());
            character.setStat4(characterDetails.getStat4());
            character.setStat5(characterDetails.getStat5());
            characterRepository.update(character);
            return character;
        }
        return null;
    }
}
