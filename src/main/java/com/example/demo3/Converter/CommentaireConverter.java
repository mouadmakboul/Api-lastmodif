package com.example.demo3.Converter;

import com.example.demo3.Entities.CommentaireEntity.CommentaireDto;
import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentaireConverter {

    public CommentaireDto entityToDTO(CommentaireEntity commentaireEntity) {
        return new CommentaireDto() {{
            setId(commentaireEntity.getId());
            setText(commentaireEntity.getText());
            setSendDate(commentaireEntity.getSendDate());
            setWay(commentaireEntity.isWay());
            setSeen(commentaireEntity.isSeen());
            // Ajoutez d'autres propriétés de l'entité CommentaireEntity ici
        }};
    }
}
