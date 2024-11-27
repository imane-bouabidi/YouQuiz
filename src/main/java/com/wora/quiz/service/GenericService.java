package com.wora.quiz.service;

import java.util.List;

public interface GenericService <CREATE_DTO,UPDATE_DTO,DTO,ID>{
    DTO create(CREATE_DTO dto);
    DTO update(UPDATE_DTO dto);
    DTO getById(ID id);
    List<DTO> getAll();
    void delete(ID id);
}
