package com.learnSQL.mayank.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.learnSQL.mayank.domain.Repositories;
import com.learnSQL.mayank.domain.Version;
import com.learnSQL.mayank.dto.VersionDto;

public class VersionDTOsToVersion {
	
	public static List<Version> Map(List<VersionDto> dtos, Repositories repositories) {
		return dtos.stream().map(element -> new Version(element.getId(), element.getFamily(), element.getName(),
				element.getUsage(), element.getVulnerabilities(), element.getDate(), element.getRepositories() )).collect(Collectors.toList());
	}
}
