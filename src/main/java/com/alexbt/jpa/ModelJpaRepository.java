package com.alexbt.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelJpaRepository extends JpaRepository<Company, String> {
}