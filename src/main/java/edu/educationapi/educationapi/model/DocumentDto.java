package edu.educationapi.educationapi.model;

import edu.educationapi.educationapi.domain.Section;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDto {

    private Long documentId;

    private String documentName;

    private String documentType;

    private byte[] data;

    private Section section;
}