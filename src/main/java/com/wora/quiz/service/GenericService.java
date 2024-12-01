package com.wora.quiz.service;

import java.util.List;

public interface GenericService <CREATE_DTO,UPDATE_DTO,DTO,ID>{
    DTO save(CREATE_DTO dto);
    DTO update(UPDATE_DTO dto, ID id);
//    DTO getById(ID id);
//    List<DTO> getAll();
//    void delete(ID id);
}
