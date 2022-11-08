package com.learnSQL.mayank.config;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {
	 
    @Override
    public Optional<String> getCurrentAuditor() {
        Date date = new Date();
        return Optional.of(date.toString());
    }

}