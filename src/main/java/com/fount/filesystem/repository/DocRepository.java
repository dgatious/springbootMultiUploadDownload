package com.fount.filesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fount.filesystem.model.Doc;

public interface DocRepository extends JpaRepository<Doc, Integer> {

}
